package org.zodiac.algorithms.dtw;

import org.zodiac.util.Tuple2;

import java.util.ArrayList;

public class Dtw {

    public static void main(String[] args) {
        double[] a = new double[]{2, 3, 4, 8, 9, 10};
        double[] b = new double[]{1, 3, 4, 5, 7};
        Tuple2<Double, ArrayList<Tuple2<Integer, Integer>>> result = dtw(a, b, null, new DefaultDistance());
        System.out.println(result.getFirst());
        ArrayList<Tuple2<Integer, Integer>> path = result.getSecond();
        for (Tuple2<Integer, Integer> tuple2 : path) {
            System.out.println(tuple2);
        }
    }

    public static Tuple2<Double, ArrayList<Tuple2<Integer, Integer>>> dtw(double[] x, double[] y, double[][] window, Distance distance) {
        if (null == window) {
            window = new double[x.length][y.length];
        }

        double[][] distanceMatrix = new double[window.length][window[0].length];
        for (int i = 0; i < window.length; i++) {
            for (int j = 0; j < window[i].length; j++) {
                double dt = distance.getDistance(x[i], y[j]);
                distanceMatrix[i][j] = dt;
            }
        }

        ArrayList<Tuple2<Integer, Integer>> path = new ArrayList<Tuple2<Integer, Integer>>();
        double[][] costMatrix = new double[window.length][window[0].length];
        for (int i = 0; i < costMatrix.length; i++) {
            for (int j = 0; j < costMatrix[i].length; j++) {
                int i1 = i - 1 < 0 ? 0 : i - 1;
                int j1 = j - 1 < 0 ? 0 : j - 1;
                Tuple2 tuple2 = null;
                double min = 0D;
                //左下
                double a = costMatrix[i1][j1];
                //左
                double b = costMatrix[i][j1];
                //下
                double c = costMatrix[i1][j];
                if (a <= b && a <= c) {
                    tuple2 = new Tuple2<Integer, Integer>(i1, j1);
                    min = a;
                } else if (b <= a && b <= c) {
                    tuple2 = new Tuple2<Integer, Integer>(i, j1);
                    min = b;
                } else if (c <= a && c <= b) {
                    tuple2 = new Tuple2<Integer, Integer>(i1, j);
                    min = c;
                }
                costMatrix[i][j] = min + distanceMatrix[i][j];
            }
        }

//        int i = x.length, j = y.length;
//        while (i > 0 || j > 0) {
//            double tb =
//        }

        Tuple2<Double, ArrayList<Tuple2<Integer, Integer>>> result = new Tuple2<Double, ArrayList<Tuple2<Integer, Integer>>>(costMatrix[window.length - 1][window[0].length - 1] / (window.length + window[0].length), path);
        return result;
    }


}
