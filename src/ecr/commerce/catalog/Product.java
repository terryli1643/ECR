package ecr.commerce.catalog;

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
    private double mUnitPrice;
    private String mCategoryName;
    private String mbarCode;



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
     * @return the categoryName
     */
    public String getCategoryName() {
        return mCategoryName;
    }



    /**
     * @param pCategoryName
     *            the categoryName to set
     */
    public void setCategoryName(String pCategoryName) {
        mCategoryName = pCategoryName;
    }



    /**
     * @return the mbarCode
     */
    public String getMbarCode() {
        return mbarCode;
    }



    /**
     * @param pMbarCode the mbarCode to set
     */
    public void setMbarCode(String pMbarCode) {
        mbarCode = pMbarCode;
    }

}
