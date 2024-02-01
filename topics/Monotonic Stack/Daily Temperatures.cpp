/*
وَلَا تَحْسَبَنَّ اللَّهَ غَافِلًا عَمَّا يَعْمَلُ الظَّالِمُونَ إِنَّمَا يُؤَخِّرُهُمْ لِيَوْمٍ تَشْخَصُ فِيهِ الْأَبْصَارُ
*/
class Solution {
public:
    vector<int> monotonicStack(vector<int>& temps){
        stack<pair<int,int>> monSt;
        vector<int> ans(temps.size());

        for(int i = temps.size()-1; i>=0; --i){
            while(!monSt.empty() && monSt.top().first<=temps[i]){
                monSt.pop();
            }
            ans[i] = (monSt.empty()) ? 0 : monSt.top().second - i ;
            monSt.emplace(temps[i], i);
        }
        return ans;
    }
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        return monotonicStack(temperatures);
    }
};