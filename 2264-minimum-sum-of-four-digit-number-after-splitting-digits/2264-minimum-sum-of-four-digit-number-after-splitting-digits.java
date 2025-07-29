class Solution {
    public int minimumSum(int num) {
        int a[] = new int[4];
        int i=0;
        while(num>0){
            a[i++] = num%10;
            num /= 10;
        }

        Arrays.sort(a);
        int num1 = a[0]*10+a[2];
        int num2 = a[1]*10+a[3];
        return num1+num2;
    }
}