package erfen_chazhao;

public class xuanzhuanshuzu_chazhao_zhi {
    /**
     * 查找旋转数组的值
     * <p>
     * 左侧有序、右侧有序
     *
     * 看 789 12345 还是 56789 123
     */

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先看左侧有序还是右侧有序
//            789 12345
            // 右侧 mid-right 有序 看看 target在mid-right区间什么位置
            if (nums[mid] < nums[right]) {
                // 判断是否在 mid-right区间，在->mid+1 不然一定在mid左边
                // target一定不等于mid，所以和 mid、right两个边界比较 >小的 <=大的
                // 注意 右边的情况 = 也是 left 在mid+1的
                // 左右边界都得判断 不然 10 11 12 1 2 3 4 5 6 这种，要找10 只看 mid跟target可能会认为 left：mid+1，但其实在左侧。
                if (target>nums[mid] && target<=nums[right]) {
                    left = mid + 1; // mid和target不同 所以一定是 mid+1的
                }else {
                    right = mid - 1;
                }
            }else {
                // 56789 123
                // 左侧left-mid有序
                // 同上
                // left=target 也是right要mid-1的。
                if (nums[mid] > target && nums[left]<=target) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        xuanzhuanshuzu_chazhao_zhi chazhaoXuanzhuanshuzuZhi = new xuanzhuanshuzu_chazhao_zhi();
        System.out.println(chazhaoXuanzhuanshuzuZhi.search(nums, 0));
    }

}
