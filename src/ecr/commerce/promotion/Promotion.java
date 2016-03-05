package ecr.commerce.promotion;

import java.util.HashSet;
import java.util.Set;

public abstract class Promotion {
    private Set<String> mProductIds = new HashSet<>();
    private boolean     mEnable     = false;
    private String      mId;



    /**
     * @return the productIds
     */
    public Set<String> getProductIds() {
        return mProductIds;
    }



    /**
     * @param pProductIds
     *            the productIds to set
     */
    public void setProductIds(Set<String> pProductIds) {
        mProductIds = pProductIds;
    }



    /**
     * @return the enable
     */
    public boolean isEnable() {
        return mEnable;
    }



    /**
     * @param pEnable
     *            the enable to set
     */
    public void setEnable(boolean pEnable) {
        mEnable = pEnable;
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

}
