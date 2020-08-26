public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "asssbasssc"));
    }


    public static boolean isSubsequence(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        int i, j;
        for (i = 0, j = 0; i < schar.length && j < tchar.length; ) {
            if (schar[i] == tchar[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == schar.length;
    }
}
