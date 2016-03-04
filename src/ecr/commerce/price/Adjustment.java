package ecr.commerce.price;

public class Adjustment {
    private String mPromotionId;
    private double mtotalAdjustment;
    private int    mQuantityAdjusted;
    private double mAdjustment;



    /**
     * @return the promotionId
     */
    public String getPromotionId() {
        return mPromotionId;
    }



    /**
     * @param pPromotionId
     *            the promotionId to set
     */
    public void setPromotionId(String pPromotionId) {
        mPromotionId = pPromotionId;
    }



    /**
     * @return the mtotalAdjustment
     */
    public double getMtotalAdjustment() {
        return mtotalAdjustment;
    }



    /**
     * @param pMtotalAdjustment
     *            the mtotalAdjustment to set
     */
    public void setMtotalAdjustment(double pMtotalAdjustment) {
        mtotalAdjustment = pMtotalAdjustment;
    }



    /**
     * @return the quantityAdjusted
     */
    public int getQuantityAdjusted() {
        return mQuantityAdjusted;
    }



    /**
     * @param pQuantityAdjusted
     *            the quantityAdjusted to set
     */
    public void setQuantityAdjusted(int pQuantityAdjusted) {
        mQuantityAdjusted = pQuantityAdjusted;
    }



    /**
     * @return the adjustment
     */
    public double getAdjustment() {
        return mAdjustment;
    }



    /**
     * @param pAdjustment
     *            the adjustment to set
     */
    public void setAdjustment(double pAdjustment) {
        mAdjustment = pAdjustment;
    }
}
