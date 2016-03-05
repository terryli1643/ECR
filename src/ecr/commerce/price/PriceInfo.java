package ecr.commerce.price;

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
    private double            mAmount       = 0d;
    private double            mSaved        = 0d;
    private double            mUnitPrice    = 0d;
    private boolean           mDiscounted   = false;
    private List<PriceDetail> mPriceDetails = new ArrayList<>();



    /**
     * @return the amount
     */
    public double getAmount() {
        if (!getPriceDetails().isEmpty()) {
            for (PriceDetail priceDetail : mPriceDetails) {
                mAmount = mAmount + priceDetail.getQuantity() * priceDetail.getQuantity();
            }
        }
        return mAmount;
    }



    /**
     * @return the saved
     */
    public double getSaved() {
        if (!getPriceDetails().isEmpty()) {
            for (PriceDetail priceDetail : mPriceDetails) {
                if (priceDetail.isDiscounted()) {
                    mSaved = mSaved + getUnitPrice() * priceDetail.getQuantity() - priceDetail.getAmount();
                }
            }
        }
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
    public double getUnitPrice() {
        return mUnitPrice;
    }



    /**
     * @param pUnitPrice
     *            the unitPrice to set
     */
    public void setUnitPrice(double pUnitPrice) {
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
