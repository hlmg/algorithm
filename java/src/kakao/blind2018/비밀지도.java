package kakao.blind2018;

import java.util.Arrays;

public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int num = arr1[i] | arr2[i];
            String binary = Integer.toBinaryString(num);
            String row = String.format("%" + n + "s", binary);
            answer[i] = row.replace('0', ' ').replace('1', '#');
        }
        return answer;
    }

    public static void main(String[] args) {
        비밀지도 solution = new 비밀지도();

//        int[] arr1 = {9, 20, 28, 18, 11};
//        int[] arr2 = {30, 1, 21, 17, 28};

        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};

        System.out.println(Arrays.toString(solution.solution(5, arr1, arr2)));
    }
}
