package object.chap4.rdd.pricing;

import object.chap4.rdd.DiscountPolicy;
import object.chap4.rdd.Money;
import object.chap4.rdd.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
