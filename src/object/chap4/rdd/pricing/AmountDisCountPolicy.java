package object.chap4.rdd.pricing;

import object.chap4.rdd.DiscountCondition;
import object.chap4.rdd.DiscountPolicy;
import object.chap4.rdd.Money;
import object.chap4.rdd.Screening;

public class AmountDisCountPolicy extends DiscountPolicy {

    private final Money discountAmount;

    public AmountDisCountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions); // super 부모 생성자 함수 호출 ... 넘겨주지 않는다면 empty ArrayList end of return Money ZERO
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
