package ecr.commerce.promotion;

public class BuyOneGetOnePromotion extends Promotion{
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
