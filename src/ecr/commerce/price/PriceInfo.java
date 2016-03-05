package ecr.commerce.price;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This priceInfo is used for comerceItem, and this object is calculated by a lot of logics.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class PriceInfo {
    private BigDecimal        mAmount       = new BigDecimal("0");
    private BigDecimal        mSaved        = new BigDecimal("0");
    private BigDecimal        mUnitPrice    = new BigDecimal("0");
    private boolean           mDiscounted   = false;
    private List<PriceDetail> mPriceDetails = new ArrayList<>();



    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return mAmount;
    }



    /**
     * @param pAmount
     *            the amount to set
     */
    public void setAmount(BigDecimal pAmount) {
        mAmount = pAmount;
    }



    /**
     * @param pSaved
     *            the saved to set
     */
    public void setSaved(BigDecimal pSaved) {
        mSaved = pSaved;
    }



    /**
     * @return the saved
     */
    public BigDecimal getSaved() {
        return mSaved;
    }



    /**
     * @return the priceDetails
     */
    public List<PriceDetail> getPriceDetails() {
        return mPriceDetails;
    }



    /**
     * @param pPriceDetails
     *            the priceDetails to set
     */
    public void setPriceDetails(List<PriceDetail> pPriceDetails) {
        mPriceDetails = pPriceDetails;
    }



    /**
     * @return the unitPrice
     */
    public BigDecimal getUnitPrice() {
        return mUnitPrice;
    }



    /**
     * @param pUnitPrice
     *            the unitPrice to set
     */
    public void setUnitPrice(BigDecimal pUnitPrice) {
        mUnitPrice = pUnitPrice;
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
