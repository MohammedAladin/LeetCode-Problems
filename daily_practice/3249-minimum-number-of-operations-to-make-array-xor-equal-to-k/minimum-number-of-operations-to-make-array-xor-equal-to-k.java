import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int k) {
        int fXor = Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();

        String bitStringX = Integer.toBinaryString(fXor);
        String bitStringK = Integer.toBinaryString(k);

        while (bitStringX.length() < 32) {
            bitStringX = "0" + bitStringX;
        }
        while (bitStringK.length() < 32) {
            bitStringK = "0" + bitStringK;
        }

        int res = 0;
        for (int i = 0; i < bitStringK.length(); ++i) {
            if (bitStringK.charAt(i) != bitStringX.charAt(i)) {
                res++;
            }
        }

        return res;
    }
}
