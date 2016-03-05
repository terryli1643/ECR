package ecr.commerce.order;

import ecr.commerce.catalog.Product;

public class OrderTools {

    public void addProductToOrder(Product pProduct, int pQuantity, Order pOrder) {
        CommerceItem commerceItem = createCommerceItme(pProduct, pQuantity);
        pOrder.getCommerceItems().add(commerceItem);
    }



    public Order createNewOrder() {
        Order order = new Order();
        return order;
    }



    public CommerceItem createCommerceItme(Product pProduct, int pQuantity) {
        CommerceItem commerceItem = new CommerceItem();
        commerceItem.setProductId(pProduct.getId());
        commerceItem.setQuantity(pQuantity);
        return commerceItem;
    }
    
}
