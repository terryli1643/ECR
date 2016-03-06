package ecr.commerce.pricing;

import java.math.BigDecimal;
import java.util.Collection;

import ecr.commerce.calculator.PricingCalculator;
import ecr.commerce.catalog.Product;
import ecr.commerce.order.CommerceItem;
import ecr.commerce.order.OrderTools;
import ecr.commerce.price.PriceDetail;
import ecr.commerce.price.PriceInfo;
import ecr.commerce.promotion.Promotion;

/**
 * 
 * PricingEngine is used to pricing the priceInfo object for one commerceItem. It will call all calculators which
 * registered to itself.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class PricingEngine {
    private PricingCalculator[]   mCalculators;
    private Collection<Promotion> mPromotions;
    private PricingTools          mPricingTools;
    private OrderTools            mOrderTools;



    public PricingEngine(PricingCalculator... calculators) {
        mCalculators = calculators;
    }



    public void priceItem(CommerceItem pCommerceItem) {
        Product product = getOrderTools().findProductByBarcode(pCommerceItem.getProductId());
        PriceInfo info = getPricingTools().createPriceInfo(product.getUnitPrice());
        pCommerceItem.setPriceInfo(info);
        for (PricingCalculator calculator : mCalculators) {
            calculator.priceItem(info, pCommerceItem, getPromotions());
        }

        // Set priceInfo amount according to the PriceDetails.
        BigDecimal amount = new BigDecimal(0);
        for (PriceDetail priceDetail : info.getPriceDetails()) {
            amount = amount.add(priceDetail.getAmount());
        }
        info.setAmount(amount);

        // Set priceInfo saved according to the amount. unitprice * quantity - current amount
        BigDecimal save = new BigDecimal(pCommerceItem.getQuantity()).multiply(product.getUnitPrice())
                .subtract(info.getAmount());
        info.setSaved(save);
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
     * @return the promotions
     */
    public Collection<Promotion> getPromotions() {
        return mPromotions;
    }



    /**
     * @param pPromotions
     *            the promotions to set
     */
    public void setPromotions(Collection<Promotion> pPromotions) {
        mPromotions = pPromotions;
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
