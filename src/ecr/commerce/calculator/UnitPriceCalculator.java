package ecr.commerce.calculator;

import java.util.Map;

import ecr.commerce.order.CommerceItem;
import ecr.commerce.price.PriceDetail;
import ecr.commerce.price.PriceInfo;
import ecr.commerce.pricing.PricingTools;
import ecr.commerce.pricing.QualifiedItem;
import ecr.commerce.promotion.Promotion;

/**
 * 
 * This Calculator is to set the base price for the pricing.
 * This Calculator always be calls as the first Calculator by the PricingEngine. 
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class UnitPriceCalculator implements PricingCalculator {
    
    private PricingTools mPricingTools;

    @Override
    public void priceItem(PriceInfo pPriceInfo, CommerceItem pCommerceItem, Promotion pPromotion,
            Map<String, Object> pParameters) {
        adjust(pPriceInfo, null, pCommerceItem, pPromotion);
    }



    @Override
    public QualifiedItem qualifier(CommerceItem pCommerceItem, Promotion pPromotion) {
        return null;
    }



    @Override
    public void adjust(PriceInfo pPriceInfo, QualifiedItem pQualifierItem, CommerceItem pCommerceItem,
            Promotion pPromotion) {
        PriceDetail priceDetail = getPricingTools().creatPriceDetail();
        priceDetail.setAmount(pCommerceItem.getPriceInfo().getUnitPrice());
        pPriceInfo.getPriceDetails().add(priceDetail);
    }



    /**
     * @return the pricingTools
     */
    public PricingTools getPricingTools() {
        return mPricingTools;
    }



    /**
     * @param pPricingTools the pricingTools to set
     */
    public void setPricingTools(PricingTools pPricingTools) {
        mPricingTools = pPricingTools;
    }

}
