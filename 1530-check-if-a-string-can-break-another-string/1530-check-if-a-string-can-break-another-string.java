class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char ch1 [] = s1.toCharArray();
        char ch2 [] = s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);
        boolean res1 = false;
        boolean res2 = false;


        for(int i=0; i<s1.length(); i++){
            if(!res1 && ch1[i]>ch2[i]){
                res1=true;
            }
            if(!res2 && ch1[i]<ch2[i]){
                res2 = true;
            }

            
        }

       // System.out.println(res1+" "+res2);

       // if(res1==false && res2==false) return true;

        return (res1 && res2)?false:true;

        //return true;


    }
}