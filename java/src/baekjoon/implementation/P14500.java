package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P14500 {
    static int n, m;
    static int[][] map;
    static int[][][] list = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {0, 1}, {1, 1}, {1, 0}},
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}}
    };

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                for (int[][] pointers : list) {
                    for (int[][] candidate : getCandidates(pointers)) {
                        answer = Math.max(answer, getSum(i, j, candidate));
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static List<int[][]> getCandidates(int[][] pointers) {
        List<int[][]> list = new ArrayList<>();
        list.add(pointers);

        int[][] temp;
        for (int i = 0; i < 3; i++) {
            temp = new int[pointers.length][2];
            for (int j = 0; j < pointers.length; j++) {
                temp[j][0] = pointers[j][1];
                temp[j][1] = - pointers[j][0];
            }
            list.add(temp);
            pointers = temp;
        }

        temp = new int[pointers.length][2];
        for (int i = 0; i < pointers.length; i++) {
            temp[i][0] = - pointers[i][0];
            temp[i][1] = pointers[i][1];
        }
        list.add(temp);
        pointers = temp;

        for (int i = 0; i < 3; i++) {
            temp = new int[pointers.length][2];
            for (int j = 0; j < pointers.length; j++) {
                temp[j][0] = pointers[j][1];
                temp[j][1] = - pointers[j][0];
            }
            list.add(temp);
            pointers = temp;
        }

        return list;
    }

    private static int getSum(int i, int j, int[][] ints) {
        int sum = 0;
        for (int[] d : ints) {
            int ny = i + d[0];
            int nx = j + d[1];
            if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) {
                return 0;
            }
            sum += map[ny][nx];
        }
        return sum;
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
