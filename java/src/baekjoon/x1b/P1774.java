package baekjoon.x1b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P1774 {
    static int[] p;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        p = new int[n + 1];
        Arrays.fill(p, -1);
        Pair[] pairs = new Pair[n + 1];
        List<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            pairs[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                edges.add(new Edge(i, j, pairs[i].getDistance(pairs[j])));
            }
        }
        for (int i = 0; i < m; i++) {
            union(sc.nextInt(), sc.nextInt());
        }
        Collections.sort(edges);
        int count = 0;
        double answer = 0;
        for (Edge edge : edges) {
            if (union(edge.u, edge.v)) {
                answer += edge.w;
                count++;
                if (count == n - 1) {
                    break;
                }
            }
        }
        System.out.printf("%.2f", answer);
    }

    private static boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return false;
        }
        if (p[u] == p[v]) {
            p[u]--;
        }
        if (p[u] < p[v]) {
            p[v] = u;
        } else {
            p[u] = v;
        }
        return true;
    }

    private static int find(int x) {
        if (p[x] < 0) {
            return x;
        }
        return p[x] = find(p[x]);
    }

    private static class Edge implements Comparable<Edge> {
        int u;
        int v;
        double w;

        public Edge(int u, int v, double w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(w, o.w);
        }
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double getDistance(Pair o) {
            return Math.sqrt(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2));
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
