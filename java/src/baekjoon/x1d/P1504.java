package baekjoon.x1d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1504 {
    static final int INF = 1000 * 200000;
    static int n, e;
    static List<List<Pair>> adj;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        n = sc.nextInt();
        e = sc.nextInt();
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adj.get(a).add(new Pair(b, c));
            adj.get(b).add(new Pair(a, c));
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        int dist1 = djk(1, v1) + djk(v1, v2) + djk(v2, n);
        int dist2 = djk(1, v2) + djk(v2, v1) + djk(v1, n);
        int answer = Math.min(dist1, dist2);
        if (answer >= INF) {
            answer = -1;
        }
        System.out.print(answer);
    }

    private static int djk(int v1, int v2) {
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        pq.offer(new Pair(v1, 0));
        d[v1] = 0;
        while (!pq.isEmpty()) {
            Pair c = pq.poll();
            if (c.w != d[c.v]) {
                continue;
            }
            for (Pair nxt : adj.get(c.v)) {
                if (d[nxt.v] <= d[c.v] + nxt.w) {
                    continue;
                }
                d[nxt.v] = d[c.v] + nxt.w;
                pq.offer(new Pair(nxt.v, d[nxt.v]));
            }
        }
        return d[v2];
    }

    private static class Pair {
        int v;
        int w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
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
