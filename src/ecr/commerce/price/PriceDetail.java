package ecr.commerce.price;

public class PriceDetail {
    private int       mQuantity;
    private double    mAmount;
    private PriceInfo mDetailPriceInfo;



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
    public double getAmount() {
        return mAmount;
    }



    /**
     * @param pAmount
     *            the amount to set
     */
    public void setAmount(double pAmount) {
        mAmount = pAmount;
    }



    /**
     * @return the detailPriceInfo
     */
    public PriceInfo getDetailPriceInfo() {
        return mDetailPriceInfo;
    }



    /**
     * @param pDetailPriceInfo
     *            the detailPriceInfo to set
     */
    public void setDetailPriceInfo(PriceInfo pDetailPriceInfo) {
        mDetailPriceInfo = pDetailPriceInfo;
    }

}
