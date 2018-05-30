/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company:个推 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 2018/5/24
 */

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int j = 1;
        int i = 0;
        String tempMax = "";
        if (s.length() <= 1) {
            tempMax = s;
        } else {
            tempMax = s.substring(0, 1);
        }
        while (i < s.length() && j < s.length()) {
            //第一种情况  回环为偶数
            if (s.charAt(i) == s.charAt(j)) {
                int a = i, b = j;
                while (a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b)) {
                    a--;
                    b++;
                }
                if (b - 1 - a > tempMax.length()) {
                    tempMax = s.substring(a + 1, b);
                }
            }
            if (j + 1 < s.length() && s.charAt(i) == s.charAt(j + 1)) {
                int a = i, b = j + 1;
                while (a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b)) {
                    a--;
                    b++;
                }
                if (b - 1 - a > tempMax.length()) {
                    tempMax = s.substring(a + 1, b);
                }
            }
            i++;
            j++;

        }
        return tempMax;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome(""));
    }
}
