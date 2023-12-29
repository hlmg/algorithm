package baekjoon.x03;

import java.util.Arrays;
import java.util.Scanner;

public class P1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] counts = new int[10];
        int nums = sc.nextInt();
        while (nums > 0) {
            int num = nums % 10;
            counts[num]++;
            nums /= 10;
        }

        counts[6] = (int) (Math.ceil((counts[6] + counts[9] * 1.0) / 2));
        System.out.println(Arrays.toString(counts));
        int max = 0;
        for (int i = 0; i <= 8; i++) {
            if (max >= counts[i]) {
                continue;
            }
            max = Math.max(max, counts[i]);
        }
        System.out.println(max);
    }
}
