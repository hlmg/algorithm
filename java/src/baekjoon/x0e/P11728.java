package baekjoon.x0e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11728 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                sb.append(arr1[i]).append(" ");
                i++;
            } else {
                sb.append(arr2[j]).append(" ");
                j++;
            }
        }
        while (i < n) {
            sb.append(arr1[i]).append(" ");
            i++;
        }
        while (j < m) {
            sb.append(arr2[j]).append(" ");
            j++;
        }
        System.out.print(sb);
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
