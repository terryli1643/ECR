package ecr.commerce.order;

import java.util.ArrayList;
import java.util.List;

import ecr.commerce.catalog.Product;
import ecr.commerce.main.CashRegister;
import ecr.commerce.order.ReceiptTempalte.Item;
import ecr.commerce.price.PriceDetail;

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



    public List<String> parseJsonToList(String pJson) {
        String temp = pJson.substring(1, pJson.length() - 1);
        String[] jsonItems = temp.split(",");
        List<String> result = new ArrayList<>();
        for (String item : jsonItems) {
            result.add(item.substring(1, item.length() - 1));
        }
        return result;
    }



    public void addProductsToOrder(String pSettlementList, Order pOrder) {
        Product product = null;
        for (Object barCode : parseJsonToList(pSettlementList)) {
            product = findProductByBarCode((String) barCode);
            addProductToOrder(product, getProductquantityFromBarCode((String) barCode), pOrder);
        }
    }



    public void addProductToOrder(Product pProduct, int pQuantity, Order pOrder) {
        for (CommerceItem commerceItem : pOrder.getCommerceItems()) {
            // If current product already in the Order, just increase the quantity by 1.
            if (commerceItem.getProductId().equals(pProduct.getId())) {
                commerceItem.setQuantity(commerceItem.getQuantity() + 1);
                return;
            }
        }
        CommerceItem commerceItem = createCommerceItme(pProduct, pQuantity);
        pOrder.getCommerceItems().add(commerceItem);
    }



    public int getProductquantityFromBarCode(String pBarCode) {
        if (pBarCode != null && pBarCode.contains("-")) {
            return Integer.parseInt(pBarCode.split("-")[1]);
        } else {
            return 1;
        }
    }



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



    public Product findProductByBarId(String pProductId) {
        for (Product product : CashRegister.getCashRegisterInstance().mProducts.values()) {
            if (product.getId().equals(pProductId)) {
                return product;
            }
        }
        return null;
    }



    public Order createOrder() {
        Order order = new Order();
        return order;
    }



    public CommerceItem createCommerceItme(Product pProduct, int pQuantity) {
        CommerceItem commerceItem = new CommerceItem();
        commerceItem.setProductId(pProduct.getId());
        commerceItem.setQuantity(pQuantity);
        return commerceItem;
    }



    public void addProductToSettlementList(SettlementList pSettlementList, Product pProduct, int pQuantity) {
        String barCode = pProduct.getBarCode();
        if (pQuantity != 1) {
            barCode = pProduct.getBarCode() + "-" + pQuantity;
        }
        pSettlementList.getBarCodeList().add(barCode);
    }



    public void printReceipt(Order pOrder) {
        if (pOrder.getCommerceItems() != null && pOrder.getCommerceItems().size() > 0) {
            ReceiptTempalte receiptTempalte = createReceiptTempalte();
            for (CommerceItem commerceItem : pOrder.getCommerceItems()) {
                Product product = findProductByBarId(commerceItem.getProductId());
                if (product != null) {
                    // Set item property.
                    Item item = receiptTempalte.newItem();
                    receiptTempalte.getItems().add(item);
                    item.setName(product.getDisplayName());
                    item.setQuantity(commerceItem.getQuantity());
                    item.setUnitPrice(commerceItem.getPriceInfo().getUnitPrice());
                    item.setSubtotal(commerceItem.getPriceInfo().getAmount());
                    item.setSave(commerceItem.getPriceInfo().getSaved());
                    item.setUnit(product.getUnit());
                    item.setPromotionName(commerceItem.getPriceInfo().getPriceDetails().get(0).getPromotionName());
                    if (commerceItem.getPriceInfo().getPriceDetails().size() > 1) {
                        PriceDetail priceDetail = commerceItem.getPriceInfo().getPriceDetails().get(1);
                        // Set discounted item property.
                        Item discountedItem = receiptTempalte.newItem();
                        receiptTempalte.getDiscountItems().add(discountedItem);
                        discountedItem.setName(product.getDisplayName());
                        discountedItem.setQuantity(priceDetail.getQuantity());
                        discountedItem.setUnit(product.getUnit());
                        discountedItem.setPromotionName(priceDetail.getPromotionName());
                    }
                }
            }
            receiptTempalte.setTotal(pOrder.getOrderTotal());
            receiptTempalte.setSave(pOrder.getSave());
            receiptTempalte.print();
        }
    }



    public ReceiptTempalte createReceiptTempalte() {
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
