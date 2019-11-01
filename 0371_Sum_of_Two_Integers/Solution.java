// Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

// Example 1:
// Input: a = 1, b = 2
// Output: 3

// Example 2:
// Input: a = -2, b = 3
// Output: 1

class Solution {
    public static int getSum(int a, int b) {
        // System.out.println("\nIn getSum for a = " + Integer.toString(a) + " ,b = " + Integer.toString(b)); 
        // System.out.println("binary format a = " + Integer.toBinaryString(a)); 
        // System.out.println("binary format b = " + Integer.toBinaryString(b)); 

        // If carry is 0, recursion complete, return result. 
        if (b == 0) { return a; }
        return getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(getSum( 1, 2)); 
        System.out.println(getSum(-2, 3)); 
    }
}