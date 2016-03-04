package ecr.commerce.calculator;

import java.util.Map;

import ecr.commerce.order.CommerceItem;
import ecr.commerce.price.PriceInfo;
import ecr.commerce.pricing.QualifiedItem;
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



    @Override
    public void adjust(PriceInfo pPriceInfo, QualifiedItem pQualifierItem, CommerceItem pCommerceItem,
            Promotion pPromotion) {
        // TODO Auto-generated method stub
        
    }
}
