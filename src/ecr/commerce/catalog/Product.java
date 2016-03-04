package ecr.commerce.catalog;

import java.util.Set;

/**
 * 
 * The product object. It the mimimum unit that can be bought.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class Product {

    private String      mId;
    private String      mDisplayName;
    private Set<String> mParentCategory;
    private double      mUnitPrice;
    private String      mCategoryName;



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
     * @return the parentCategory
     */
    public Set<String> getParentCategory() {
        return mParentCategory;
    }



    /**
     * @param pParentCategory
     *            the parentCategory to set
     */
    public void setParentCategory(Set<String> pParentCategory) {
        mParentCategory = pParentCategory;
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

}
