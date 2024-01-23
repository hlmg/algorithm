package baekjoon.x0c;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P15651 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n, m;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[m];

        func(0);
        bw.close();
    }

    private static void func(int depth) throws IOException {
        if (depth == m) {
            for (int num : nums) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            nums[depth] = i;
            func(depth + 1);
        }
    }
}
