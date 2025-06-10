package shuzhizhen;

public class yidongzero {
    public void moveZeroes(int[] nums) {
        // 一个遍历指针 一个待替换指针 实际上是第一个0的位置 非0的相对位置不变，0移动到后面去了。
        // 非0相对位置不变 从前往后 找非0
        int j=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                swap(nums, i ,j);
                j++;
            }
        }
    }
    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
