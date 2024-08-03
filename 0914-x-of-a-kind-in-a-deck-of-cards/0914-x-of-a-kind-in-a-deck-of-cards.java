class Solution {
public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length==1)return false;
        int [] freq = new int[10001];
        for(int dc : deck){
            freq[dc]++;
        }
        int min = 10001;
        for(int frq :  freq){
            if(frq!=0 && frq<min){
                min = frq;
            }
        }
        for(int i = 2; i <= min; ++i) {
            boolean valid = true;
            for (int frq : freq) {
                if (frq != 0 && frq%i!=0) {
                    valid = false;
                    break;
                }
            }
            if(valid) return true;
        }

        return false;
    }
}