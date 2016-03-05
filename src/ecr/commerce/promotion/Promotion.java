package ecr.commerce.promotion;

import java.util.Set;

public abstract class Promotion {
    private Set<String> mSkuIds;
    private boolean     mEnable = false;
    private String      mId;



    /**
     * @return the skuIds
     */
    public Set<String> getSkuIds() {
        return mSkuIds;
    }



    /**
     * @param pSkuIds
     *            the skuIds to set
     */
    public void setSkuIds(Set<String> pSkuIds) {
        mSkuIds = pSkuIds;
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
