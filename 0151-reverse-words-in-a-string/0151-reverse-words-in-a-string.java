class Solution {
    public String reverseWords(String s) {
        String trimmed = s.trim();
        List<String> li = new ArrayList<>();
        int prevGap=-1;

        for(int i=0; i<trimmed.length(); i++){
            if(trimmed.charAt(i) == ' '){
                String add = trimmed.substring(prevGap+1, i).trim();
                if(add.length()>0) li.add(add);
                prevGap=i;
            }
        }
        li.add(trimmed.substring(prevGap+1, trimmed.length()).trim());
        StringBuilder str =new StringBuilder("");
        for(int i=li.size()-1; i>=0; i--){
            if(i!=0)
            str.append(li.get(i)+" ");
            else
            str.append(li.get(i));
        }
        return str.toString();


    }
}