class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Take the first k cards from the left
        int lsum = 0;
        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }

        int maxSum = lsum;
        int rsum = 0;

        // Now start replacing from the right side one by one
        for (int i = 0; i < k; i++) {
            lsum -= cardPoints[k - 1 - i];      // remove one card from left
            rsum += cardPoints[n - 1 - i];      // add one card from right
            maxSum = Math.max(maxSum, lsum + rsum);
        }

        return maxSum;
    }
}
