package br.com.cateno.sdk.util;

import java.util.Random;

public class CNPJCreator {

    public static String featchCNPJWithOutDigit() {

        StringBuilder numbersConcat = new StringBuilder();

        int dig1, dig2, rest;
        String nDigResult;
        String numberGenerated;
        Random numberAleatory = new Random();

        // generated numbers
        int n1 = numberAleatory.nextInt(10);
        int n2 = numberAleatory.nextInt(10);
        int n3 = numberAleatory.nextInt(10);
        int n4 = numberAleatory.nextInt(10);
        int n5 = numberAleatory.nextInt(10);
        int n6 = numberAleatory.nextInt(10);
        int n7 = numberAleatory.nextInt(10);
        int n8 = numberAleatory.nextInt(10);
        int n9 = numberAleatory.nextInt(10);
        int n10 = numberAleatory.nextInt(10);
        int n11 = numberAleatory.nextInt(10);
        int n12 = numberAleatory.nextInt(10);
        int sum = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4 + n1 * 5;
        int value = (sum / 11) * 11;
        dig1 = sum - value;
        // first rest of division by 11
        rest = (dig1 % 11);

        dig1 = (dig1 < 2 ? 0 : 11 - rest);

        int sum2 = dig1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4 + n2 * 5 + n1 * 6;
        int value2 = (sum2 / 11) * 11;
        dig2 = sum2 - value2;
        // first rest of division by 11
        rest = (dig2 % 11);

        dig2 = (dig2 < 2 ? 0 : 11 - rest);

        // concat numbers without mask
        numbersConcat
                .append(n1)
                .append(n2)
                .append(n3)
                .append(n4)
                .append(n5)
                .append(n6)
                .append(n7)
                .append(n8)
                .append(n9)
                .append(n10)
                .append(n11)
                .append(n12);

        // concat first rest with second
        nDigResult = String.format("%d%d", dig1, dig2);
        numberGenerated = numbersConcat + nDigResult;

        return numberGenerated;
    }
}
