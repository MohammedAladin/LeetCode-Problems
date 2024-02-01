/*
وَلَا تَحْسَبَنَّ اللَّهَ غَافِلًا عَمَّا يَعْمَلُ الظَّالِمُونَ إِنَّمَا يُؤَخِّرُهُمْ لِيَوْمٍ تَشْخَصُ فِيهِ الْأَبْصَارُ
*/
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int l = 0, r = nums.size()-1, mid;
        vector<int> ans(2,-1);

        while(l<=r){
            mid = (l+r)/2;
            if(nums[mid] <= target){
                ans[1] = mid;
                l = mid + 1;
            }
            else r = mid - 1;
           
        }
        l = 0, r = nums.size() -1;
        while(l<=r){
            mid = (l+r)/2;
            if(nums[mid] < target){
                l = mid + 1;
            }
            else if(nums[mid] > target) r = mid - 1;
            else {
                ans[0] = mid;
                r = mid - 1;
            }
        }
        return ans;
    }
};