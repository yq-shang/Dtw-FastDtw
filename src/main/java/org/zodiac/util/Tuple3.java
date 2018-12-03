package org.zodiac.util;

/**
 * @author Bodong Liu
 * <p>
 * Tuple的Java实现
 */
public class Tuple3<A, B, C> {

    private A first;
    private B second;
    private C third;

    public Tuple3(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    public C getThird() {
        return third;
    }

    public void setThird(C third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return String.format("(%1$s, %2$s, %3$s)", first, second, third);
    }
}
