package ecr.commerce.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The order object which is contains all commerceItem to be bought.
 * 
 * @author: terryli
 * @version: 1.0, Mar 4, 2016
 */
public class Order {
    private List<CommerceItem> mCommerceItems = new ArrayList<>();
    private BigDecimal         mOrderTotal    = new BigDecimal("0");
    private BigDecimal         mSave          = new BigDecimal("0");



    /**
     * @return the orderTotal
     */
    public BigDecimal getOrderTotal() {
        if (mCommerceItems != null && mCommerceItems.size() > 0) {
            for (CommerceItem commerceItem : mCommerceItems) {
                mOrderTotal = mOrderTotal.add(commerceItem.getPriceInfo().getAmount());
            }
        }
        return mOrderTotal;
    }



    /**
     * @param pOrderTotal
     *            the orderTotal to set
     */
    public void setOrderTotal(BigDecimal pOrderTotal) {
        mOrderTotal = pOrderTotal;
    }



    /**
     * @return the save
     */
    public BigDecimal getSave() {
        if (mCommerceItems != null && mCommerceItems.size() > 0) {
            for (CommerceItem commerceItem : mCommerceItems) {
                mSave = mSave.add(commerceItem.getPriceInfo().getSaved());
            }
        }
        return mSave;
    }



    /**
     * @param pSave
     *            the save to set
     */
    public void setSave(BigDecimal pSave) {
        mSave = pSave;
    }



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
