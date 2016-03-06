package ecr.commerce.calculator;

import java.math.BigDecimal;
import java.util.Collection;

import ecr.commerce.main.CashRegister;
import ecr.commerce.order.CommerceItem;
import ecr.commerce.price.PriceDetail;
import ecr.commerce.price.PriceInfo;
import ecr.commerce.pricing.PricingTools;
import ecr.commerce.pricing.QualifiedItem;
import ecr.commerce.promotion.BuyOneGetOnePromotion;
import ecr.commerce.promotion.Promotion;

/**
 * 
 * This Calculator is to calculate the BuyOneGetOne Promotion.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class BuyOneGetOnePromotionCalculator implements PricingCalculator {

    private PricingTools mPricingTools = CashRegister.getCashRegisterInstance().getPricingTools();



    @Override
    /**
     * 
     * @see ecr.commerce.calculator.PricingCalculator#priceItem(ecr.commerce.price.PriceInfo,
     *      ecr.commerce.order.CommerceItem, java.util.Collection)
     */
    public void priceItem(PriceInfo pPriceInfo, CommerceItem pCommerceItem, Collection<Promotion> pPromotions) {

        if (pPromotions == null || pPromotions.size() == 0) {
            return;
        }
        for (Promotion promotion : pPromotions) {
            QualifiedItem qualifierItem = qualifier(pCommerceItem, promotion);
            if (qualifierItem != null) {
                adjust(pPriceInfo, qualifierItem, pCommerceItem, promotion);
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
    public QualifiedItem qualifier(CommerceItem pCommerceItem, Promotion pPromotion) {
        if (!pPromotion.isEnable()) {
            return null;
        }
        if (pPromotion instanceof BuyOneGetOnePromotion == false) {
            return null;
        }
        if (!pPromotion.getProductIds().contains(pCommerceItem.getProductId())) {
            return null;
        }
        BuyOneGetOnePromotion promotion = (BuyOneGetOnePromotion) pPromotion;
        // Calculate the minimun qualifier quantity, it should be DiscountConditionquantity.
        int theMinimunQualifierQuantity = promotion.getDiscountConditionquantity();
        if (pCommerceItem.getQuantity() < theMinimunQualifierQuantity) {
            return null;
        }
        QualifiedItem qualifierItem = new QualifiedItem();

        int conditionQuantity = promotion.getDiscountConditionquantity();
        int offerQuantity = promotion.getDiscountOfferquantity();
        int totalQuantity = pCommerceItem.getQuantity();
        double qualifierQuantity = 0;

        double free1 = Math.floor(totalQuantity / (conditionQuantity + offerQuantity)) * offerQuantity;
        int free2 = totalQuantity % (conditionQuantity + offerQuantity) - conditionQuantity;
        if (free2 > 0) {
            qualifierQuantity = free1 + free2;
        } else {
            qualifierQuantity = free1;
        }

        qualifierItem.setQuantity(Double.valueOf(qualifierQuantity).intValue());
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
    public void adjust(PriceInfo pPriceInfo, QualifiedItem pQualifierItem, CommerceItem pCommerceItem,
            Promotion pPromotion) {
        // Here we need to split the priceDetails into two parts, one part is the base price, the other part is free.
        PriceDetail basePriceDetail = pPriceInfo.getPriceDetails().get(0);
        basePriceDetail.setQuantity(basePriceDetail.getQuantity() - pQualifierItem.getQuantity());
        basePriceDetail.setAmount(new BigDecimal(basePriceDetail.getQuantity()).multiply(pPriceInfo.getUnitPrice()));

        // Create the second part of priceDetails which price is 0.
        PriceDetail priceDetail = getPricingTools().creatPriceDetail();
        priceDetail.setAmount(new BigDecimal("0"));
        priceDetail.setQuantity(pQualifierItem.getQuantity());
        priceDetail.setDiscounted(true);
        priceDetail.setPromotionName(pPromotion.getId());

        // Add the second part of priceDetails to the priceInfo.
        pPriceInfo.getPriceDetails().add(priceDetail);
        pPriceInfo.setDiscounted(true);
    }



    /**
     * @return the pricingTools
     */
    public PricingTools getPricingTools() {
        return mPricingTools;
    }



    /**
     * @param pPricingTools
     *            the pricingTools to set
     */
    public void setPricingTools(PricingTools pPricingTools) {
        mPricingTools = pPricingTools;
    }

}
