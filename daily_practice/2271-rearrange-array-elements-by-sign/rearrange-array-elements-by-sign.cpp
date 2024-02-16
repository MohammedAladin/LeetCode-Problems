class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        vector<int> pos;
        vector<int> neg;
        for(int i = 0; i<nums.size(); i++){
            if(nums[i]>0) pos.push_back(nums[i]);
            else neg.push_back(nums[i]);
        }
        int i = 0, j = 0;
        int cnt = 0;
        vector<int> ans;
        while(i<neg.size() && j<pos.size()){
            if(cnt++%2==0){
                ans.push_back(pos[j++]);
            }
            else ans.push_back(neg[i++]);
        }
        while(i<neg.size()){
            ans.push_back(neg[i++]);
        }
        while(j<pos.size()){
            ans.push_back(pos[j++]);
        }
    return ans;
    }
};