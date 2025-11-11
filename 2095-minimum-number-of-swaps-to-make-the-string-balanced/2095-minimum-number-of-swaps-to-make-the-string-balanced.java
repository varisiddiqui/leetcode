class Solution {
    public int minSwaps(String s) {
       int n = s.length();
       int i=0;
       int j = s.lastIndexOf('[');

       char ch[] = s.toCharArray();

    
       int op=0, cl=0;
       int ans=0;
       while(i<j){
            if(ch[i] == ']'){
                if(op > cl) cl++;
                else{
                    ans++;
                    ch[i] = '[';
                    ch[j] = ']';
                    op++;

                    j--;
                    while(j>=0 && ch[j] != '[') j--;
                }
            }
            else op++;

            i++;
       }  
       return ans;  
    }
}