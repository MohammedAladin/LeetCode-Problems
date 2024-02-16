class Solution {
public:
    bool isPalindrome(string str){
        for(int i = 0; i<str.size(); ++i){
            if(str[i]!=str[str.size()-i-1])return false;
        }
        return true;
    }
    string firstPalindrome(vector<string>& words) {
        for(int i =0; i<words.size(); ++i){
            if(isPalindrome(words[i])){
             return words[i];   
            }
        }
        return "";
    }
};