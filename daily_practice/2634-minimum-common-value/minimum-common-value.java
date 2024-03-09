import java.util.HashMap;
import java.util.Map;

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq1 = new LinkedHashMap<>();
        Map<Integer, Integer> freq2 = new LinkedHashMap<>();

        for (int i = 0; i < nums1.length; ++i) {
            freq1.put(nums1[i], 1);
        }

        for (int i = 0; i < nums2.length; ++i) {
            freq2.put(nums2[i], 1);
        }

        for (int key : freq1.keySet()) {
            if (freq2.containsKey(key)) {
                return key;
            }
        }
        return -1;
    }
}
