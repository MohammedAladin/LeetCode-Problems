bool comparePair(const pair<int, int>& a, const pair<int, int>& b) {
    return a.second > b.second;
}
class Solution {
public:
   

string frequencySort(string s) {
    map<char, int> frq;
    string ans = "";
    for(char i : s){
        frq[i]++;
    }

    vector<pair<char, int>> vec(frq.begin(), frq.end());
    sort(vec.begin(), vec.end(), comparePair);


    for(int i =0; i<vec.size(); i++){
        for(int j = 0; j<vec[i].second; j++){
            ans+=vec[i].first;
        }
    }

    return ans;
    }
};