package org.zodiac.algorithms.dtw;

public class DefaultDistance implements Distance {
    public double getDistance(double a, double b) {
        return Math.abs(a - b);
    }
}
