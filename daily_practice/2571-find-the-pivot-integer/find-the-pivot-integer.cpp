class Solution {
public:
    int pivotInteger(int n) {
        std::vector<int> pref(n + 2);
        for (int i = 1; i < n + 1; ++i) {
            pref[i] = pref[i - 1] + i;
        }
        for (int i = 1; i <= n; i++) {
            if (pref[i] == pref[n] - pref[i-1]) // Compare with pref[n] - pref[i]
                return i;
        }
        return -1;
    }
};