package ecr.commerce.calculator;

import java.util.Map;

import ecr.commerce.order.CommerceItem;
import ecr.commerce.price.PriceInfo;
import ecr.commerce.pricing.QualifiedItem;
import ecr.commerce.promotion.Promotion;

public interface PricingCalculator {
    public abstract void priceItem(PriceInfo pPriceInfo, CommerceItem pCommerceItem, Promotion pPromotion,
            Map<String, Object> pParameters);



    public abstract QualifiedItem qualifier(CommerceItem pCommerceItem, Promotion pPromotion);



    public abstract void adjust(PriceInfo pPriceInfo, QualifiedItem pQualifierItem, CommerceItem pCommerceItem,
            Promotion pPromotion);
}
