package ecr.commerce.main;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ecr.commerce.calculator.BuyOneGetOnePromotionCalculator;
import ecr.commerce.calculator.ItemDiscountCalculator;
import ecr.commerce.calculator.UnitPriceCalculator;
import ecr.commerce.catalog.Product;
import ecr.commerce.order.CommerceItem;
import ecr.commerce.order.Order;
import ecr.commerce.order.OrderTools;
import ecr.commerce.order.SettlementList;
import ecr.commerce.pricing.PricingEngine;
import ecr.commerce.pricing.PricingTools;
import ecr.commerce.promotion.BuyOneGetOnePromotion;
import ecr.commerce.promotion.ItemDiscountPromotion;
import ecr.commerce.promotion.Promotion;

/**
 * 
 * This class simulate a backend system context, when the system startup, some application level entities will be
 * initiated. meantime, the backend system supply the checkout funtion and print receipt funtion.
 * 
 * @author: Terry
 * @version: 1.0, Mar 4, 2016
 */
public class CashRegister {
    private static CashRegister mCashRegister = new CashRegister();

    public Map<String, Product>   mProducts     = new HashMap<>();
    public Map<String, Promotion> mPromotions   = new HashMap<>();
    public PricingTools           mPricingTools = new PricingTools();
    public OrderTools             mOrderTools   = new OrderTools();
    public PricingEngine          mPricingEngine;



    private CashRegister() {

    }



    public static CashRegister getCashRegisterInstance() {
        if (mCashRegister == null) {
            mCashRegister = new CashRegister();
        }
        return mCashRegister;
    }



    public void start() {
        initProductData();
        initPromotionData();
        initPricingEngine();
    }



    public void checkout(SettlementList pSettlementList) {
        Order order = mOrderTools.createOrder();
        String json = mOrderTools.outputSettlementListASJSON(pSettlementList.getBarCodeList());
        System.out.println(json);

        mOrderTools.addProductsToOrder(json, order);
        for (CommerceItem commerceItem : order.getCommerceItems()) {
            mPricingEngine.priceItem(commerceItem);
        }
        mOrderTools.printReceipt(order);
    }



    private void initProductData() {
        Product cocacola = new Product();
        cocacola.setId("cocacola");
        cocacola.setDisplayName("可口可乐");
        cocacola.setBarCode("ITEM000005");
        cocacola.setUnitPrice(new BigDecimal("3"));
        cocacola.setUnit("瓶");

        Product badminton = new Product();
        badminton.setId("badminton");
        badminton.setDisplayName("羽毛球");
        badminton.setBarCode("ITEM000001");
        badminton.setUnitPrice(new BigDecimal("1"));
        badminton.setUnit("个");

        Product apple = new Product();
        apple.setId("apple");
        apple.setDisplayName("苹果");
        apple.setBarCode("ITEM000003");
        apple.setUnitPrice(new BigDecimal("5.5"));
        apple.setUnit("斤");

        getProducts().put(cocacola.getId(), cocacola);
        getProducts().put(badminton.getId(), badminton);
        getProducts().put(apple.getId(), apple);

    }



    private void initPromotionData() {
        BuyOneGetOnePromotion bogo = new BuyOneGetOnePromotion();
        bogo.setId("BuyTwoGetOne");
        bogo.setDiscountConditionquantity(2);
        bogo.setDiscountOfferquantity(1);

        ItemDiscountPromotion itemDiscount = new ItemDiscountPromotion();
        itemDiscount.setId("95%Discount");
        itemDiscount.setDiscount(95);

        getPromotions().put(bogo.getId(), bogo);
        getPromotions().put(itemDiscount.getId(), itemDiscount);

    }



    private void initPricingEngine() {
        UnitPriceCalculator unitPriceCalculator = new UnitPriceCalculator();
        BuyOneGetOnePromotionCalculator bogoCalculator = new BuyOneGetOnePromotionCalculator();
        ItemDiscountCalculator itemDiscountCalculator = new ItemDiscountCalculator();

        PricingEngine pricingEngine = new PricingEngine(unitPriceCalculator, bogoCalculator, itemDiscountCalculator);
        pricingEngine.setPromotions(getPromotions().values());
        pricingEngine.setPricingTools(getPricingTools());
        pricingEngine.setOrderTools(getOrderTools());
        mPricingEngine = pricingEngine;
    }



    /**
     * @return the products
     */
    public Map<String, Product> getProducts() {
        return mProducts;
    }



    /**
     * @param pProducts
     *            the products to set
     */
    public void setProducts(Map<String, Product> pProducts) {
        mProducts = pProducts;
    }



    /**
     * @return the promotions
     */
    public Map<String, Promotion> getPromotions() {
        return mPromotions;
    }



    /**
     * @param pPromotions
     *            the promotions to set
     */
    public void setPromotions(Map<String, Promotion> pPromotions) {
        mPromotions = pPromotions;
    }



    /**
     * @return the pricingTools
     */
    public PricingTools getPricingTools() {
        return mPricingTools;
    }



    /**
     * @param pPricingTools
     *            the pricingTools to set
     */
    public void setPricingTools(PricingTools pPricingTools) {
        mPricingTools = pPricingTools;
    }



    /**
     * @return the orderTools
     */
    public OrderTools getOrderTools() {
        return mOrderTools;
    }



    /**
     * @param pOrderTools
     *            the orderTools to set
     */
    public void setOrderTools(OrderTools pOrderTools) {
        mOrderTools = pOrderTools;
    }



    /**
     * @return the mCashRegister
     */
    public static CashRegister getmCashRegister() {
        return mCashRegister;
    }



    /**
     * @param pMCashRegister
     *            the mCashRegister to set
     */
    public static void setmCashRegister(CashRegister pMCashRegister) {
        mCashRegister = pMCashRegister;
    }
}
