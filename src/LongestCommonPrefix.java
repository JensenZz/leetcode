public class LongestCommonPrefix {


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aa", "a"}));
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; ; i++) {
            if (strs[0].isEmpty()) {
                return "";
            }
            char temp = strs[0].charAt(i);
            boolean isEnd = (strs[0].length() - 1) == i;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].isEmpty()) {
                    return "";
                }
                if (temp != strs[j].charAt(i)) {
                    return commonPrefix.toString();
                }
                if (strs[j].length() - 1 == i) {
                    isEnd = true;
                }
            }
            commonPrefix.append(temp);
            if (isEnd) {
                return commonPrefix.toString();
            }
        }
    }

    /**
     * 水平扫描法
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
