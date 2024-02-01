class Solution {
    int dp[1001][1001];
    string sec,first,str;
public:
    
int palindrom(int l, int r){
    if(l>r) return 0;
    if(r==l) return 1;

    int & ret = dp[l][r];
    if(~ret) return ret;
    if(str[l]==str[r] && palindrom(l + 1, r - 1) == (r-1) - (l+1) +1){
        ret = 2 + palindrom(l + 1, r - 1);
    }
    else{

        ret = std::max(palindrom(l + 1, r), palindrom(l, r - 1));
    }
    return ret;
}
void build(int l, int r){
    if(l>r) return;
    if(l==r){
        first+=str[l];
        return;
    }
    int & ret = dp[l][r];
    if(str[l]==str[r] && palindrom(l + 1, r - 1) == (r-1) - (l+1) +1){
        if(ret==palindrom(l + 1, r - 1) + 2){
          first+=str[l], sec+=str[r];
          build(l + 1, r - 1);
        }
    }
    else {
        if(palindrom(l + 1, r)>palindrom(l, r - 1)){
            build(l+1,r);
        }
        else{
            build(l,r-1);
        }
    }
}
    string longestPalindrome(string s) {
        str = s;

        int n = s.size();
        memset(dp,-1,sizeof(dp));
        int longest = palindrom(0,n-1);
        build(0,n-1);
        reverse(sec.begin(), sec.end());

        return first + this->sec;

       
    }
};