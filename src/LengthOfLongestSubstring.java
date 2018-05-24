/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company:个推 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 2018/5/22
 */

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s.length() > 1) {
            String temp = s.substring(0, 1);
            int i = 0;
            int j = 1;
            while (j < s.length()) {
                int a = temp.indexOf(s.charAt(j));
                if (a > -1) {
                    result = temp.length() > result ? temp.length() : result;
                    temp = s.substring(i + a + 1, j + 1);
                    i = a + 1 + i;
                } else {
                    temp = s.substring(i, j + 1);
                }
                j++;
            }
            result = temp.length() > result ? temp.length() : result;
        } else {
            result = s.length();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("".length());
    }

}
