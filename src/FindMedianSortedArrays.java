/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company:个推 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 2018/5/24
 */

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                result[k] = nums2[j];
                j++;
                k++;
            } else if (nums1[i] == nums2[j]) {
                result[k] = nums1[i];
                i++;
                k++;
                result[k] = nums2[j];
                j++;
                k++;
            } else {
                result[k] = nums1[i];
                i++;
                k++;
            }
        }
        while (i < nums1.length) {
            result[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            result[k] = nums2[j];
            j++;
            k++;
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (result[(nums1.length + nums2.length) / 2] + result[(nums1.length + nums2.length) / 2 - 1]) / 2.0;
        } else {
            return result[(nums1.length + nums2.length) / 2];
        }
    }

    public static void main(String[] args) {
        int a[] = {};
        int b[] = {2, 3};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
