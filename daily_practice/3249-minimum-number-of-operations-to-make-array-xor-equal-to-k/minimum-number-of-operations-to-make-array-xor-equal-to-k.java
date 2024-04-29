class Solution {
    public int minOperations(int[] nums, int k) {
        int fXor = nums[0];

        for(int i = 1; i<nums.length; ++i){
            fXor ^=nums[i];
        }

        String bitStringX = "";
        String bitStringK = "";

        while (fXor > 0) {
            bitStringX = (fXor & 1) + bitStringX;
            fXor >>= 1;
        }
        while (k > 0) {
            bitStringK = (k & 1) + bitStringK;
            k >>= 1;
        }
        int res = 0;
       while (bitStringX.length() < 32) {
    bitStringX = "0" + bitStringX;
}
while (bitStringK.length() < 32) {
    bitStringK = "0" + bitStringK;
}

        for(int i = 0; i<bitStringK.length(); ++i){
            if(bitStringK.charAt(i)!=bitStringX.charAt(i)) res++;
        }


        return res;
    }   
}