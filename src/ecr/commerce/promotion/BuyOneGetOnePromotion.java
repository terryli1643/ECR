package ecr.commerce.promotion;

public class BuyOneGetOnePromotion extends Promotion{
    private int mDiscountConditionQantity;
    private int mDiscountOfferQantity;



    /**
     * @return the discountConditionQantity
     */
    public int getDiscountConditionQantity() {
        return mDiscountConditionQantity;
    }



    /**
     * @param pDiscountConditionQantity
     *            the discountConditionQantity to set
     */
    public void setDiscountConditionQantity(int pDiscountConditionQantity) {
        mDiscountConditionQantity = pDiscountConditionQantity;
    }



    /**
     * @return the discountOfferQantity
     */
    public int getDiscountOfferQantity() {
        return mDiscountOfferQantity;
    }



    /**
     * @param pDiscountOfferQantity
     *            the discountOfferQantity to set
     */
    public void setDiscountOfferQantity(int pDiscountOfferQantity) {
        mDiscountOfferQantity = pDiscountOfferQantity;
    }
}
