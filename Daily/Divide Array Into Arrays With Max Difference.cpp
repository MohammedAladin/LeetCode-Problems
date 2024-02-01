class Solution {
public:
    vector<vector<int>> divideArray(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        int freq[100005] = {0};
     
        for(int i =0; i<nums.size(); i+=3){
            if(nums[i+2]-nums[i+1] <=k && nums[i+1]-nums[i] <=k && nums[i+2]-nums[i] <=k)
                {
                    ans.push_back({nums[i],nums[i+1],nums[i+2]});
                }
            else {
                 vector<vector<int>> z;
                 return z;
            }
        }
        return ans;
    }
};