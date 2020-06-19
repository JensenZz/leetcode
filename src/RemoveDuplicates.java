public class RemoveDuplicates {


    public static void main(String[] args) {
        int[] aaa = new int[]{-2,-1,0};
        int leanth = removeDuplicates(aaa);
        System.out.println(leanth);
        for (int i = 0; i < leanth; i++) {
            System.out.println(aaa[i]);
        }
    }


    public static int removeDuplicates(int[] nums) {
        //排除特殊情况
        if (nums.length == 0) {
            return 0;
        }
        //头尾一致
        if (nums[0] == nums[nums.length - 1] || nums.length == 1) {
            return 1;
        }
        //因为数据是有序的且从小到大 所以使用双指针法  然后利用遇到不重复的交换即可  直到快的指针遍历完所有数据  此时算法时间复杂度刚好O(n)
        //变化过程如图所示
        //0,0,1,1,1,2,2,3,3,4
        //0,1,1,1,1,2,2,3,3,4
        //0,1,2,1,1,2,2,3,3,4
        //0,1,2,3,1,2,2,3,3,4
        //0,1,2,3,4,2,2,3,3,4
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[j + 1] = nums[i];
                j = j + 1;
            }
        }
        return j + 1;
    }
}
