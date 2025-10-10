class Solution {
    public int findMinFibonacciNumbers(int k) {
        if(k == 1) return 1;
        int rem=k;
        int pos=-1;

        

        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(1);

        for(int i=2; i<10000000; i++){
            li.add(li.get(i-1)+li.get(i-2));
            if(li.get(i)>= k){
                pos = i;
                break;
            }
        }
        int c=0;

        for(int i=pos; i>=0; i--){
            if(rem == 0){
                break;
            }
            if(rem >= li.get(i)){
                rem -= li.get(i);
                c++;
            }

        }
        return c;
    }
}