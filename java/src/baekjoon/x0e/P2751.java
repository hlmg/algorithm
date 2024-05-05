package baekjoon.x0e;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2751 {
    static int[] arr;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        arr = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(0, n);
        for (int i : arr) {
            bw.write(i + "\n");
        }
        bw.close();
    }

    private static void mergeSort(int st, int en) {
        if (en - st == 1) {
            return;
        }
        int mid = (st + en) / 2;
        mergeSort(st, mid);
        mergeSort(mid, en);
        merge(st, en);
    }

    private static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int i = st;
        int j = mid;
        for (int k = st; k < en; k++) {
            if (i == mid) {
                tmp[k] = arr[j++];
            } else if (j == en) {
                tmp[k] = arr[i++];
            } else if (arr[i] <= arr[j]) {
                tmp[k] = arr[i++];
            } else {
                tmp[k] = arr[j++];
            }
        }
        for (int k = st; k < en; k++) {
            arr[k] = tmp[k];
        }
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
