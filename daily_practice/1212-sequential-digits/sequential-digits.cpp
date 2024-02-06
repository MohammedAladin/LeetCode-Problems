class Solution {
public:
 vector<int> sequentialDigits(int low, int high) {
        
        vector<int> ans;
        for(int i = 1; i<10; i++){
            int sum = i;
            for(int j = i+1; j<10; j++){
                sum = sum * 10 + j;
                if(sum>=low && sum<=high){
                    ans.push_back(sum);
                }
            }
        }
        sort(ans.begin(),ans.end());
        return ans;
    }
};