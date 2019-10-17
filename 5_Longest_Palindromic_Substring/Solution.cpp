// Catalyst's solution. 

#include<iostream>
#include<string>

class Solution 
{
public:
    std::string longestPalindrome(std::string s) 
    {
        if (s.length() < 1)
        {
            return "";
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++)
        {
            int check1 = expandAroundCenter(s, i, i);
            int check2 = expandAroundCenter(s, i, i + 1);
            
            int biggerCheck = std::max(check1, check2);
            if (biggerCheck > end - start)
            {
                start = i - (biggerCheck - 1) / 2;
                end = i + biggerCheck / 2;
            }
        }
        
        return s.substr(start, end - start + 1);
    }
    
private:
    int expandAroundCenter(std::string& s, int left, int right)
    {
        while(left >= 0 && right < s.length() && s[left] == s[right])
        {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
};

int main() {
    Solution solution; 
    std::cout << solution.longestPalindrome("babad") << std::endl; 
}