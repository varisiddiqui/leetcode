class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int count=0;
        int open=0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            //case-1
            if(ch=='(') 
            open++;

            //case-2
            else if(ch==')' && i+1<n && s.charAt(i+1)==')' && open>0){
                open--;
                i++;
            }

            //case-3
            else if(ch==')' && (i+1==n || s.charAt(i+1)!=')') && open>0){
                open--;
                count++;
            }

            //case-4
            else if(ch==')' && i+1<n && s.charAt(i+1)==')' && open==0){
                count++;
                i++;
            }

            //case-4
            else if(ch==')' && (i+1==n || s.charAt(i+1)!=')') && open==0){
                count += 2;
            }
        
        }

        return count+(open*2);
    }
}