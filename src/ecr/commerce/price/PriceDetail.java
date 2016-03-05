package ecr.commerce.price;

/**
 * 
 * This PriceDetail object used to save every change of price by a price calculator.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class PriceDetail {
    private int     mQuantity;
    private double  mAmount;
    private boolean mDiscounted;



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

}
