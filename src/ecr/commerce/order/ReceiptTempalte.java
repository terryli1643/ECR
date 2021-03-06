package ecr.commerce.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is resposible for collect all information from the order and print Receipt.
 * 
 * @author: Terry
 * @version: 1.0, Mar 5, 2016
 */
public class ReceiptTempalte {
    private List<PrintItem> mItems         = new ArrayList<PrintItem>();
    private List<PrintItem> mDiscountItems = new ArrayList<PrintItem>();
    private BigDecimal      mTotal;
    private BigDecimal      mSave;



    public void print() {
        System.out.println("***<没钱赚商店>购物清单***");
        for (PrintItem item : mItems) {
            System.out.print("名称：");
            System.out.print(item.getName());
            System.out.print(",数量：");
            System.out.print(item.getQuantity() + item.getUnit());
            System.out.print(",单价：");
            System.out.print(item.getUnitPrice() + "(元)");
            System.out.print(",小计：");
            System.out.print(item.getSubtotal() + "(元)");
            if (item.getSave().doubleValue() > 0 && item.getPromotionName() != null
                    && item.getPromotionName().equals("95%Discount")) {
                System.out.print(",节省");
                System.out.print(item.getSave() + "(元)");
            }
            System.out.println();
        }
        System.out.println("----------------------");
        for (PrintItem item : mDiscountItems) {
            if (item.getPromotionName() != null && item.getPromotionName().equals("BuyTwoGetOne")) {
                System.out.println("买二赠一商品：");
                break;
            }
        }
        for (PrintItem item : mDiscountItems) {
            System.out.print("名称：");
            System.out.print(item.getName());
            System.out.print(",数量：");
            System.out.println(item.getQuantity() + item.getUnit());
        }
        System.out.println("----------------------");
        System.out.print("总计：");
        System.out.println(mTotal + "(元)");
        if (mSave.doubleValue() > 0) {
            System.out.print("节省：");
            System.out.println(mSave + "(元)");
        }

        System.out.println("**********************");
    }



    public PrintItem newItem() {
        PrintItem item = new PrintItem();
        return item;
    }



    /**
     * @return the total
     */
    public BigDecimal getTotal() {
        return mTotal;
    }



    /**
     * @param pTotal
     *            the total to set
     */
    public void setTotal(BigDecimal pTotal) {
        mTotal = pTotal;
    }



    /**
     * @return the save
     */
    public BigDecimal getSave() {
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
     * @return the items
     */
    public List<PrintItem> getItems() {
        return mItems;
    }



    /**
     * @param pItems
     *            the items to set
     */
    public void setItems(List<PrintItem> pItems) {
        mItems = pItems;
    }



    /**
     * @return the discountItems
     */
    public List<PrintItem> getDiscountItems() {
        return mDiscountItems;
    }



    /**
     * @param pDiscountItems
     *            the discountItems to set
     */
    public void setDiscountItems(List<PrintItem> pDiscountItems) {
        mDiscountItems = pDiscountItems;
    }

    class PrintItem {

        private String     mName;
        private int        mQuantity;
        private BigDecimal mUnitPrice;
        private BigDecimal mSubtotal;
        private String     mPromotionName;
        private BigDecimal mSave = new BigDecimal("0");
        private String     mUnit;



        public PrintItem addOne() {
            PrintItem item = new PrintItem();
            return item;
        }



        /**
         * @return the name
         */
        public String getName() {
            return mName;
        }



        /**
         * @param pName
         *            the name to set
         */
        public void setName(String pName) {
            mName = pName;
        }



        /**
         * @return the quantity
         */
        public int getQuantity() {
            return mQuantity;
        }



        /**
         * @param pQuantity
         *            the quantity to set
         */
        public void setQuantity(int pQuantity) {
            mQuantity = pQuantity;
        }



        /**
         * @return the unitPrice
         */
        public BigDecimal getUnitPrice() {
            return mUnitPrice;
        }



        /**
         * @param pUnitPrice
         *            the unitPrice to set
         */
        public void setUnitPrice(BigDecimal pUnitPrice) {
            mUnitPrice = pUnitPrice;
        }



        /**
         * @return the subtotal
         */
        public BigDecimal getSubtotal() {
            return mSubtotal;
        }



        /**
         * @param pSubtotal
         *            the subtotal to set
         */
        public void setSubtotal(BigDecimal pSubtotal) {
            mSubtotal = pSubtotal;
        }



        /**
         * @return the promotionName
         */
        public String getPromotionName() {
            return mPromotionName;
        }



        /**
         * @param pPromotionName
         *            the promotionName to set
         */
        public void setPromotionName(String pPromotionName) {
            mPromotionName = pPromotionName;
        }



        /**
         * @return the save
         */
        public BigDecimal getSave() {
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
         * @return the unit
         */
        public String getUnit() {
            return mUnit;
        }



        /**
         * @param pUnit
         *            the unit to set
         */
        public void setUnit(String pUnit) {
            mUnit = pUnit;
        }
    }
}
