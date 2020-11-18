public class Massage {


    public static int massage1(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        //分成两种情况 今天已经预约 今天不预约 所以有两个dp状态表达式
        //dp[i][0]表示今天未预约   dp[i][1]表示今天预约了   取两个最大值
        //dp[i][0]=max(dp[i-1][0],dp[i-1][1])      dp[i][1] = dp[i-1][0]+num[i]
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    public static int massage2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        //一种直接方式  dp[i]=max(dp[i-2]+num[i],dp[i-1]) 因为涉及到i-2  ，所以需要准备前两天的数据
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 1, 4, 5, 3, 1, 1, 3};
        System.out.println(massage1(a));
    }
}
