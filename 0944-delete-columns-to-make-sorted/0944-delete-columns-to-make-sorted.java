class Solution {
    public int minDeletionSize(String[] strs) {
          int n = strs.length;

        int count=0;

        int len = strs[0].length();
        
        for(int i=0; i<len; i++){ //fixed index

        boolean isSame=false;
            
            for(int j=0; j<n-1; j++){ // all strs
                if(strs[j].charAt(i) > strs[j+1].charAt(i)){
                    count++;
                    break;
                }
               // if(strs[j].charAt(i) == strs[j+1].charAt(i)) isSame = true;
            }
            //if(i+1 > count && !isSame) return count;
        }

        return count;
    }
}