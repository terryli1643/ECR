package ecr.commerce.promotion;

import java.util.Set;

public class Promotion {
    private Set<String> skuIds;

    /**
     * @return the skuIds
     */
    public Set<String> getSkuIds() {
        return skuIds;
    }

    /**
     * @param pSkuIds the skuIds to set
     */
    public void setSkuIds(Set<String> pSkuIds) {
        skuIds = pSkuIds;
    }
}
