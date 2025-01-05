class Solution {
    public boolean hasMatch(String s, String p) {
        String str = p.replace("*", "");
        if(s.contains(str))
        return true;
        String start = p.substring(0, p.indexOf('*'));
        String end = p.substring(p.indexOf('*') + 1);
        int i = s.indexOf(start);
        int j = s.indexOf(end , i+start.length());
        if(i!= -1 && j!= -1  && i < j)
        return true;

        return false;

    }
}