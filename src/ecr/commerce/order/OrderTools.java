package ecr.commerce.order;

import java.util.ArrayList;
import java.util.List;

import ecr.commerce.catalog.Product;
import ecr.commerce.main.CashRegister;
import ecr.commerce.order.ReceiptTempalte.PrintItem;
import ecr.commerce.price.PriceDetail;

/**
 * A utilities methods class for order.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class OrderTools {

    /**
     * 
     * This method can transform a ArrayList to a json string. This method also can be implement by the third part json
     * lib.
     *
     * @param pBarCodeList
     * @return
     */
    public String outputSettlementListASJSON(List<String> pBarCodeList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < pBarCodeList.size(); i++) {
            stringBuilder.append("'").append(pBarCodeList.get(i)).append("'");
            if (i < pBarCodeList.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }



    /**
     * 
     * Parse a json format barCode to a barcode list.
     *
     * @param pJson
     * @return
     */
    public List<String> parseJsonToList(String pJson) {
        String temp = pJson.substring(1, pJson.length() - 1);
        String[] jsonItems = temp.split(",");
        List<String> result = new ArrayList<>();
        for (String item : jsonItems) {
            result.add(item.substring(1, item.length() - 1));
        }
        return result;
    }



    /**
     * 
     * Add products to order by the product barcode list.
     *
     * @param pSettlementList
     * @param pOrder
     */
    public void addProductsToOrder(String pSettlementList, Order pOrder) {
        Product product = null;
        for (Object barCode : parseJsonToList(pSettlementList)) {
            product = findProductByBarCode((String) barCode);
            addProductToOrder(product, getProductquantityFromBarCode((String) barCode), pOrder);
        }
    }



    /**
     * 
     * Add s single product to the order.
     *
     * @param pProduct
     * @param pQuantity
     * @param pOrder
     */
    public void addProductToOrder(Product pProduct, int pQuantity, Order pOrder) {
        for (CommerceItem commerceItem : pOrder.getCommerceItems()) {
            // If current product already in the Order, just increase the quantity by 1.
            if (commerceItem.getProductId().equals(pProduct.getId())) {
                commerceItem.setQuantity(commerceItem.getQuantity() + 1);
                return;
            }
        }
        CommerceItem commerceItem = createCommerceItem(pProduct, pQuantity);
        pOrder.getCommerceItems().add(commerceItem);
    }



    /**
     * 
     * Parse the quantity from original barcode.
     *
     * @param pBarCode
     * @return
     */
    public int getProductquantityFromBarCode(String pBarCode) {
        if (pBarCode != null && pBarCode.contains("-")) {
            return Integer.parseInt(pBarCode.split("-")[1]);
        } else {
            return 1;
        }
    }



    /**
     * 
     * Parse the barcode from original barcode.
     *
     * @param pBarCode
     * @return
     */
    public Product findProductByBarCode(String pBarCode) {
        String barCode = pBarCode;
        if (pBarCode != null && pBarCode.contains("-")) {
            barCode = pBarCode.split("-")[0];
        }
        for (Product product : CashRegister.getCashRegisterInstance().mProducts.values()) {
            if (product.getBarCode().equals(barCode)) {
                return product;
            }
        }
        return null;
    }



    /**
     * 
     * Find product id by barcode.
     *
     * @param pProductId
     * @return
     */
    public Product findProductByBarcode(String pProductId) {
        for (Product product : CashRegister.getCashRegisterInstance().mProducts.values()) {
            if (product.getId().equals(pProductId)) {
                return product;
            }
        }
        return null;
    }



    /**
     * 
     * Create a order object.
     *
     * @return
     */
    public Order createOrder() {
        Order order = new Order();
        return order;
    }



    /**
     * 
     * Create a commerceItem object.
     *
     * @param pProduct
     * @param pQuantity
     * @return
     */
    public CommerceItem createCommerceItem(Product pProduct, int pQuantity) {
        CommerceItem commerceItem = new CommerceItem();
        commerceItem.setProductId(pProduct.getId());
        commerceItem.setQuantity(pQuantity);
        return commerceItem;
    }



    /**
     * 
     * Add product barcode to Settlement List.
     *
     * @param pSettlementList
     * @param pProduct
     * @param pQuantity
     */
    public void addProductToSettlementList(SettlementList pSettlementList, Product pProduct, int pQuantity) {
        String barCode = pProduct.getBarCode();
        if (pQuantity != 1) {
            barCode = pProduct.getBarCode() + "-" + pQuantity;
        }
        pSettlementList.getBarCodeList().add(barCode);
    }



    /**
     * 
     * Print Receipt.
     *
     * @param pOrder
     */
    public void printReceipt(Order pOrder) {
        if (pOrder.getCommerceItems() != null && pOrder.getCommerceItems().size() > 0) {
            ReceiptTempalte receiptTempalte = createReceiptTemplate();
            for (CommerceItem commerceItem : pOrder.getCommerceItems()) {
                Product product = findProductByBarcode(commerceItem.getProductId());
                if (product != null) {
                    // Set item property.
                    PrintItem printItem = receiptTempalte.newItem();
                    receiptTempalte.getItems().add(printItem);
                    printItem.setName(product.getDisplayName());
                    printItem.setQuantity(commerceItem.getQuantity());
                    printItem.setUnitPrice(commerceItem.getPriceInfo().getUnitPrice());
                    printItem.setSubtotal(commerceItem.getPriceInfo().getAmount());
                    printItem.setSave(commerceItem.getPriceInfo().getSaved());
                    printItem.setUnit(product.getUnit());
                    printItem.setPromotionName(findPromotionApplied(commerceItem));

                    if (commerceItem.getPriceInfo().getPriceDetails().size() > 1) {
                        // Set discounted item property.
                        PrintItem discountedPrintItem = receiptTempalte.newItem();
                        receiptTempalte.getDiscountItems().add(discountedPrintItem);
                        discountedPrintItem.setName(product.getDisplayName());
                        discountedPrintItem.setQuantity(findDiscountQuantity(commerceItem));
                        discountedPrintItem.setUnit(product.getUnit());
                        discountedPrintItem.setPromotionName(findPromotionApplied(commerceItem));
                    }
                }
            }
            receiptTempalte.setTotal(pOrder.getOrderTotal());
            receiptTempalte.setSave(pOrder.getSave());
            receiptTempalte.print();
        }
    }



    /**
     * 
     * Find the promotion id which is applied .
     *
     * @param pCommerceItem
     * @return
     */
    public String findPromotionApplied(CommerceItem pCommerceItem) {
        List<PriceDetail> priceDetails = pCommerceItem.getPriceInfo().getPriceDetails();
        for (PriceDetail priceDetail : priceDetails) {
            if (priceDetail.isDiscounted() && priceDetail.getPromotionName() != null) {
                return priceDetail.getPromotionName();
            }
        }
        return null;
    }



    /**
     * 
     * Find the quantity of commerceItem which is applied the promotion.
     *
     * @param pCommerceItem
     * @return
     */
    public int findDiscountQuantity(CommerceItem pCommerceItem) {
        List<PriceDetail> priceDetails = pCommerceItem.getPriceInfo().getPriceDetails();
        for (PriceDetail priceDetail : priceDetails) {
            if (priceDetail.isDiscounted() && priceDetail.getPromotionName() != null) {
                return priceDetail.getQuantity();
            }
        }
        return 0;
    }



    /**
     * 
     * Create receipt template object.
     *
     * @return
     */
    public ReceiptTempalte createReceiptTemplate() {
        return new ReceiptTempalte();
    }



    @org.junit.Test
    public void testOutputSettlementListASJSON() {
        OrderTools orderTools = new OrderTools();
        List<String> list = new ArrayList<String>();
        list.add("ITEM000001");
        list.add("ITEM000003-2");
        list.add("ITEM000005");
        String json = orderTools.outputSettlementListASJSON(list);
        assert(json.equals("['ITEM000001','ITEM000003-2','ITEM000005']"));
    }



    @org.junit.Test
    public void testParseJsonToList() {
        String json = "['ITEM000001','ITEM000003-2','ITEM000005']";
        OrderTools orderTools = new OrderTools();
        List<String> list = orderTools.parseJsonToList(json);
        assert(list.get(0).equals("ITEM000001"));
        assert(list.get(1).equals("ITEM000003-2"));
        assert(list.get(2).equals("ITEM000005"));
    }
}
