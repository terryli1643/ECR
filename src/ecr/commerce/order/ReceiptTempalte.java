package ecr.commerce.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReceiptTempalte {
    private List<Item> mItems         = new ArrayList<Item>();
    private List<Item> mDiscountItems = new ArrayList<Item>();
    private BigDecimal mTotal;
    private BigDecimal mSave;



    public void print() {
        System.out.println("***<ûǮ׬�̵�>�����嵥***");
        for (Item item : mItems) {
            System.out.print("���ƣ�");
            System.out.print(item.getName());
            System.out.print(",������");
            System.out.print(item.getQuantity() + item.getUnit());
            System.out.print(",���ۣ�");
            System.out.print(item.getUnitPrice() + "(Ԫ)");
            System.out.print(",С�ƣ�");
            System.out.print(item.getSubtotal() + "(Ԫ)");
            if (item.getSave().doubleValue() > 0) {
                System.out.print(",��ʡ");
                System.out.print(item.getSave() + "(Ԫ)");
            }
            System.out.println();
        }
        System.out.println("----------------------");
        for (Item item : mDiscountItems) {
            if (item.getPromotionName() != null && item.getPromotionName().equals("BuyTwoGetOne")) {
                System.out.println("�����һ��Ʒ��");
                break;
            }
        }
        for (Item item : mDiscountItems) {
            System.out.print("���ƣ�");
            System.out.print(item.getName());
            System.out.print(",������");
            System.out.println(item.getQuantity() + item.getUnit());
        }
        System.out.println("----------------------");
        System.out.print("�ܼƣ�");
        System.out.println(mTotal + "(Ԫ)");
        System.out.print("��ʡ��");
        System.out.println(mSave + "(Ԫ)");
        System.out.println("**********************");
    }



    public Item newItem() {
        Item item = new Item();
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
    public List<Item> getItems() {
        return mItems;
    }



    /**
     * @param pItems
     *            the items to set
     */
    public void setItems(List<Item> pItems) {
        mItems = pItems;
    }



    /**
     * @return the discountItems
     */
    public List<Item> getDiscountItems() {
        return mDiscountItems;
    }



    /**
     * @param pDiscountItems
     *            the discountItems to set
     */
    public void setDiscountItems(List<Item> pDiscountItems) {
        mDiscountItems = pDiscountItems;
    }

    class Item {

        private String     mName;
        private int        mQuantity;
        private BigDecimal mUnitPrice;
        private BigDecimal mSubtotal;
        private String     mPromotionName;
        private BigDecimal mSave = new BigDecimal("0");
        private String     mUnit;



        public Item addOne() {
            Item item = new Item();
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
