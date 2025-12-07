class Solution {
    public int maxDistinct(String s) {
        int character[] = new int[26];
        int count=0;
        for(char ch: s.toCharArray()){
            if(character[ch-'a'] == 0){
                count++;
                character[ch-'a']=1;
            }
        } 
        return count;
        
    }
}