class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int col = strs[0].length();

        boolean row[] = new boolean[n];
        int delete=0;

        for(int i=0; i<col; i++){

            boolean dlt=false;

            for(int j=0; j<n-1; j++){
                if(!row[j] && (strs[j].charAt(i) > strs[j+1].charAt(i))){
                    dlt = true;
                    delete++;
                    break;
                }
            }

            if(!dlt){
                for(int j=0; j<n-1; j++){
                    if(!row[j] && (strs[j].charAt(i) < strs[j+1].charAt(i))){
                        row[j] = true;
                    }
                }
            }


        }

        return delete;
    }
}