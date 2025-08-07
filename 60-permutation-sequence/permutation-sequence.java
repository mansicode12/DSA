class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
    ArrayList<Integer> numbers = new ArrayList<>();

    // Compute (n-1)! and build number list
    for (int i = 1; i < n; i++) {
        fact *= i;
        numbers.add(i);
    }
    numbers.add(n); // Add last number

    StringBuilder ans = new StringBuilder(); 
    k = k - 1; // Convert to 0-based indexing

    while (!numbers.isEmpty()) {
        int index = k / fact;
        ans.append(numbers.get(index)); 
        numbers.remove(index);

        if (numbers.isEmpty()) break;

        k %= fact;
        fact /= numbers.size();
    }

    return ans.toString();
    }
}