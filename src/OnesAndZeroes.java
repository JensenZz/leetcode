public class OnesAndZeroes {

    //给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
    //
    //请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
    //
    //如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
    //根据题意做出状态方程
    //dp[m][n] 代表 m个0 n个1的最大子集数
    //if i>= cost_zero(k) and j>=cost_one(k)
    //dp[m][n] = max(dp[m][n],1+dp[m-cost_zero(k)][n-cost_one(k)])
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }

    public static int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - '0']++;
        }
        return c;
    }


    public static void main(String[] args) {
        String [] strings =new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strings, 5, 3));
    }
}
