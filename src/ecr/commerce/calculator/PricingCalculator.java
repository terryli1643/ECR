package ecr.commerce.calculator;

import java.util.Collection;

import ecr.commerce.order.CommerceItem;
import ecr.commerce.price.PriceInfo;
import ecr.commerce.promotion.Promotion;

public interface PricingCalculator {
    public abstract void priceItem(PriceInfo pPriceInfo, CommerceItem pCommerceItem, Collection<Promotion> pPromotions);
}
