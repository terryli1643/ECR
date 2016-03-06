package ecr.commerce.pricing;

import java.math.BigDecimal;

import ecr.commerce.price.PriceDetail;
import ecr.commerce.price.PriceInfo;

/**
 * A utilities methods class for pricing.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class PricingTools {

    /**
     * 
     * Create a priceDetail instance.
     *
     * @return
     */
    public PriceDetail creatPriceDetail() {
        return new PriceDetail();
    }



    /**
     * 
     * Create a priceInfo instance by a basic pirce.
     *
     * @param pBasicPrice
     * @return
     */
    public PriceInfo createPriceInfo(BigDecimal pBasicPrice) {
        PriceInfo priceInfo = new PriceInfo();
        priceInfo.setUnitPrice(pBasicPrice);
        return priceInfo;
    }

}
