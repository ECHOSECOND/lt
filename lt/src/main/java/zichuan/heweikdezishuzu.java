package zichuan;

public class heweikdezishuzu {
    public int subarraySum(int[] nums, int k) {
        // 暴力思想： 以i开始， [i+1 <-> length-1] 与i之间的每个区间和看是否与k相等。
        // 那么 对于每个 i 而言，都要计算 i+1与length-1之间的和； 这个时候 类似之前接雨水，我们提前把 i 需要的东西计算好。

        // 1. 使用前缀和求解【指的是 i位置，计算i位置之前的所有和】
        // 计算每个位置i，0-i的和 这样 每个位置的和都是前面的位置连续累加而来！存到arr
        // 2. 从i开始， arr[j]-arr[i] 如果= 和k，那么 次数+1;

        int count = 0;

        int[] arr = new int[nums.length];
        arr[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            arr[i] = nums[i] + arr[i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            // 有可能当前位置就满足
            if (arr[i] == k) {
                count++;
            }
            // 看 i 后面的每个位置的前缀和 - i 的差是否为k，若差=k 那么一定也是连续的数组和=k
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] == k) {
                    count++;
                }
            }
        }
        return count;

    }

    // 注意我们是可以从 i 和 0和i-1之间 就跟我们之前的map 一样。是跟之前的元素看 两者之间的关系

    // 也就是这也是看 两个元素之间的关系的。 i 与 0 和 i-1 之间的关系

    // 当然也可以 i跟 j（i+1开始）之间的关系。

    public int subarraySum2(int[] nums, int k) {

        int count = 0;

        int[] arr = new int[nums.length];
        arr[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            arr[i] = nums[i] + arr[i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            // 有可能当前位置就满足
            if (arr[i] == k) {
                count++;
            }
            // 看 i 后面的每个位置的前缀和 - i 的差是否为k，若差=k 那么一定也是连续的数组和=k
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] - arr[j] == k) {
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        heweikdezishuzu h = new heweikdezishuzu();
        System.out.println(h.subarraySum(new int[]{1,2,3}, 3));
    }

}
