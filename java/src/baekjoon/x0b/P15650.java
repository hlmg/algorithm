package baekjoon.x0b;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P15650 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n, m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        recursive(new int[n + 1], 1);
        bw.close();
    }

    public static void recursive(int[] nums, int depth) throws IOException {
        if (depth > m) {
            for (int i = 1; i <= m; i++) {
                bw.write(nums[i] + " ");
            }
            bw.write('\n');
            return;
        }

        for (int i = nums[depth - 1] + 1; i <= n; i++) {
            nums[depth] = i;
            recursive(nums, depth + 1);
        }
    }
}
