class Solution {
public:
    string solve(string s, string t){
          map<char,int>tmp;
    map<char,int>smp;
    for(int i = 0; i<s.size(); i++){
        smp[s[i]]++;
    }
    int i = 0, j = 0, cnt = 0, ans = 100005;
    int sz = 0;
    pair<int,int> ij;

    while(j<=t.size()){

        if(smp[t[i]]==0){
            i++;
            j = (i>j) ? i : j;
            continue;
        }
        else if(tmp[t[i]]>smp[t[i]]){
            tmp[t[i]]--;
            i++;
            continue;
        }
        else if(cnt==s.size()){

            if(ans>j-i){
                ans = j-i;
                ij.first = i, ij.second = j;
            }
            tmp[t[i]]--;
            cnt--, i++;
            continue;

        }
        if(smp[t[j]]>0){
            if(smp[t[j]]>tmp[t[j]])
                ++cnt;
            ++tmp[t[j]];
        }
        j++;
    }
    string str = "";
    for(int k = ij.first; k<ij.second; k++){
        str+=t[k];
    }
    return str;
    }
    string minWindow(string s, string t) {
       return solve(t, s);
    }
};