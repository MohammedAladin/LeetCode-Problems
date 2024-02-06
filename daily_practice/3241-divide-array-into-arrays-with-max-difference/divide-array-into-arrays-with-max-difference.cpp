class Solution {
public:
    bool check(int i, vector<int> & nums, int k){
        return (nums[i+2]-nums[i+1] <=k 
        && nums[i+1]-nums[i] <=k && nums[i+2]-nums[i] <=k);
    }
    vector<vector<int>> divideArray(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;     
        for(int i =0; i<nums.size(); i+=3){
            if(check(i,nums,k))
                ans.push_back({nums[i],nums[i+1],nums[i+2]});
            else return vector<std::vector<int>>();
        }
        return ans;
    }
};