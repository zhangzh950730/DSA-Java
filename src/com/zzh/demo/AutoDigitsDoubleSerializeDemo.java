package com.zzh.demo;

import javax.lang.model.SourceVersion;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;

/**
 * @author ZhangZhiHao
 */
public class AutoDigitsDoubleSerializeDemo {
    public static void main(String[] args) {
        Double[] value = new Double[]{1.0, 1.001, 1.0001, 1.00001, 1.0000013, 1.00000017};
        for (Double aDouble : value) {
            final String s2 = String.valueOf(aDouble).split("\\.")[1];
            if (s2.length() <= 2) {
                DecimalFormat df = new DecimalFormat("0.00");
                System.out.println("aDouble = " + aDouble);
                System.out.println("df.format(aDouble) = " + df.format(aDouble));
            } else {
                StringBuilder pattern = new StringBuilder("0.");
                final byte[] bytes = s2.getBytes();
                final int length = bytes.length;
                for (int i = 0; i < length; i++) {
                    pattern.append("0");
                    if (bytes[i] != '0') {
                        if (i + 1 < length && bytes[i + 1] != '0') {
                            pattern.append("0");
                        }
                        break;
                    }
                }
                DecimalFormat df = new DecimalFormat(pattern.toString());
                System.out.println("aDouble = " + aDouble);
                System.out.println("df.format(aDouble) = " + df.format(aDouble));
            }
        }
    }
}
