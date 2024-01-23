package baekjoon.x0c;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class P15654 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n, m;
    private static int[] nums;
    private static boolean[] used;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        used = new boolean[n];
        answer = new int[m];

        Arrays.sort(nums);
        func(0);
        bw.close();
    }

    private static void func(int depth) throws IOException {
        if (depth == m) {
            for (int num : answer) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            answer[depth] = nums[i];
            used[i] = true;
            func(depth + 1);
            used[i] = false;
        }
    }
}
