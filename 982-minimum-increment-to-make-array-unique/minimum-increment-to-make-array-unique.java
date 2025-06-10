
class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int minInc = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int needed = nums[i - 1] + 1;
                minInc += needed - nums[i];
                nums[i] = needed;
            }
        }

        return minInc;
    }
}
