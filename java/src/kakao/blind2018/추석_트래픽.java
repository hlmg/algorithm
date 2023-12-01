package kakao.blind2018;

import java.util.*;

public class 추석_트래픽 {
    public int solution(String[] lines) {
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();
        List<Integer> lowerBounds = new ArrayList<>();
        List<Integer> upperBounds = new ArrayList<>();

        for (String line : lines) {
            String[] input = line.split(" ");
            String[] s = input[1].split(":");
            String t = input[2].substring(0, input[2].length() - 1);

            int hour = Integer.parseInt(s[0]) * 60 * 60 * 1000;
            int minute = Integer.parseInt(s[1]) * 60 * 1000;
            int second = (int) (Double.parseDouble(s[2]) * 1000);

            int end = hour + minute + second;

            int timeAmount = (int) (Double.parseDouble(t) * 1000);

            int start = end - timeAmount + 1;

            startTimes.add(start);
            endTimes.add(end);

            lowerBounds.add(start - 999);
            upperBounds.add(start);

            lowerBounds.add(start);
            upperBounds.add(start + 999);

            lowerBounds.add(end - 999);
            upperBounds.add(end);

            lowerBounds.add(end);
            upperBounds.add(end + 999);
        }

        int[] counts = new int[lowerBounds.size()];
        for (int i = 0; i < startTimes.size(); i++) {
            int start = startTimes.get(i);
            int end = endTimes.get(i);
            for (int j = 0; j < lowerBounds.size(); j++) {
                if (start < lowerBounds.get(j) && end > upperBounds.get(j)
                        || lowerBounds.get(j) <= start && start <= upperBounds.get(j)
                        || lowerBounds.get(j) <= end && end <= upperBounds.get(j)) {
                    counts[j]++;
                }
            }
        }

        int answer = 0;
        for (int count : counts) {
            answer = Math.max(answer, count);
        }

        return answer;
    }

    public static void main(String[] args) {
        추석_트래픽 solution = new 추석_트래픽();
//        System.out.println(solution.solution(new String[]{"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"}));
        System.out.println(solution.solution(new String[]{"2016-09-15 23:59:59.999 0.001s"}));
    }
}
