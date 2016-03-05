package ecr.commerce.promotion;

public class ItemDiscountPromotion extends Promotion {
    private int mDiscount;

    /**
     * @return the discount
     */
    public int getDiscount() {
        return mDiscount;
    }

    /**
     * @param pDiscount the discount to set
     */
    public void setDiscount(int pDiscount) {
        mDiscount = pDiscount;
    }
}
