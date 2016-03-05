package ecr.commerce.test;

import ecr.commerce.order.Order;
import ecr.commerce.server.ApplicationContext;

public class CustomerAction {
    ApplicationContext mContext;
    Order              mOrder;



    public CustomerAction(ApplicationContext pContext) {
        this.mContext = pContext;
    }



    public void createOrder() {
        this.mOrder = mContext.getOrderTools().createNewOrder();
    }



    public void buyCocacola(int pQuantity) {
        mContext.getOrderTools().addProductToOrder(mContext.getProducts().get("cocacola"), pQuantity, this.mOrder);
    }



    public void buyBadminton(int pQuantity) {
        mContext.getOrderTools().addProductToOrder(mContext.getProducts().get("badminton"), pQuantity, this.mOrder);
    }



    public void buyAppla(int pQuantity) {
        mContext.getOrderTools().addProductToOrder(mContext.getProducts().get("apple"), pQuantity, this.mOrder);
    }



    public void checkout() {
        
    }
}
