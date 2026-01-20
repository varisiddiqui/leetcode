class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        List<String> li = new ArrayList<>();
        for(int num: nums) li.add(String.valueOf(num));

        Comparator<String> cmp = (a, b) -> {
            return (b+a).compareTo(a+b);
        };

        Collections.sort(li, cmp);
        StringBuilder str = new StringBuilder();
        for(String s: li) str.append(s);
        int len = str.toString().replace("0", "").length();
        if(len == 0) return "0";
        return str.toString();
        
    }
}