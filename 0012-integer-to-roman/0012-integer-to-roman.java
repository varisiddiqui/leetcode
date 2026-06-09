class Solution {
    public String intToRoman(int num) {
        int nums[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String roman[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int i=0;

        StringBuilder ans = new StringBuilder();
        while(num>0){
            while(i<13 && (num < nums[i])) i++;

            int times = num/nums[i];

            for(int j=0; j<times; j++) ans.append(roman[i]);

            num %= nums[i];
        }

        return ans.toString();
    }
}