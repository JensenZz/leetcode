public class ContainerWithMostWater {
    public static void main(String[] args) {
        int res = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(res);
    }

    public static int maxArea(int[] height) {
        int n = height.length;
        int max = 0;

        for (int i = 0, j = n - 1; i < j; ) {
            if (height[i] <= height[j]) {
                int temres = height[i] * (j - i);
                if (temres > max) {
                    max = temres;
                }
                i++;
            } else {
                int temres = height[j] * (j - i);
                if (temres > max) {
                    max = temres;
                }
                j--;
            }
        }
        return max;
    }
}
