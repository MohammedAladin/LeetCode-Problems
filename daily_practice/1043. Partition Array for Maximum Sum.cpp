class Solution {
public:
    int dp[501];
    int maxArrs(vector<int> & arr, int i , int k){
        int n = arr.size(), mx = 0;

        if(i>=n) return 0;
        
        int & ret = dp[i];
        if(~ret) return ret;
        ret = 0;
        for(int j = i; j < min(i + k, n); j++){
            mx = max(mx,arr[j]);
            ret = max(ret, (j - i + 1)*mx + maxArrs(arr, j+1, k));
        }
        return ret;
        
    }
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        memset(dp,-1,sizeof(dp));
        return maxArrs(arr,0,k);
    }
};
