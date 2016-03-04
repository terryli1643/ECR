package ecr.commerce.order;

import java.util.List;

/**
 * 
 * The order object which is contains all commerceItem to be bought.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class Order {
    private List<CommerceItem> mCommerceItems;



    /**
     * @return the commerceItems
     */
    public List<CommerceItem> getCommerceItems() {
        return mCommerceItems;
    }



    /**
     * @param pCommerceItems
     *            the commerceItems to set
     */
    public void setCommerceItems(List<CommerceItem> pCommerceItems) {
        mCommerceItems = pCommerceItems;
    }
}
