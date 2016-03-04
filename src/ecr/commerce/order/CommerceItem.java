package ecr.commerce.order;

import ecr.commerce.price.PriceInfo;

public class CommerceItem {
    private String    mSkuId;
    private PriceInfo mPriceInfo;
    private int       mQuantity;



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
     * @return the priceInfo
     */
    public PriceInfo getPriceInfo() {
        return mPriceInfo;
    }



    /**
     * @param pPriceInfo
     *            the priceInfo to set
     */
    public void setPriceInfo(PriceInfo pPriceInfo) {
        mPriceInfo = pPriceInfo;
    }



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
}
