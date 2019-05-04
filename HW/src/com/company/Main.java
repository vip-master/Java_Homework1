package com.company;

import java.util.Scanner;


public class Main {

    private static boolean isEndDiff(int a) {
        int c = a;
        a ^= 0;
        c >>= 1;
        c <<= 1;
        return a != c;

    }

    private static int setEndZero(int a) {
        a >>= 1;
        a <<= 1;
        return a;

    }

    private static int dekrement(int a) {
        int b;
        if (isEndDiff(a)) {
            a = setEndZero(a);
            b = new Integer(a);
        } else {
            a >>= 1;
            b = dekrement(a);
            b <<= 1;
            b |= 1;
        }
        return b;
    }

    private static int minus(int a, int b) {
        while (a != 0 && b != 0) {
            a = dekrement(a);
            b = dekrement(b);
        }

        if (a == 0) return b;
        else return a;
    }

    private static int changeBit(int number, int pos, int newbit) {
        int b = 0;
        int pos1 = new Integer(pos);

        while (pos1 > 1) {
            if (isEndDiff(number)) {
                b <<= 1;
                b |= 1;
            } else b <<= 1;
            number >>= 1;
            pos1 = dekrement(pos1);
        }

        number >>= 1;
        number <<= 1;
        if (newbit == 1) number |= 1;

        while (pos > 1) {
            if (isEndDiff(b)) {
                number <<= 1;
                number |= 1;
            } else number <<= 1;
            b >>= 1;
            pos = dekrement(pos);
        }

        return number;
    }

    public static void main(String[] args) {

        System.out.println("1. \n");
        Scanner input = new Scanner(System.in);
        System.out.println("input num: ");
        int decimal = Integer.parseInt(input.next(), 2);
        System.out.println(decimal);
        System.out.println("\n");

        System.out.println("2. \n");
        decimal = -decimal;
        System.out.println(decimal);
        decimal >>>= 1;
        System.out.println(decimal);
        System.out.println("\n");

        System.out.println("3. \n");
        int i;
        byte byteparam = 1;
        for (i = 0; byteparam != 0; i++) {
            byteparam <<= 1;
        }
        System.out.printf("Byte are saved in %d bytes\n", i);
        short shortparam = 1;
        for (i = 0; shortparam != 0; i++) {
            shortparam <<= 1;
        }
        System.out.printf("Short are saved in %d bytes\n", i);

        int intparam = 1;
        for (i = 0; intparam != 0; i++) {
            intparam <<= 1;
        }
        System.out.printf("Int are saved in %d bytes\n", i);

        long longparam = 1;
        for (i = 0; longparam != 0; i++) {
            longparam <<= 1;
        }
        System.out.printf("Long are saved in %d bytes\n", i);

        System.out.println("\n");

        System.out.println("4. \n");
        int a, b;
        System.out.println("Input a = ");
        a = input.nextInt();
        System.out.println("Input b = ");
        b = input.nextInt();

        while (a != b) {
            if (a > b) a = minus(a, b);
            else b = minus(a, b);
        }
        int result = a;
        System.out.println(result);

        System.out.println("\n");

        System.out.println("5. \n");

        System.out.println("\nEnter value: ");
        int number = input.nextInt();
        System.out.println("\n\n");
        System.out.println(Integer.toBinaryString(number));
        System.out.println("\n\n");
        System.out.println("\nEnter position: ");
        int pos = input.nextInt();
        System.out.println("\nEnter bit: ");
        int bit = input.nextInt();


        System.out.println(Integer.toBinaryString(changeBit(number, pos, bit)));


        System.out.println("\n");
    }
}
