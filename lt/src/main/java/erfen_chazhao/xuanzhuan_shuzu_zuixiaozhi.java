package erfen_chazhao;

public class xuanzhuan_shuzu_zuixiaozhi {

    public int findMin(int[] nums) {

        // 同样。
        // 789 12345
        // 567891011 123

        int left = 0, right = nums.length - 1;
        while (left < right) { // left=right就返回了！因为 left=right继续遍历一次，会使得left = mid+1, 导致超出边界。
            int mid = left + (right - left) / 2;
            // mid-right有序 边界：4 2 3; 4 5 1 left-mid 有序

            // 一般我们都是 mid 跟 right 比较
            // 就找最小值的问题而言：
            // mid-right有序 说明mid是小的 可能是最小 所以 right=mid 不要跳过去
            // left-mid有序 mid是大的，所以最小值在mid右侧，mid+1

            if (nums[mid] < nums[right]) {
                right = mid; // mid-right升序 最小的可能就是mid 所以 right=mid
            }else {
                left = mid + 1; // left-mid升序；mid处于最大值呢，最小值一定mid+1
            }
        }
        return nums[left];
    }


}
