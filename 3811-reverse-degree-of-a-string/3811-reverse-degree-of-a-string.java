class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int p=i+1;
            int pos = ch-96;
            int rev = 27-pos;
           // System.out.println(pos+" "+rev); 
            sum += (p*rev);
        }
        return sum;
    }
}