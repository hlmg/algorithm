package baekjoon.x0b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1992 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static char[][] map;


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        rec(0, 0, n);
        bw.close();
    }

    private static void rec(int y, int x, int length) throws IOException {
        if (length == 1) {
            bw.write(String.valueOf(map[y][x] - '0'));
            return;
        }

        char num = map[y][x];
        for (int i = y; i < y + length; i++) {
            for (int j = x; j < x + length; j++) {
                if (map[i][j] != num) {
                    bw.write("(");
                    int y2 = y + length / 2;
                    int x2 = x + length / 2;
                    length /= 2;
                    rec(y, x, length);
                    rec(y, x2, length);
                    rec(y2, x, length);
                    rec(y2, x2, length);
                    bw.write(")");
                    return;
                }
            }
        }

        bw.write(String.valueOf(num - '0'));
    }
}
