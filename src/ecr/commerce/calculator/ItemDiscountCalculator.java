package ecr.commerce.calculator;

import java.util.Collection;

import ecr.commerce.order.CommerceItem;
import ecr.commerce.price.PriceDetail;
import ecr.commerce.price.PriceInfo;
import ecr.commerce.pricing.QualifiedItem;
import ecr.commerce.promotion.ItemDiscountPromotion;
import ecr.commerce.promotion.Promotion;

/**
 * 
 * This calculator is used to discount product, if BTGOPromotionCalculator has been applied, then this calculator won't
 * be applied.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class ItemDiscountCalculator implements PricingCalculator {

    @Override
    public void priceItem(PriceInfo pPriceInfo, CommerceItem pCommerceItem, Collection<Promotion> pPromotions) {
        if (pPromotions == null || pPromotions.size() == 0) {
            return;
        }

        for (Promotion promotion : pPromotions) {
            QualifiedItem qualifierItem = qualifier(pPriceInfo, pCommerceItem, promotion);
            if (qualifierItem != null) {
                adjust(pPriceInfo, qualifierItem, (ItemDiscountPromotion) promotion);
            }
        }
    }



    public QualifiedItem qualifier(PriceInfo pPriceInfo, CommerceItem pCommerceItem, Promotion pPromotion) {
        if (!pPromotion.isEnable()) {
            return null;
        }
        if (pPriceInfo.isDiscounted()) {
            return null;
        }
        if (pPromotion instanceof ItemDiscountPromotion == false) {
            return null;
        }
        if (!pPromotion.getSkuIds().contains(pCommerceItem.getProductId())) {
            return null;
        }
        QualifiedItem qualifierItem = new QualifiedItem();
        qualifierItem.setCommerceItem(pCommerceItem);
        qualifierItem.setQuantity(pCommerceItem.getQuantity());
        return qualifierItem;
    }



    public void adjust(PriceInfo pPriceInfo, QualifiedItem pQualifierItem, ItemDiscountPromotion pPromotion) {
        // Here we only modify the base priceDetail's price because this kind of promotion will aplly to all
        // commerceItem.
        PriceDetail priceDetail = pPriceInfo.getPriceDetails().get(0);
        priceDetail.setAmount(pPriceInfo.getUnitPrice() * pQualifierItem.getCommerceItem().getQuantity()
                * pPromotion.getDiscount() / 100);
        priceDetail.setQuantity(pQualifierItem.getQuantity());
        priceDetail.setDiscounted(true);
        pPriceInfo.getPriceDetails().add(priceDetail);
        pPriceInfo.setDiscounted(true);
    }

}
