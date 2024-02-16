bool perceed(const pair<int, int> & a, const pair<int, int> & b){
        return a.second < b.second;
    }
class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        unordered_map<int, int> frq;
        vector<int> vec;
        int ans=0, end = -1, cnt = 0;

        for(auto a: arr){
            frq[a]++;
        }
        for(auto a: frq){
            vec.push_back(a.second);
        }
        sort(vec.begin(), vec.end());
    
        for(int i = 0; i<vec.size(); ++i){
            if(cnt + vec[i] <=k)
                cnt += vec[i];
            else {
                end = i;
                break;
            }
        }
        if(end == -1) return 0;
        return vec.size() - end ;
        
    }
};