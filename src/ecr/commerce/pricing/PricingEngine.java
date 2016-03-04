package ecr.commerce.pricing;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import ecr.commerce.order.CommerceItem;
import ecr.commerce.price.PriceInfo;
import ecr.commerce.promotion.Promotion;

public class PricingEngine {
    private List<PricingCalculator> mCalculators;
    private Promotion mPromotions;


    public PriceInfo priceItem(CommerceItem pCommerceItem, Collection<Promotion> pPromotions,
            Map<String, Object> pParameters) {
        PriceInfo priceInfo = pCommerceItem.getPriceInfo();
        if (priceInfo == null) {
            PriceInfo info = (PriceInfo)createPriceInfo();
            for (PricingCalculator calculator : getCalculators()) {
                calculator.priceItem(priceInfo, pCommerceItem, getPromotions(), pParameters);
            }
        }
        return null;
    }
    
    private PriceInfo createPriceInfo(){
        return new PriceInfo();
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
     * @param pPromotions the promotions to set
     */
    public void setPromotions(Promotion pPromotions) {
        mPromotions = pPromotions;
    }
}