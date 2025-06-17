class Solution {
    public boolean isPalindrome(int x) {
        int dup = x;
        int rev=0;
        while(dup>0){
            int d = dup%10;
            rev = rev*10+d;
            dup /= 10;
        }
        return (rev == x);
    }
}