package ecr.commerce.price;

import java.util.ArrayList;
import java.util.List;

public class PriceInfo {
    private double            mAmount;
    private double            mDiscount;
    private double            mUnitPrice;
    private List<Adjustment>  mPricingAdjustment;
    private List<PriceDetail> mPriceDetails = new ArrayList<PriceDetail>(1);



    /**
     * @return the amount
     */
    public double getAmount() {
        return mAmount;
    }



    /**
     * @param pAmount
     *            the amount to set
     */
    public void setAmount(double pAmount) {
        mAmount = pAmount;
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
     * @return the pricingAdjustment
     */
    public List<Adjustment> getPricingAdjustment() {
        return mPricingAdjustment;
    }



    /**
     * @param pPricingAdjustment
     *            the pricingAdjustment to set
     */
    public void setPricingAdjustment(List<Adjustment> pPricingAdjustment) {
        mPricingAdjustment = pPricingAdjustment;
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

}
