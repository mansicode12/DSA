class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int maxArea = 0;
        int cols = matrix[0].length;
        int[] heights = new int[cols];

        for (char[] row : matrix) {
            // Build heights array
            for (int j = 0; j < cols; j++) {
                if (row[j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            // Find max area for current histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int[] extended = new int[heights.length + 1];
        System.arraycopy(heights, 0, extended, 0, heights.length);
        extended[heights.length] = 0; // Add sentinel value

        for (int i = 0; i < extended.length; i++) {
            while (!stack.isEmpty() && extended[i] < extended[stack.peek()]) {
                int height = extended[stack.pop()];
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}