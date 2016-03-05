package ecr.commerce.server;

import java.util.HashMap;
import java.util.Map;

import ecr.commerce.calculator.BuyOneGetOnePromotionCalculator;
import ecr.commerce.calculator.ItemDiscountCalculator;
import ecr.commerce.calculator.UnitPriceCalculator;
import ecr.commerce.catalog.Product;
import ecr.commerce.order.OrderTools;
import ecr.commerce.pricing.PricingEngine;
import ecr.commerce.pricing.PricingTools;
import ecr.commerce.promotion.BuyOneGetOnePromotion;
import ecr.commerce.promotion.ItemDiscountPromotion;
import ecr.commerce.promotion.Promotion;

/**
 * 
 * This class simulate a server context, when the server startup, some application level entities will be initiated. And
 * this class also is a factory class for these entities.
 * 
 * @author: Terry
 * @version: 1.0, Mar 4, 2016
 */
public class ApplicationContext {
    private PricingEngine          mPricingEngine;
    private Map<String, Product>   mProducts;
    private Map<String, Promotion> mPromotions;
    private PricingTools           mPricingTools = new PricingTools();
    private OrderTools             mOrderTools   = new OrderTools();



    public void initContext() {
        initProductData();
        initPromotionData();
        initPricingEngine();
    }



    public void initProductData() {
        Map<String, Product> products = new HashMap<>();
        Product cocacola = new Product();
        cocacola.setId("cocacola");
        cocacola.setDisplayName("可口可乐");
        cocacola.setUnitPrice(3);

        Product badminton = new Product();
        badminton.setId("badminton");
        badminton.setDisplayName("羽毛球");
        badminton.setUnitPrice(1);

        Product apple = new Product();
        apple.setId("apple");
        apple.setDisplayName("苹果");
        apple.setUnitPrice(5);

        products.put(cocacola.getId(), cocacola);
        products.put(badminton.getId(), badminton);
        products.put(apple.getId(), apple);

        setProducts(products);
    }



    public void initPromotionData() {
        Map<String, Promotion> promotions = new HashMap<>();
        BuyOneGetOnePromotion bogo = new BuyOneGetOnePromotion();
        bogo.setId("BuyTwoGetOne");
        bogo.setDiscountConditionQantity(2);
        bogo.setDiscountOfferQantity(1);

        ItemDiscountPromotion itemDiscount = new ItemDiscountPromotion();
        itemDiscount.setId("95%Discount");
        itemDiscount.setDiscount(95);

        promotions.put(bogo.getId(), bogo);
        promotions.put(itemDiscount.getId(), itemDiscount);

        setPromotions(promotions);
    }



    public void initPricingEngine() {
        UnitPriceCalculator unitPriceCalculator = new UnitPriceCalculator();
        BuyOneGetOnePromotionCalculator bogoCalculator = new BuyOneGetOnePromotionCalculator();
        ItemDiscountCalculator itemDiscountCalculator = new ItemDiscountCalculator();

        PricingEngine pricingEngine = new PricingEngine(unitPriceCalculator, bogoCalculator, itemDiscountCalculator);
        pricingEngine.setPromotions(getPromotions().values());
        setPricingEngine(pricingEngine);
    }



    /**
     * @return the pricingEngine
     */
    public PricingEngine getPricingEngine() {
        return mPricingEngine;
    }



    /**
     * @param pPricingEngine
     *            the pricingEngine to set
     */
    public void setPricingEngine(PricingEngine pPricingEngine) {
        mPricingEngine = pPricingEngine;
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

}
