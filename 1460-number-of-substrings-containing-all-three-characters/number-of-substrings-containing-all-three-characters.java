class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastseen = {-1, -1, -1};
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            lastseen[s.charAt(i) - 'a'] = i;

            // Check if all three characters have been seen
            int minIndex = Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2]));
            if (minIndex != -1) {
                count += minIndex + 1;
            }
        }

        return count;
    }
}
