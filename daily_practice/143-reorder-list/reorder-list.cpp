/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        vector<int> nums;
        vector<int> ans;
        int cond = 0;
        ListNode* temp = head;
        while(temp){
            nums.push_back(temp->val);
            temp = temp->next;
        }

        temp = head;
        int i = 0, j = nums.size()-1;
        
        while(i<=j){
            if(cond%2==0){
                ans.push_back(nums[i++]);
            }
            else{
                ans.push_back(nums[j--]);
            }
            cond++;
        }
        i = 0;
        while(temp){
            temp->val=ans[i++];
            temp = temp->next;
        }
    }
};