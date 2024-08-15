package baekjoon.x1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2637 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] indeg = new int[n + 1];
        int[] depth = new int[n + 1];
        List<List<Part>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            adj.get(x).add(new Part(y, k));
            indeg[y]++;
            depth[x]++;
        }
        Queue<Integer> que = new ArrayDeque<>();
        int[] count = new int[n + 1];
        que.offer(n);
        count[n] = 1;
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (Part next : adj.get(cur)) {
                count[next.num] += count[cur] * next.count;
                if (--indeg[next.num] == 0) {
                    que.offer(next.num);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (depth[i] == 0) {
                sb.append(i).append(" ").append(count[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static class Part {
        int num;
        int count;

        public Part(int num, int count) {
            this.num = num;
            this.count = count;
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
