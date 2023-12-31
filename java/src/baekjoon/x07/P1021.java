package baekjoon.x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class P1021 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            int target = sc.nextInt();
            int index = list.indexOf(target);
            int half = list.size() / 2;
            if (index <= half) {
                while (true) {
                    Integer removed = list.remove(0);
                    if (removed == target) {
                        break;
                    }
                    list.add(removed);
                    answer++;
                }
            } else {
                while (true) {
                    Integer removed = list.remove(list.size() - 1);
                    if (removed == target) {
                        break;
                    }
                    list.add(0, removed);
                    answer++;
                }
                answer += 1;
            }
        }
        System.out.println(answer);
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
