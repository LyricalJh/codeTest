package object.chap4.rdd;

import java.time.Duration;

public class Movie {

    private final String title;
    private final Duration duration;
    private final Money fee;
    private final DiscountPolicy discountPolicy;

    public Movie (String title, Duration duration, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.duration = duration;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
