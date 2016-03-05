package ecr.commerce.catalog;

import java.math.BigDecimal;

/**
 * 
 * The product object. It the mimimum unit that can be bought.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class Product {

    private String mId;
    private String mDisplayName;
    private BigDecimal mUnitPrice;
    private String mCategory;
    private String mBarCode;
    private String mUnit;



    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return mDisplayName;
    }



    /**
     * @param pDisplayName
     *            the displayName to set
     */
    public void setDisplayName(String pDisplayName) {
        mDisplayName = pDisplayName;
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
     * @return the id
     */
    public String getId() {
        return mId;
    }



    /**
     * @param pId
     *            the id to set
     */
    public void setId(String pId) {
        mId = pId;
    }



    /**
     * @return the category
     */
    public String getCategory() {
        return mCategory;
    }



    /**
     * @param pCategory
     *            the category to set
     */
    public void setCategory(String pCategory) {
        mCategory = pCategory;
    }



    /**
     * @return the barCode
     */
    public String getBarCode() {
        return mBarCode;
    }



    /**
     * @param pBarCode
     *            the barCode to set
     */
    public void setBarCode(String pBarCode) {
        mBarCode = pBarCode;
    }



    /**
     * @return the unit
     */
    public String getUnit() {
        return mUnit;
    }



    /**
     * @param pUnit
     *            the unit to set
     */
    public void setUnit(String pUnit) {
        mUnit = pUnit;
    }

}
