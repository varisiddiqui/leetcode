class Solution {
    public boolean completePrime(int num) {
        Set<Integer> set = new HashSet<>();

        int dup = num;
        List<Integer> li = new ArrayList<>();
        while (dup > 0) {
            int d = dup % 10;
            dup /= 10;
            li.add(0, d);
        }
        int n = 0;
        for (int i = 0; i < li.size(); i++) {
            n = n * 10 + li.get(i);
            set.add(n);
        }

        for (int i = li.size() - 1; i >= 1; i--) {
            n = 0;
            for (int j = i; j < li.size() ; j++) {
                n = n * 10 + li.get(j);
                
            }
            set.add(n);
        }
        
        for(int num1 : set){
            if((num1!=2 && num1%2 == 0) || num1==1) return false;
            for(int i=2; i<=(int)Math.sqrt(num1); i++){
                if(num1%i == 0) return false;
            }
        }
        return true;
    }
}