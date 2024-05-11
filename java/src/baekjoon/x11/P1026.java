package baekjoon.x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1026 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        int answer = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2, Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            answer += arr1[i] * arr2[i];
        }
        System.out.print(answer);
    }

    private static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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
