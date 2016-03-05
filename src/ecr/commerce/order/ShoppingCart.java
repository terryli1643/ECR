package ecr.commerce.order;

import java.util.List;

/**
 * 
 * When the customer add product to the shoppingcart and checkout, then the shoppingCart will be transform into a
 * settlement list as JSON output. The JSON output will send to the backend system, at that time the JSON will transform
 * into a order object.
 * 
 * @author: Terry
 * @version: 1.0, Mar 5, 2016
 */
public class ShoppingCart {
    private List<String> mbarCodeList;



    /**
     * @return the mbarCodeList
     */
    public List<String> getMbarCodeList() {
        return mbarCodeList;
    }



    /**
     * @param pMbarCodeList
     *            the mbarCodeList to set
     */
    public void setMbarCodeList(List<String> pMbarCodeList) {
        mbarCodeList = pMbarCodeList;
    }
}
