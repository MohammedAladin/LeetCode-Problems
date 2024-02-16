bool perceed(const pair<int, int> & a, const pair<int, int> & b){
        return a.second < b.second;
    }
class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        map<int, int> frq;
        int ans=0, end = -1, cnt = 0;
        for(int i = 0; i<arr.size(); ++i){
            frq[arr[i]]++;
        }
        
        vector<pair<int, int>> vec(frq.begin(), frq.end());
        sort(vec.begin(), vec.end(), perceed);
    
        for(int i = 0; i<vec.size(); ++i){
            if(cnt + vec[i].second <=k)
                cnt += vec[i].second;
            else {
                end = i;
                break;
            }
        }
        if(end == -1) return 0;
        return vec.size() - end ;
        
    }
};