package ecr.commerce.order;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * When the customer add product to the shoppingcart and checkout, it will be generated a settlement list object as JSON
 * output. The JSON output will send to the print receipt model, at that time the JSON will transform into a order
 * object.
 * 
 * @author: Terry
 * @version: 1.0, Mar 5, 2016
 */
public class SettlementList {
    private List<String> mBarCodeList = new ArrayList<>();


    /**
     * @return the barCodeList
     */
    public List<String> getBarCodeList() {
        return mBarCodeList;
    }



    /**
     * @param pBarCodeList
     *            the barCodeList to set
     */
    public void setBarCodeList(List<String> pBarCodeList) {
        mBarCodeList = pBarCodeList;
    }

}
