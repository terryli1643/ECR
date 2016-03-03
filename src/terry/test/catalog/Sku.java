package terry.test.catalog;

import java.util.Set;

public class Sku {

    private String      mSkuId;
    private String      mDisplayName;
    private Set<String> mParentCategory;



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

}
