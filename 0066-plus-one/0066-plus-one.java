class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> li = new ArrayList<>();
        int n = digits.length;
        if(n==1){
            if(digits[0] == 9){
                return new int[]{1, 0};
            }
            else return new int[]{digits[0]+1};
        }
        digits[n-1] += 1;
        for(int i=n-1; i>=1; i--){
            if(digits[i] == 10){
                li.add(0, 0);
                digits[i-1] += 1;
            }
            else{
                li.add(0, digits[i]);
            }
           
        }
       // System.out.println(li);

        if(digits[0] == 10){
            li.add(0, 0);
            li.add(0, 1);
           // System.out.println(li);

        }
        else li.add(0, digits[0]);
        
        int ans[] = new int[li.size()];
        int k=0;
        for(int num: li) ans[k++]=num;
        return ans;


    }
}