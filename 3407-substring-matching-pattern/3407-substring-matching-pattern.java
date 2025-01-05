class Solution {
    public boolean hasMatch(String s, String p) {
        String start = p.substring(0, p.indexOf('*'));
        String end = p.substring(p.indexOf('*') + 1);
        int i = s.indexOf(start);
        int j = s.lastIndexOf(end);
        if( (i+start.length() - 1) < j)
        return true;

        return false;

    }
}