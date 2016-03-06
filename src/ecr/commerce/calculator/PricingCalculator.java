package ecr.commerce.calculator;

import java.util.Collection;

import ecr.commerce.order.CommerceItem;
import ecr.commerce.price.PriceInfo;
import ecr.commerce.promotion.Promotion;

public interface PricingCalculator {
    /**
     * 
     * The basic method to price a commerceItem. If some promotion applied, it will generate a PriceDetail object
     * related to the promotion and set it to the priceInfo.priceDetails.
     *
     * @param pPriceInfo PriceInfo
     * @param pCommerceItem CommerceItem
     * @param pPromotions Promotions
     */
    public abstract void priceItem(PriceInfo pPriceInfo, CommerceItem pCommerceItem, Collection<Promotion> pPromotions);
}
