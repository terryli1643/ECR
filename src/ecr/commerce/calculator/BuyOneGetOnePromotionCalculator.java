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

public class BuyOneGetOnePromotionCalculator implements PricingCalculator {

    private PricingTools mPricingTools = CashRegister.getCashRegisterInstance().getPricingTools();



    @Override
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



    public QualifiedItem qualifier(CommerceItem pCommerceItem, Promotion pPromotion) {
        if (!pPromotion.isEnable()) {
            return null;
        }
        if (pCommerceItem.getQuantity() == 1) {
            return null;
        }
        if (pPromotion instanceof BuyOneGetOnePromotion == false) {
            return null;
        }
        if (!pPromotion.getProductIds().contains(pCommerceItem.getProductId())) {
            return null;
        }
        QualifiedItem qualifierItem = new QualifiedItem();
        qualifierItem.setQuantity(pCommerceItem.getQuantity() / 3);
        return qualifierItem;
    }



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
