class Solution {
    public int minIncrementForUnique(int[] nums) {
        int minInc = 0;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]<= nums[i-1]){
            int inc = nums[i-1] + 1- nums[i];
            minInc += inc;
            nums[i] = nums[i-1]+1;
            }
           
        }
         return minInc;
    }
}