class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder str = new StringBuilder("");

        while (a > 0 && b > 0) {
            if (a > b) {
                if (str.length()==0 || str.charAt(str.length() - 1) == 'b') {
                    str.append("aa");
                    a -= 2;
                    str.append("b");
                    b -= 1;
                } else {
                    str.append("b");
                    b -= 1;
                    str.append("aa");
                    a -= 2;
                }

            }

            else if (b > a) {
                if (str.length() == 0 || str.charAt(str.length() - 1) == 'a') {
                    str.append("bb");
                    b -= 2;
                    str.append("a");
                    a -= 1;
                } else {
                    str.append("a");
                    a -= 1;
                    str.append("bb");
                    b -= 2;
                }

            } else {
                if (str.length()==0 || str.charAt(str.length() - 1) == 'b') {
                    str.append("a");
                    a -= 1;
                    str.append("b");
                    b -= 1;
                } else {
                    str.append("b");
                    b -= 1;
                    str.append("a");
                    a -= 1;
                }

            }
        }

        while(a>0){
            str.append('a');
            a--;
        }
        while(b>0){
            str.append('b');
            b--;
        }

        return str.toString();
    }
}