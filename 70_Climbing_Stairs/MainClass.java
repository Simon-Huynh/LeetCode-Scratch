// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Note: Given n will be a positive integer.

// Example 1:
// Input: 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps

// Example 2:
// Input: 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step


import java.io.*; 

class Solution {
    public int climbStairsTimeout(int n) {
        // There are only two ways to reach a step. By 1 step, or by 2 steps. Use this information. 
        // Base case 1. Only one way. Base case 2. Two ways, 1-1, or with a single 2 step. 
        // Reurrence will be F[n] = F[n-1] + F[n-2]
        if (n < 1) { return 0; }
        if (n == 1) { return 1; }
        if (n == 2) { return 2; }
        return climbStairs(n-1) + climbStairs(n-2); 
        // Solution works on local. But times out on leetcode submission of input 44. 
    }

    public int climbStairsLottaSpace(int n) {
        // Want to build on earlier solution by including some sort of memoization for optimization.
        if (n == 1 ) { return 1; }
        int[] solutionArray = new int[n+1]; 
        solutionArray[0] = 0; 
        solutionArray[1] = 1; 
        solutionArray[2] = 2; 
        for (int i = 3; i <= n; i++) { 
            solutionArray[i] = solutionArray[i-1] + solutionArray[i-2]; 
        }
        return solutionArray[n]; 
    }

    public int climbStairs(int n) { 
        // How can we improve upon this by not using the array? 
        // If at step n, we only really need to know result of n-1 and n-2. 
        if (n == 1) { return 1; }
        if (n == 2) { return 2; } 
        int resultOneDown = 2; 
        int resultTwoDown = 1; 
        int result = 0; 
        for (int i = 3; i <= n; i++) {
            result = resultOneDown + resultTwoDown; 
            resultTwoDown = resultOneDown; 
            resultOneDown = result; 
        }
        return result; 
        // Weird. After running this on leetcode it's about the same memory space. 
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.print("In :" + line); 

            int n = Integer.parseInt(line);

            int ret = new Solution().climbStairs(n);

            String out = String.valueOf(ret);

            System.out.println(" Out:" + out);
        }
    }
}