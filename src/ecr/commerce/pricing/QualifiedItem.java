package ecr.commerce.pricing;

/**
 * The QualifiedItem class holds information about a CommerceItem that qualifies for a discount.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class QualifiedItem {
    private int    mQuantity;
    private int    mCommerceItem;
    private double mDiscount;



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
     * @return the commerceItem
     */
    public int getCommerceItem() {
        return mCommerceItem;
    }



    /**
     * @param pCommerceItem
     *            the commerceItem to set
     */
    public void setCommerceItem(int pCommerceItem) {
        mCommerceItem = pCommerceItem;
    }



    /**
     * @return the discount
     */
    public double getDiscount() {
        return mDiscount;
    }



    /**
     * @param pDiscount
     *            the discount to set
     */
    public void setDiscount(double pDiscount) {
        mDiscount = pDiscount;
    }
}
