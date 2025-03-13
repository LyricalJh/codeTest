package object.chap4.rdd.pricing;

import object.chap4.rdd.DiscountCondition;
import object.chap4.rdd.DiscountPolicy;
import object.chap4.rdd.Money;
import object.chap4.rdd.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {

    private final double percentage;

    public PercentDiscountPolicy(double percentage, DiscountCondition ... conditions) {
        super(conditions);
        this.percentage = percentage;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percentage);
    }
}
