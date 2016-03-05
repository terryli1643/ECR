package ecr.commerce.pricing;

import java.util.Collection;
import java.util.Map;

import ecr.commerce.calculator.PricingCalculator;
import ecr.commerce.order.CommerceItem;
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



    public PricingEngine(PricingCalculator... calculators) {
        mCalculators = calculators;
    }



    public PriceInfo priceItem(CommerceItem pCommerceItem, Collection<Promotion> pPromotions,
            Map<String, Object> pParameters) {
        PriceInfo priceInfo = pCommerceItem.getPriceInfo();
        if (priceInfo == null) {
            PriceInfo info = getPricingTools().createPriceInfo();
            for (PricingCalculator calculator : mCalculators) {
                calculator.priceItem(info, pCommerceItem, getPromotions());
            }
            pCommerceItem.setPriceInfo(info);
        }
        return null;
    }



    /**
     * @return the pricingTools
     */
    public PricingTools getPricingTools() {
        return mPricingTools;
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
}
