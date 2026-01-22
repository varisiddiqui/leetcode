class Solution {
    public boolean canChange(String start, String target) {
       
        List<Integer> idxS = new ArrayList<>();
        List<Integer> idxT = new ArrayList<>();

        int n1 = start.length();
        int n2 = target.length();

        for(int i=0; i<n1; i++){
            if(start.charAt(i) != '_') idxS.add(i);
        }
        for(int i=0; i<n2; i++){
            if(target.charAt(i) != '_') idxT.add(i);
        }


        if(idxS.size() != idxT.size()) return false;
        int n = idxS.size();

        //checking from left for L
        int i=0;
        int j=0;
        int cnt=n;

        while(i<n && j<n){
            //got L
            while(j<n && target.charAt(idxT.get(j)) != 'L') j++; //got L at j
            if(j == n) break;


            while(i<n && start.charAt(idxS.get(i)) != 'L') i++; //got L in i
            if(i==n) return false;

            //System.out.println(i+" "+j);

            if(idxT.get(j) == idxS.get(i)) {
                cnt--;
            }

            else if(idxT.get(j) > idxS.get(i)) return false;

            else {
                if(i==0) 
                {
                    cnt--;
                    idxS.set(i, idxT.get(j));
                }
                else if(idxS.get(i-1) >= idxT.get(j)){
                    return false;
                }
                else{
                    cnt--;
                    idxS.set(i, idxT.get(j));
                }

            }
            i++;
            j++;
            
        }

        i=n-1;
        j=n-1;

        while(i>=0 && j>=0){
            //got R
            while(j>=0 && target.charAt(idxT.get(j)) != 'R') j--; //got R at j
            if(j == -1) break;

            while(i>=0 && start.charAt(idxS.get(i)) != 'R') i--; //got R in i
            if(i==-1) return false;

            if(idxT.get(j) == idxS.get(i)) {
                cnt--;
            }

            else if(idxT.get(j) < idxS.get(i)) return false;

            else {
                if(i==n-1){
                    cnt--;
                    idxS.set(i, idxT.get(j));
                } 
                else if(idxS.get(i+1) <= idxT.get(j)){
                    return false;
                }
                else{
                    cnt--;
                    idxS.set(i, idxT.get(j));
                }

            }
            i--;
            j--;
        }
        if(cnt == 0) return true;
        return false;
        
        
              

        
    }
}