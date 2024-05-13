package baekjoon.x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        k = Math.min(k, n - k);
        System.out.println(factorial(n, k) / factorial(k, k));
    }

    private static int factorial(int num, int count) {
        int answer = 1;
        while (count != 0) {
            answer *= num;
            num--;
            count--;
        }
        return answer;
    }
}
