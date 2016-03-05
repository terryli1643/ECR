package ecr.commerce.calculator;

import java.math.BigDecimal;
import java.util.Collection;

import ecr.commerce.main.CashRegister;
import ecr.commerce.order.CommerceItem;
import ecr.commerce.price.PriceDetail;
import ecr.commerce.price.PriceInfo;
import ecr.commerce.pricing.PricingTools;
import ecr.commerce.promotion.Promotion;

/**
 * 
 * This Calculator is to set the base price for the pricing. This Calculator always be calls as the first Calculator by
 * the PricingEngine.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class UnitPriceCalculator implements PricingCalculator {

    private PricingTools mPricingTools = CashRegister.getCashRegisterInstance().getPricingTools();



    @Override
    public void priceItem(PriceInfo pPriceInfo, CommerceItem pCommerceItem, Collection<Promotion> pPromotion) {
        adjust(pPriceInfo, pCommerceItem);
    }



    public void adjust(PriceInfo pPriceInfo, CommerceItem pCommerceItem) {
        // Here we just set a base price to the priceDetail which used to calculate promotion price. The base price is
        // unit price.
        PriceDetail priceDetail = getPricingTools().creatPriceDetail();
        priceDetail.setAmount(
                pCommerceItem.getPriceInfo().getUnitPrice().multiply(new BigDecimal(pCommerceItem.getQuantity())));
        priceDetail.setQuantity(pCommerceItem.getQuantity());
        priceDetail.setDiscounted(false);
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
