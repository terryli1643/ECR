package terry.test.pricing;

public class Price {
    private String mSkuId;
    private double mListPrice;



    /**
     * @return the skuId
     */
    public String getSkuId() {
        return mSkuId;
    }



    /**
     * @param pSkuId
     *            the skuId to set
     */
    public void setSkuId(String pSkuId) {
        mSkuId = pSkuId;
    }



    /**
     * @return the listPrice
     */
    public double getListPrice() {
        return mListPrice;
    }



    /**
     * @param pListPrice
     *            the listPrice to set
     */
    public void setListPrice(double pListPrice) {
        mListPrice = pListPrice;
    }
}
