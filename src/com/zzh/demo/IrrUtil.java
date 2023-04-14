package com.zzh.demo;

import java.util.ArrayList;
import java.util.List;

public class IrrUtil {
    public static double irr(double[] values) {
        return irr(values, 0.1);
    }

    public static double irr(double[] values, double guess) {
        int maxIterationCount = 25;
        double absoluteAccuracy = 1.0E-007D;

        double x0 = guess;

        int i = 0;
        while (i < maxIterationCount) {
            double fValue = 0.0D;
            double fDerivative = 0.0D;
            for (int k = 0; k < values.length; k++) {
                fValue += values[k] / Math.pow(1.0D + x0, k);
                fDerivative += -k * values[k] / Math.pow(1.0D + x0, k + 1);
            }
            double x1 = x0 - fValue / fDerivative;
            if (Math.abs(x1 - x0) <= absoluteAccuracy) {
                return x1;
            }
            x0 = x1;
            i++;
        }
        return (Double.NaN);
    }

    public static double NPV(List<Double> flowInArr, double rate) {
        double sum = 0.0;
        for (int i = 0; i < flowInArr.size(); i++) {
            sum += flowInArr.get(i) / Math.pow(1 + rate, i + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        double[] income = {
                -2803.82,
                697.39,
                692.81,
                688.21,
                645.52,
                588.32,
                584.31,
                580.30,
                576.31,
                572.31,
                568.30,
                564.30,
                560.30,
                556.29,
                552.29,
                -108.22,
                544.28,
                540.30,
                536.28,
                532.28,
                528.28,
                524.28,
                520.27,
                516.27,
                512.27,
                508.27
        };
        double irr = irr(income);
        System.out.println("irr = " + irr);

        List<Double> flowInArr = new ArrayList<>();
        flowInArr.add(697.39);
        flowInArr.add(692.81);
        flowInArr.add(688.21);
        flowInArr.add(645.52);
        flowInArr.add(588.32);
        flowInArr.add(584.31);
        flowInArr.add(580.30);
        flowInArr.add(576.31);
        flowInArr.add(572.31);
        flowInArr.add(568.30);
        flowInArr.add(564.30);
        flowInArr.add(560.30);
        flowInArr.add(556.29);
        flowInArr.add(552.29);
        flowInArr.add(-108.22);
        flowInArr.add(544.28);
        flowInArr.add(540.30);
        flowInArr.add(536.28);
        flowInArr.add(532.28);
        flowInArr.add(528.28);
        flowInArr.add(524.28);
        flowInArr.add(520.27);
        flowInArr.add(516.27);
        flowInArr.add(512.27);
        flowInArr.add(508.27);
        final double npv = NPV(flowInArr, 0.06) - 2803.82;
        System.out.println("npv = " + npv);
    }
}

