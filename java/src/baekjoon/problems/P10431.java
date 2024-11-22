package baekjoon.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P10431 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int t;
    static int[] arr;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        int p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            input();
            solve();
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>();
    }

    private static void solve() {
        int answer = 0;
        for (int i = 0; i < 20; i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (arr[i] < list.get(j)) {
                    count++;
                }
            }
            list.add(arr[i]);
            answer += count;
        }
        System.out.printf("%d %d%n", t, answer);
    }
}
