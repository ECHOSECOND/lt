package putongshuzu;

public class chuzishenyiweishuzudechengji {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        // 3. 不使用On空间复杂度时，我们用一个变量k来保存 此元素i 之前的所有乘积。
        // 遍历到i，先用k，然后k要更新。在i结束遍历的末尾，供i+1用
        // 比如i=2，遍历到i=2时，先用k，然后再把 k * i==2的值，供i==3用。

        // 我们用一个变量记录 i 位置时 前面所有元素的乘积
        // 先用k再更新
        int k = nums[0];
        res[0] = 1;
        // 注意这里给 1-nums.length-1 全进行了赋值操作， nums[0] 其实还是 0
        // 这里要初始化为 1 否则后面 *= 后还是会变成 0！
        for (int i = 1; i < nums.length; i++) {
            // 先用再更新
            res[i] = k;
            k *= nums[i];
        }

        // 4. 同样的 对于i而言，还有i之后的元素。一样的道理：
        // 初始：倒数第二个先用倒数第一个的初始值。每次迭代完成，先用了后 再在循环末尾更新k 供下一个位置使用。
        int k2 = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            // 先用再更新
            res[i] *= k2;
            k2 *= nums[i];
        }

        return res;
    }

    // 除自身以外的乘积

    // 1. 思路：遇到和、乘积这类的 有时候要考虑 前缀和和前缀积 思想。
    // 为了避免重复的求和、求积计算。因为遍历每个元素，前后都要重新算一遍！类似 on2 所以要提前计算好。前缀、后缀积

    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];

        //  构建前缀积 即i处的前缀积为 i* [0-i] 前缀积和前缀和可以只遍历一遍！！
        int[] sum1 = new int[nums.length];
        int[] sum2 = new int[nums.length];
        int[] res = new int[nums.length];

        // 2. 注意前缀、后缀积、和这种情况 初始化要注意 边界 0 和 最后一个位置 前缀注意 sum1[0]
        // 后缀注意 nums[length-1]
        // 然后真正遍历 从 1 和  nums.length - 2 开始。
        sum1[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum1[i] = nums[i] * sum1[i - 1];
        }
        sum2[nums.length - 1] = nums[nums.length - 1];
        // 2. 构建后缀积
        for (int i = nums.length - 2; i >= 0; i--) {
            sum2[i] = nums[i] * sum2[i + 1];
        }

        // i位置的值 为 前缀积[i-1]*后缀积[i+1]

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[i] = sum2[1];
            } else if (i == nums.length - 1) {
                res[i] = sum1[nums.length - 2];
            } else {
                res[i] = sum2[i + 1] * sum1[i - 1];
            }
        }
        return res;

    }
}
