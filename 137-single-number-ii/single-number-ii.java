class Solution {
    public int singleNumber(int[] nums) {
           int ones =0;
           int twoes =0;
           for(int i =0;i<nums.length;i++){
            ones = (nums[i] ^ ones) & ~twoes;
            twoes = (nums[i] ^ twoes) & ~ ones;
          
           }
           return ones;
    }
    }
    