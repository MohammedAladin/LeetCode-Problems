class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string, vector<int>> angs;
        vector<vector<string>> ans;

        for(int i = 0; i<strs.size(); i++){
            string freq = "00000000000000000000000000";
            for(int j = 0; j<strs[i].size(); j++){
                freq[strs[i][j]-'a']++;
            }
            angs[freq].push_back(i);
        }
        for(auto val : angs){
            vector<string>sub;
            for(int i = 0; i<val.second.size(); i++){
                sub.push_back(strs[val.second[i]]);
            }
            ans.push_back(sub);
        }
        return ans;
    }
};