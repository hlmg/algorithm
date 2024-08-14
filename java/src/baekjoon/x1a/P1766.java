package baekjoon.x1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1766 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] indeg = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            indeg[b]++;
            adj.get(a).add(b);
        }

        Queue<Integer> que = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                que.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            int current = que.poll();
            sb.append(current).append(" ");
            for (int next : adj.get(current)) {
                if (--indeg[next] == 0) {
                    que.offer(next);
                }
            }
        }
        System.out.print(sb);
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
