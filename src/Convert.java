import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company:个推 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 2018/5/30
 */

public class Convert {
    public static String convert(String s, int numRows) {
        if (s.length() <= numRows) {
            return s;
        }
        List<String> strings = new ArrayList<String>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            int k = j / numRows;

            if (k > 0) {
                if (k % 2 == 0) {
                    strings.set(j % numRows, strings.get(j % numRows) + s.charAt(i));
                } else {
                    strings.set(numRows - 1 - j % numRows, strings.get(numRows - 1 - j % numRows) + s.charAt(i));
                }
            } else {
                strings.add(String.valueOf(s.charAt(i)));
            }
            int m = j % numRows;
            if (m == numRows - 1) {
                j = j + 1;
            }
            j++;
        }
        return strings.stream().reduce("", (x, y) -> x + y);
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
