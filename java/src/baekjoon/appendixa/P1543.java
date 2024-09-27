package baekjoon.appendixa;

import java.util.Scanner;

public class P1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String d = sc.nextLine();
        String w = sc.nextLine();

        int count = 0;
        while (true) {
            int index = d.indexOf(w);
            if (index == -1) {
                break;
            }
            d = d.substring(index + w.length());
            count++;
        }
        System.out.print(count);
    }
}
