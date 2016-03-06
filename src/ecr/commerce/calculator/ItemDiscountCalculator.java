package ecr.commerce.calculator;

import java.math.BigDecimal;
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



    /**
     * 
     * Judge the current promotion if will be applied.
     *
     * @param pCommerceItem
     *            commerceItem
     * @param pPromotion
     *            promotion
     * @return QualifiedItem: this item stand for a count of commercrItems will be appleid the promotion.
     */
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
        if (!pPromotion.getProductIds().contains(pCommerceItem.getProductId())) {
            return null;
        }
        QualifiedItem qualifierItem = new QualifiedItem();
        qualifierItem.setCommerceItem(pCommerceItem);
        qualifierItem.setQuantity(pCommerceItem.getQuantity());
        return qualifierItem;
    }



    /**
     * 
     * This method is responsible for the main logic for calculating the promotion.
     *
     * @param pPriceInfo
     *            PriceInfo
     * @param pQualifierItem
     *            QualifierItem
     * @param pCommerceItem
     *            CommerceItem
     * @param pPromotion
     *            Promotion
     */
    public void adjust(PriceInfo pPriceInfo, QualifiedItem pQualifierItem, ItemDiscountPromotion pPromotion) {
        // Here we only modify the base priceDetail's price because this kind of promotion will aplly to all
        // commerceItem.
        PriceDetail priceDetail = pPriceInfo.getPriceDetails().get(0);
        // unitprice * quantity * 95%
        priceDetail.setAmount(
                pPriceInfo.getUnitPrice().multiply(new BigDecimal(pQualifierItem.getCommerceItem().getQuantity()))
                        .multiply(new BigDecimal(pPromotion.getDiscount())).divide(new BigDecimal("100")));

        priceDetail.setQuantity(pQualifierItem.getQuantity());
        priceDetail.setDiscounted(true);
        priceDetail.setPromotionName(pPromotion.getId());
        pPriceInfo.setDiscounted(true);
    }

}
