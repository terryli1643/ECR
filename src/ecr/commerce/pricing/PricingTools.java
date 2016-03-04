package ecr.commerce.pricing;

import ecr.commerce.price.PriceDetail;
import ecr.commerce.price.PriceInfo;

public class PricingTools {

    public PriceDetail creatPriceDetail() {
        return new PriceDetail();
    }



    public PriceInfo createPriceInfo() {
        return new PriceInfo();
    }



    public double findUnitPriceOfSku(String pSkuId) {
        return 0d;
    }
}
