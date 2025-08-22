class Solution {
    public int minimumSwap(String s1, String s2) {
        int x=0;
        int y=0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) == 'x' && s2.charAt(i) == 'y'){
                x++;
            }
            if(s1.charAt(i) == 'y' && s2.charAt(i) == 'x'){
                y++;
            }
        }


        int ans = x/2;
        ans += y/2;

        if(x==1 && y==1)
        return 2;
        if(x%2 != y%2){
            return -1;
        }
        else{
            if(x%2 == 1) return ans+2;
           
        }
        return ans;
    }
}