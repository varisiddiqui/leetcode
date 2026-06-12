class Solution {
    public boolean buddyStrings(String s, String goal) {
        int n1 = s.length();
        int n2 = goal.length();

        if(n1 != n2) return false;

        char ch1='1';
        char ch2='2';
        char ch3='3';
        char ch4='4';
        int cnt=0;


        for(int i=0; i<n1; i++){
            if(s.charAt(i) != goal.charAt(i)){
                if(ch1 == '1' && ch2 == '2'){
                    ch1 = s.charAt(i);
                    ch2 = goal.charAt(i);
                    
                }
                else if(ch3 == '3' && ch4 == '4'){
                    ch3 = s.charAt(i);
                    ch4 = goal.charAt(i);
                    
                }
                cnt++;
            

                
            }
            
                
        }

        if(cnt > 2) return false;

        
       
       
        if((ch1 == ch4 && ch3 == ch2)){
            return true;
        }

        if(cnt == 0){
            for(int i=0; i<n1; i++){
                char ch = s.charAt(i);
                if(s.lastIndexOf(ch) != i) return true;
            }
        }

        return false;


    }
}