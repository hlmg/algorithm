package kakao.blind2018;

import java.util.Arrays;

public class 방금그곡 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int longest = 0;
        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            String startTime = info[0];
            String endTime = info[1];
            int start = Integer.parseInt(startTime.substring(0, 2)) * 60
                    + Integer.parseInt(startTime.substring(3, 5));
            int end = Integer.parseInt(endTime.substring(0, 2)) * 60
                    + Integer.parseInt(endTime.substring(3, 5));

            int playtime = end - start;
            String title = info[2];
            String music = info[3];

            int musicTime = (int) (music.length() - Arrays.stream(music.split(""))
                    .filter(s -> s.equals("#"))
                    .count());

            int quotient = playtime / musicTime;
            int remainder = playtime % musicTime;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < quotient; i++) {
                sb.append(music);
            }

            int index = 0;
            while (remainder > 0) {
                sb.append(music.charAt(index));
                if (music.charAt(index) != '#') {
                    remainder--;
                }
                index++;
            }

            music = sb.toString();
            if (playtime > longest) {
                while (music.contains(m)) {
                    if (music.charAt((music.indexOf(m) + m.length()) % music.length()) != '#') {
                        answer = title;
                        longest = playtime;
                        break;
                    }
                    music = music.substring(music.indexOf(m) + m.length());
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        방금그곡 solution = new 방금그곡();
//        solution.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"});
        solution.solution("CCB", new String[]{"03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"});
//        solution.solution("A", new String[]{"12:00,12:01,Song,BA"});
//        solution.solution("BA", new String[]{"12:00,12:03,Song,AB"});
//        solution.solution("BA", new String[]{"12:00,12:04,Song,A#B"});
        //"ABA", ["12:00,13:00,Song,AB"]
//        solution.solution("A", new String[]{"12:00,12:01,Song,A#"});
        //"A", ["12:00,12:01,Sing,A", "12:00,12:01,Song,A"]
//        solution.solution("A#", new String[]{"12:00,12:01,Song,A#"});
    }
}
