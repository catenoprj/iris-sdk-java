package br.com.cateno.util;

import java.util.Random;

public class CNPJCreator {

    public static String featchCNPJWithOutDigit()  {
        int dig1 = 0, dig2 = 0, rest = 0;
        String  nDigResult;
        String numbersConcat;
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
        int sum = n12*2 + n11*3 + n10*4 + n9*5 + n8*6 + n7*7 + n6*8 + n5*9 + n4*2 + n3*3 + n2*4 + n1*5;
        int value = (sum / 11)*11;
        dig1 = sum-value;
        // first rest of division by 11
        rest = (dig1 % 11);
        if(dig1 < 2){
            dig1 = 0;
        }
        else {
            dig1 = 11-rest;
        }
        int sum2 =  dig1*2 + n12*3 + n11*4 + n10*5 + n9*6 + n8*7 + n7*8 + n6*9 + n5*2 + n4*3 + n3*4 + n2*5 + n1*6 ;
        int value2 = (sum2 / 11)*11;
        dig2 = sum2-value2;
        // first rest of division by 11
        rest = (dig2 % 11);
        if(dig2 < 2){
            dig2 = 0;
        }
        else {
            dig2 = 11-rest;
        }

        // concat numbers without mask
        numbersConcat = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4) +
                String.valueOf(n5) + String.valueOf(n6) + String.valueOf(n7) + String.valueOf(n8)+
                String.valueOf(n9) + String.valueOf(n10) + String.valueOf(n11) +
                String.valueOf(n12);
        // concat first rest with second
        nDigResult = String.valueOf(dig1) + String.valueOf(dig2);

        numberGenerated = numbersConcat+nDigResult;

        return numberGenerated;
    }


    public static String featchCNPJWithDigit()  {
        int dig1 = 0, dig2 = 0, rest = 0;
        String  nDigResult;
        String numbersConcat;
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
        int sum = n12*2 + n11*3 + n10*4 + n9*5 + n8*6 + n7*7 + n6*8 + n5*9 + n4*2 + n3*3 + n2*4 + n1*5;
        int value = (sum / 11)*11;
        dig1 = sum-value;
        // first rest of division by 11
        rest = (dig1 % 11);
        if(dig1 < 2){
            dig1 = 0;
        }
        else {
            dig1 = 11-rest;
        }
        int sum2 =  dig1*2 + n12*3 + n11*4 + n10*5 + n9*6 + n8*7 + n7*8 + n6*9 + n5*2 + n4*3 + n3*4 + n2*5 + n1*6 ;
        int valor2 = (sum2 / 11)*11;
        dig2 = sum2-valor2;
        // first rest of division by 11
        rest = (dig2 % 11);
        if(dig2 < 2){
            dig2 = 0;
        }
        else {
            dig2 = 11-rest;
        }

        // concat numbers with mask
        numbersConcat = String.valueOf(n1) + String.valueOf(n2) +"."+ String.valueOf(n3) + String.valueOf(n4) +
                String.valueOf(n5) +"."+ String.valueOf(n6) + String.valueOf(n7) +String.valueOf(n8)+"/"+
                String.valueOf(n9) + String.valueOf(n10) + String.valueOf(n11) +
                String.valueOf(n12)+"-";
        // concat first rest with second
        nDigResult = String.valueOf(dig1) + String.valueOf(dig2);

        numberGenerated = numbersConcat+nDigResult;

        return numberGenerated;
    }
}
