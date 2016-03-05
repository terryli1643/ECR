package ecr.commerce.test;

import ecr.commerce.main.CashRegister;
import ecr.commerce.order.SettlementList;

public class CustomerAction {
    private CashRegister   mCashRegister   = CashRegister.getCashRegisterInstance();
    private SettlementList mSettlementList = new SettlementList();



    public void buyCocacola(int pQuantity) {
        for (int i = 0; i < pQuantity; i++) {
            mCashRegister.mOrderTools.addProductToSettlementList(this.mSettlementList,
                    mCashRegister.mProducts.get("cocacola"), 1);
        }
    }



    public void buyBadminton(int pQuantity) {
        for (int i = 0; i < pQuantity; i++) {
            mCashRegister.mOrderTools.addProductToSettlementList(this.mSettlementList,
                    mCashRegister.mProducts.get("badminton"), 1);
        }
    }



    public void buyAppla(int pQuantity) {
        mCashRegister.mOrderTools.addProductToSettlementList(this.mSettlementList, mCashRegister.mProducts.get("apple"),
                2);
    }



    public void checkout() {
        mCashRegister.checkout(mSettlementList);
    }



    /**
     * @return the settlementList
     */
    public SettlementList getSettlementList() {
        return mSettlementList;
    }



    /**
     * @param pSettlementList
     *            the settlementList to set
     */
    public void setSettlementList(SettlementList pSettlementList) {
        mSettlementList = pSettlementList;
    }



    /**
     * @return the cashRegister
     */
    public CashRegister getCashRegister() {
        return mCashRegister;
    }



    /**
     * @param pCashRegister
     *            the cashRegister to set
     */
    public void setCashRegister(CashRegister pCashRegister) {
        mCashRegister = pCashRegister;
    }
}
