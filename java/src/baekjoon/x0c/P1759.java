package baekjoon.x0c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1759 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] chars;
    static String[] answer;
    static int l, c;
    static List<String> vowels = List.of("a", "e", "i", "o", "u");

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        chars = new String[c];
        for (int i = 0; i < c; i++) {
            chars[i] = st.nextToken();
        }
        Arrays.sort(chars);

        answer = new String[l];

        solve(0, 0, 0, 0);
        bw.close();
    }

    private static void solve(int k, int index, int vowelCount, int consonantCount) throws IOException {
        if (k == l) {
            if (vowelCount >= 1 && consonantCount >= 2) {
                for (String s : answer) {
                    bw.write(s);
                }
                bw.write("\n");
            }
            return;
        }

        for (int i = index; i < c; i++) {
            answer[k] = chars[i];
            if (vowels.contains(chars[i])) {
                solve(k + 1, i + 1, vowelCount + 1, consonantCount);
            } else {
                solve(k + 1, i + 1, vowelCount, consonantCount + 1);
            }
        }
    }
}
