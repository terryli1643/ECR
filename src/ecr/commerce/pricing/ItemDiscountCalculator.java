package ecr.commerce.pricing;

import java.util.Map;

import ecr.commerce.order.CommerceItem;
import ecr.commerce.price.PriceInfo;
import ecr.commerce.promotion.Promotion;

public class ItemDiscountCalculator implements PricingCalculator {

    @Override
    public void priceItem(PriceInfo pPriceInfo, CommerceItem pCommerceItem, Promotion pPromotion,
            Map<String, Object> pParamMap) {
        return;
    }

    @Override
    public QualifiedItem qualifier(CommerceItem pCommerceItem, Promotion pPromotion) {
        return null;
    }
}
