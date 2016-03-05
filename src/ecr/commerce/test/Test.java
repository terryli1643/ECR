package ecr.commerce.test;

import ecr.commerce.promotion.Promotion;
import ecr.commerce.server.ApplicationContext;

public class Test {

    @org.junit.Test
    public void test1() {
        // 当购买的商品中，有符合“买二赠一”优惠条件的商品时：
        ApplicationContext context = new ApplicationContext();
        context.initContext();

        // Here the "Buy two get one" promotion set to all products but only cocacola and badminton are applied.
        Promotion buyTwoGetOne = context.getPromotions().get("BuyTwoGetOne");
        buyTwoGetOne.getSkuIds().add("cocacola");
        buyTwoGetOne.getSkuIds().add("badminton");
        buyTwoGetOne.getSkuIds().add("apple");
        buyTwoGetOne.setEnable(true);

        CustomerAction customerAction = new CustomerAction(context);
        customerAction.buyCocacola(3);
        customerAction.buyBadminton(5);
        customerAction.buyAppla(2);
        customerAction.checkout();
    }



    @org.junit.Test
    public void test2() {
        // 当购买的商品中，没有符合“买二赠一”优惠条件的商品时：
        ApplicationContext context = new ApplicationContext();
        context.initContext();
        // Here has no promotion enabled.
        CustomerAction customerAction = new CustomerAction(context);
        customerAction.buyCocacola(3);
        customerAction.buyBadminton(5);
        customerAction.buyAppla(2);
        customerAction.checkout();
    }



    @org.junit.Test
    public void test3() {
        // 当购买的商品中，有符合“95折”优惠条件的商品时:
        ApplicationContext context = new ApplicationContext();
        context.initContext();
        // Here the "95% discount" promotion set to apple product.
        Promotion ninetyFivePercentDiscount = context.getPromotions().get("95%Discount");
        ninetyFivePercentDiscount.getSkuIds().add("apple");
        ninetyFivePercentDiscount.setEnable(true);

        CustomerAction customerAction = new CustomerAction(context);
        customerAction.buyCocacola(3);
        customerAction.buyBadminton(5);
        customerAction.buyAppla(2);
        customerAction.checkout();
    }



    @org.junit.Test
    public void test4() {
        // 当购买的商品中，有符合“95折”优惠条件的商品，又有符合“买二赠一”优惠条件的商品时
        ApplicationContext context = new ApplicationContext();
        context.initContext();
        // Here the "Buy two get one" promotion set to all products. And the "95% discount" promotion set to apple
        // product.
        Promotion buyTwoGetOne = context.getPromotions().get("BuyTwoGetOne");
        buyTwoGetOne.getSkuIds().add("cocacola");
        buyTwoGetOne.getSkuIds().add("badminton");
        buyTwoGetOne.getSkuIds().add("apple");
        buyTwoGetOne.setEnable(true);
        Promotion ninetyFivePercentDiscount = context.getPromotions().get("95%Discount");
        ninetyFivePercentDiscount.getSkuIds().add("apple");
        ninetyFivePercentDiscount.setEnable(true);

        CustomerAction customerAction = new CustomerAction(context);
        customerAction.buyCocacola(3);
        customerAction.buyBadminton(6);
        customerAction.buyAppla(2);
        customerAction.checkout();
    }
}
