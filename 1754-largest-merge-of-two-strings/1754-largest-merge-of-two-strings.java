class Solution {
    public String largestMerge(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int i=0;
        int j=0;

        StringBuilder ans = new StringBuilder("");

        while(i<n1 && j<n2){
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(j);
            //case-1
            if(ch1 > ch2){
                ans.append(ch1);
                i++;
            }
            else if(ch1 < ch2){
                ans.append(ch2);
                j++;
            }
            else{
                //case-i
                if(word1.substring(i).compareTo(word2.substring(j)) >= 0){
                    ans.append(ch1);
                    i++;
                }
                else{
                    ans.append(ch2);
                    j++;
                }
            }
        }

        while(i<n1){
            ans.append(word1.charAt(i++));
        }
        while(j<n2){
            ans.append(word2.charAt(j++));
        }

        return ans.toString();
        
      
    
    }
}