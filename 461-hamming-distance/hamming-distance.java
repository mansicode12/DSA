class Solution {
    public int hammingDistance(int x, int y) {
        int XOR = x^y;
        int setBitsCount = 0;
        for(int i=0;i<32;i++){
            if(((XOR>> i)&1) == 1){
                setBitsCount++;
            }
        }
       return setBitsCount;
    }
}