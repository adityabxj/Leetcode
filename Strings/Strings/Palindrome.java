package Strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String a = "";
        String B = A;

        for (int i = A.length() - 1; i >= 0; i--) {
            a += A.charAt(i);
        }

        if (a.equals(B)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        sc.close();
    }
}
