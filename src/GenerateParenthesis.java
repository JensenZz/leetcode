import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {
    public static void main(String[] args) {
        for (String generateParenthesis : generateParentheses(4)) {
            System.out.println(generateParenthesis);
        }

    }

    public static List<String> generateParentheses(int n) {
        Set<String> parentheses = new HashSet<>();
        if (n == 1) {
            parentheses.add("()");
        } else {
            for (String parenthes : generateParentheses(n - 1)) {
                //找出所有的空缺插入
                for (int i = 0; i < parenthes.length(); i++) {
                    parentheses.add(parenthes.substring(0, i) + "()" + parenthes.substring(i));
                }
            }
        }
        return new ArrayList<>(parentheses);
    }

}
