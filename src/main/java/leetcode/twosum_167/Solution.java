package leetcode.twosum_167;

/**
 * @author andor
 * @date 2021/5/18
 * @desc
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length-1;
        while (left!=right)
        if (numbers[left] + numbers[right] == target) {
            result[0] = left;
            result[1] = right;
            return result;
        }else if (numbers[left] + numbers[right] > target){
            right--;
        }else {
            left++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        new Solution().twoSum(nums,9);
    }
}
