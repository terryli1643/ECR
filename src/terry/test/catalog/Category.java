package terry.test.catalog;

import java.util.Set;

public class Category {
    private String      mCategoryId;
    private String      mCategoryName;
    private Set<String> mSkuId;



    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return mCategoryId;
    }



    /**
     * @param pCategoryId
     *            the categoryId to set
     */
    public void setCategoryId(String pCategoryId) {
        mCategoryId = pCategoryId;
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
     * @return the skuId
     */
    public Set<String> getSkuId() {
        return mSkuId;
    }



    /**
     * @param pSkuId
     *            the skuId to set
     */
    public void setSkuId(Set<String> pSkuId) {
        mSkuId = pSkuId;
    }
}
