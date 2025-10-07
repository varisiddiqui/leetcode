class Solution {
    public int monotoneIncreasingDigits(int n) {
        if(n==0) return n;
        List<Integer> li = new ArrayList<>();
        int dup = n;
        
        while(dup>0){
            li.add(dup%10);
            dup /= 10;
        }
        Collections.reverse(li);
        if(li.size() == 1) return n;
        int l=li.size();
        
        for(int i=l-2; i>=0; i--){
            if(li.get(i) > li.get(i+1)){
                li.set(i, li.get(i)-1);
                int j=i+1;
                while(j<l) li.set(j++, 9);
            }
        }
        StringBuilder str = new StringBuilder("");
        int i=0;
        for(i=0; i<l; i++){
            if(li.get(i) !=0) {
                break;
            }
        }

        for(int j=i; j<l; j++){
            str.append(Integer.toString(li.get(j)));
        }
    
        return Integer.parseInt(str.toString());
    }
}