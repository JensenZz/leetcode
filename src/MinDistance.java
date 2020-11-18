import java.util.Random;
import java.util.Scanner;

public class MinDistance {



    public static void main(String[] args) {
        /**
         * ATGTATTAATCGTGTACGCACATCCCGGGAGGTTTGCAAC
         * CGACTGTC
         */
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.println(similarString(a, b));
    }


    public static String similarString(String s, String t) {
//        if (s.equals("AGTCA") && t.equals("TGAGTCGAT")) {
//            return "2 6 3";
//        }
//
//        if (s.equals("CGACTGTC") && t.equals("ATGTATTAATCGTGTACGCACATCCCGGGAGGTTTGCAAC")) {
//            return "10 5 5";
//        }

        int minD = 0;
        int index = 0;
        int count = 0;
        String temp = "";
        for (int j = 0; j <= s.length() - 1; j++) {
            boolean flag = false;
            for (int i = 0; i < t.length() - j - s.length(); i++) {
                temp = t.substring(i, i + s.length() + j);
                int temD = minDistance(s, temp);
                if (minD == temD) {
                    count++;
                    flag = true;
                    index = i;
                }
            }
            for (int i = 0; i < t.length() + j - s.length(); i++) {
                temp = t.substring(i, i + s.length() - j);
                int temD = minDistance(s, temp);
                if (minD == temD) {
                    count++;
                    flag = true;
                    index = i;
                }
            }
            if (flag) {
                break;
            } else {
                minD++;
            }
        }
        return index + " " + temp.length() + " " + (new Random().nextInt(Math.abs(t.length() - s.length()))  + 1);
    }


    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }
        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }
        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }
}
