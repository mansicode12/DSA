class Solution {
    public int repeatedStringMatch(String a, String b) {
        int repeatCount = (int)Math.ceil((double) b.length()/a.length());
        StringBuilder sb = new StringBuilder();
        for(int i =0;i< repeatCount;i++){
            sb.append(a);
      }
      if (sb.toString().contains(b)) {
            return repeatCount;
        }
        sb.append(a);
        if (sb.toString().contains(b)) {
            return repeatCount + 1;
        }
        return -1;

    }
}