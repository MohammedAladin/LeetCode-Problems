import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int k) {
        int fXor = Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();

        String bitStringX = Integer.toBinaryString(fXor);
        String bitStringK = Integer.toBinaryString(k);

        // Pad with leading zeros to ensure both bit strings have the same length
        int maxLength = Math.max(bitStringX.length(), bitStringK.length());
        bitStringX = String.format("%" + maxLength + "s", bitStringX).replace(' ', '0');
        bitStringK = String.format("%" + maxLength + "s", bitStringK).replace(' ', '0');

        int res = 0;
        for (int i = 0; i < bitStringK.length(); ++i) {
            if (bitStringK.charAt(i) != bitStringX.charAt(i)) {
                res++;
            }
        }

        return res;
    }
}
