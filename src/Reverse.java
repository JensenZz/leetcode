/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company:个推 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 2018/6/15
 */

public class Reverse {
    public static int reverse(int x) {
        long a = Math.abs((long) x);
        StringBuilder temp = new StringBuilder().append(a);
        String b = temp.reverse().toString();
        int i = 0;
        for (; i < b.length(); i++) {
            if (b.charAt(i) != 0) break;
        }
        String s = b.substring(i, b.length());
        Long aaa = Long.parseLong(s);
        if (x > 0) {
            return aaa > 2147483647l ? 0 : aaa.intValue();
        } else {
            return aaa > 2147483648l ? 0 : -aaa.intValue();
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
