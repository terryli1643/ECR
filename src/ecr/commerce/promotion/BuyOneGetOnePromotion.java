package ecr.commerce.promotion;

/**
 * 
 * This is a type of promotion, it has two properties which are DiscountConditionquantity and DiscountOfferquantity.
 * DiscountConditionquantity indicate how many products added to the cart, the promotion is qualified.
 * DiscountOfferquantity indicate how many product is free.
 * 
 * @author: Terry
 * @version: 1.0, Mar 4, 2016
 */
public class BuyOneGetOnePromotion extends Promotion {
    private int mDiscountConditionquantity;
    private int mDiscountOfferquantity;



    /**
     * @return the discountConditionquantity
     */
    public int getDiscountConditionquantity() {
        return mDiscountConditionquantity;
    }



    /**
     * @param pDiscountConditionquantity
     *            the discountConditionquantity to set
     */
    public void setDiscountConditionquantity(int pDiscountConditionquantity) {
        mDiscountConditionquantity = pDiscountConditionquantity;
    }



    /**
     * @return the discountOfferquantity
     */
    public int getDiscountOfferquantity() {
        return mDiscountOfferquantity;
    }



    /**
     * @param pDiscountOfferquantity
     *            the discountOfferquantity to set
     */
    public void setDiscountOfferquantity(int pDiscountOfferquantity) {
        mDiscountOfferquantity = pDiscountOfferquantity;
    }
}
