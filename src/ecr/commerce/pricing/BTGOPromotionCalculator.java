package ecr.commerce.pricing;

import java.util.Map;

import ecr.commerce.order.CommerceItem;
import ecr.commerce.price.PriceInfo;
import ecr.commerce.promotion.Promotion;

public class BTGOPromotionCalculator implements PricingCalculator {

    @Override
    public void priceItem(PriceInfo pPriceInfo, CommerceItem pCommerceItem, Promotion pPromotion,
            Map<String, Object> pParameters) {
        QualifiedItem qualifierItem = qualifier(pCommerceItem, pPromotion);
        
        if (qualifierItem != null) {
            
        }
    }

    @Override
    public QualifiedItem qualifier(CommerceItem pCommerceItem, Promotion pPromotion){
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
    
}


