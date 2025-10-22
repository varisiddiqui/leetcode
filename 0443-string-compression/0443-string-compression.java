class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;  // where we write compressed data
        int read = 0;   // where we read input

        while (read < n) {
            char currentChar = chars[read];
            int count = 0;

            // count how many same characters
            while (read < n && chars[read] == currentChar) {
                read++;
                count++;
            }

            // write the character
            chars[write++] = currentChar;

            // write the count (if > 1)
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
