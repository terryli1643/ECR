package ecr.commerce.price;

import java.math.BigDecimal;

/**
 * 
 * This PriceDetail object used to save every change of price by a price calculator.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class PriceDetail {
    private int        mQuantity;
    private BigDecimal mAmount;
    private boolean    mDiscounted;
    private String     mPromotionName;



    /**
     * @return the quantity
     */
    public int getQuantity() {
        return mQuantity;
    }



    /**
     * @param pQuantity
     *            the quantity to set
     */
    public void setQuantity(int pQuantity) {
        mQuantity = pQuantity;
    }



    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return mAmount;
    }



    /**
     * @param pAmount
     *            the amount to set
     */
    public void setAmount(BigDecimal pAmount) {
        mAmount = pAmount;
    }



    /**
     * @return the discounted
     */
    public boolean isDiscounted() {
        return mDiscounted;
    }



    /**
     * @param pDiscounted
     *            the discounted to set
     */
    public void setDiscounted(boolean pDiscounted) {
        mDiscounted = pDiscounted;
    }



    /**
     * @return the promotionName
     */
    public String getPromotionName() {
        return mPromotionName;
    }



    /**
     * @param pPromotionName
     *            the promotionName to set
     */
    public void setPromotionName(String pPromotionName) {
        mPromotionName = pPromotionName;
    }

}
