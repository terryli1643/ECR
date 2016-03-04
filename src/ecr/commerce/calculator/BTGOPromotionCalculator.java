package ecr.commerce.calculator;

import java.util.Map;

import ecr.commerce.order.CommerceItem;
import ecr.commerce.price.PriceDetail;
import ecr.commerce.price.PriceInfo;
import ecr.commerce.pricing.PricingTools;
import ecr.commerce.pricing.QualifiedItem;
import ecr.commerce.promotion.Promotion;

public class BTGOPromotionCalculator implements PricingCalculator {

    private PricingTools mPricingTools;



    @Override
    public void priceItem(PriceInfo pPriceInfo, CommerceItem pCommerceItem, Promotion pPromotion,
            Map<String, Object> pParameters) {
        QualifiedItem qualifierItem = qualifier(pCommerceItem, pPromotion);

        if (qualifierItem != null) {
            adjust(pPriceInfo, qualifierItem, pCommerceItem, pPromotion);
        }
    }



    @Override
    public QualifiedItem qualifier(CommerceItem pCommerceItem, Promotion pPromotion) {
        if (pCommerceItem.getQuantity() == 1) {
            return null;
        }
        if (!pPromotion.getSkuIds().contains(pCommerceItem.getSkuId())) {
            return null;
        }
        QualifiedItem qualifierItem = new QualifiedItem();
        qualifierItem.setQuantity(pCommerceItem.getQuantity() / 3);
        return qualifierItem;
    }



    public void adjust(PriceInfo pPriceInfo, QualifiedItem pQualifierItem, CommerceItem pCommerceItem,
            Promotion pPromotion) {
        pQualifierItem.getQuantity();

        PriceDetail priceDetail = getPricingTools().creatPriceDetail();
        priceDetail.setAmount(pPriceInfo.getUnitPrice() * pQualifierItem.getDiscount());
        priceDetail.setQuantity(pQualifierItem.getQuantity());
        pPriceInfo.getPriceDetails().add(priceDetail);
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
