class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<nums.length; ++i){
            pq.add(nums[i]);
        }

        int idx = nums.length - k;
        int ans = 0;
        while(idx>0){
           pq.poll();
           idx--;
        }

        return pq.peek();
    }
}