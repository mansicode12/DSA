import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array

        int[] dp = new int[n];   // dp[i] = size of largest divisible subset ending at i
        int[] hash = new int[n]; // to reconstruct path

        Arrays.fill(dp, 1);

        int maxSize = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            hash[i] = i; // initially each element points to itself
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }

            if (dp[i] > maxSize) {
                maxSize = dp[i];
                lastIndex = i;
            }
        }

        // reconstruct subset
        List<Integer> result = new ArrayList<>();
        result.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            result.add(nums[lastIndex]);
        }

        Collections.reverse(result);
        return result;
    }
}
