package ecr.commerce.pricing;

import java.math.BigDecimal;

import ecr.commerce.price.PriceDetail;
import ecr.commerce.price.PriceInfo;

public class PricingTools {

    public PriceDetail creatPriceDetail() {
        return new PriceDetail();
    }



    public PriceInfo createPriceInfo(BigDecimal pBasicPrice) {
        PriceInfo priceInfo = new PriceInfo();
        priceInfo.setUnitPrice(pBasicPrice);
        return priceInfo;
    }

}
