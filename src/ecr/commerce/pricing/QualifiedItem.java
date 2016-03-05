package ecr.commerce.pricing;

import ecr.commerce.order.CommerceItem;

/**
 * The QualifiedItem class holds information about a CommerceItem that qualifies for a discount.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class QualifiedItem {
    private int          mQuantity;
    private CommerceItem mCommerceItem;
    private double       mDiscount;



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



    /**
     * @return the commerceItem
     */
    public CommerceItem getCommerceItem() {
        return mCommerceItem;
    }



    /**
     * @param pCommerceItem
     *            the commerceItem to set
     */
    public void setCommerceItem(CommerceItem pCommerceItem) {
        mCommerceItem = pCommerceItem;
    }
}
