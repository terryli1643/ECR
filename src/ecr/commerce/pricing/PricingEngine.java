package ecr.commerce.pricing;

import java.util.Collection;
import java.util.List;
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
    private List<PricingCalculator> mCalculators;
    private Promotion               mPromotions;
    private PricingTools            mPricingTools;



    public PriceInfo priceItem(CommerceItem pCommerceItem, Collection<Promotion> pPromotions,
            Map<String, Object> pParameters) {
        PriceInfo priceInfo = pCommerceItem.getPriceInfo();
        if (priceInfo == null) {
            PriceInfo info = getPricingTools().createPriceInfo();
            for (PricingCalculator calculator : getCalculators()) {
                calculator.priceItem(info, pCommerceItem, getPromotions(), pParameters);
            }
            pCommerceItem.setPriceInfo(info);
        }
        return null;
    }



    /**
     * @return the calculators
     */
    public List<PricingCalculator> getCalculators() {
        return mCalculators;
    }



    /**
     * @param pCalculators
     *            the calculators to set
     */
    public void setCalculators(List<PricingCalculator> pCalculators) {
        mCalculators = pCalculators;
    }



    /**
     * @return the promotions
     */
    public Promotion getPromotions() {
        return mPromotions;
    }



    /**
     * @param pPromotions
     *            the promotions to set
     */
    public void setPromotions(Promotion pPromotions) {
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
}
