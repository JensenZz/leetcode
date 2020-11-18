public class CoinChange {


    /**
     * Input: coins = [1,2,5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     */

    //base amount=0的时候  返回为0
    //状态  主问题与子问题变化的只有amount  因为coin是无限的 且coin是固定的  所有变化的只有amount
    //选择  导致状态变化的点 这里的选择就是银币的选择 选择一个amount就会减去对应的值
    //定义dp 函数/数组的定义  dp[n] 为总数为n的最少次硬币数量
    //伪代码
    //int coinChange(vector<int>& coins, int amount) {
    //    // 数组大小为 amount + 1，初始值也为 amount + 1
    //    vector<int> dp(amount + 1, amount + 1);
    //    // base case
    //    dp[0] = 0;
    //    // 外层 for 循环在遍历所有状态的所有取值
    //    for (int i = 0; i < dp.size(); i++) {
    //        // 内层 for 循环在求所有选择的最小值
    //        for (int coin : coins) {
    //            // 子问题无解，跳过
    //            if (i - coin < 0) continue;
    //            dp[i] = min(dp[i], 1 + dp[i - coin]);
    //        }
    //    }
    //    return (dp[amount] == amount + 1) ? -1 : dp[amount];
    //}
//    public int coinChange(int[] coins, int amount) {
//
//    }


}
