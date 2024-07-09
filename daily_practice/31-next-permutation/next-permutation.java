class Solution {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        int lastPos = -1;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                lastPos = i;
                break;
            }
        }

        if (lastPos == -1) {
            for (int i = 0; i < nums.length / 2; ++i) {
                swap(nums, i, nums.length - 1 - i);
            }
            return;
        }

        int i = lastPos + 1;
        int j = nums.length - 1;
        while (j > i) {
            swap(nums, i, j);
            i++;
            j--;
        }

        for (int k = lastPos + 1; k < nums.length; ++k) {
            if (nums[k] > nums[lastPos]) {
                swap(nums, k, lastPos);
                break;
            }
        }
    }
}