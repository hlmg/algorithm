package baekjoon.x0c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P6603 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] nums;
    private static int[] answer;
    private static int k;

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        while (true) {
            k = sc.nextInt();
            if (k == 0) {
                break;
            }
            nums = new int[k];
            answer = new int[6];

            for (int i = 0; i < k; i++) {
                nums[i] = sc.nextInt();
            }

            solve(0, 0);
            bw.write("\n");
        }
        bw.close();
    }

    private static void solve(int depth, int index) throws IOException {
        if (depth == 6) {
            for (int num : answer) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = index; i < k; i++) {
            answer[depth] = nums[i];
            solve(depth + 1, i + 1);
        }
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new IllegalArgumentException();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
