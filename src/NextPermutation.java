import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        //寻找从后到前升序的第一个异常数字  记住这个升序序列  如果未找到 则直接从小到大排序整个序列
        int firstWrongNum = -1;
        int index = nums.length - 1;
        boolean isRight = true;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                firstWrongNum = nums[i - 1];
                index = i - 1;
                isRight = false;
                break;
            }
        }
        if (isRight) {
            Arrays.sort(nums);
            return;
        }
        //找到升序序列中最小的大于 异常数字的数字与异常数字替换位置
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > firstWrongNum) {
                int temp = nums[i];
                nums[i] = firstWrongNum;
                nums[index] = temp;
                break;
            }
        }
        //使用冒泡排序对替换完毕的序列进行升序排序
        int j, k;
        int flag = nums.length - 1;//flag来记录最后交换的位置，也就是排序的尾边界

        while (flag > index + 1) {//排序未结束标志
            k = flag; //k 来记录遍历的尾边界
            flag = index + 1;
            for (j = index + 2; j <= k; j++) {
                if (nums[j - 1] > nums[j]) {//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    int temp;
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    //表示交换过数据;
                    flag = j;//记录最新的尾边界.
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] temp = new int[]{1, 3, 2};
        nextPermutation(temp);
        Arrays.stream(temp).forEach(System.out::println);
    }
}
