class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        allStrings(result, "", 0, 0, n);
        return result;
    }

    public void allStrings(List<String> result, String ans, int open, int close, int max){
        if(ans.length() == max*2){
            result.add(ans);
        }
        if(open < max){
            allStrings(result, ans+"(", open+1, close, max);
        }
        if(close < open){
            allStrings(result, ans+")", open, close+1, max);
        }
    }
}