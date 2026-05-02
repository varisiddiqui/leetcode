class Solution {
    public double[] internalAngles(int[] sides) {
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];
        Arrays.sort(sides);

        if (a + b <= c || a + c <= b || b + c <= a) {
        return new double[]{};
}
        

      

        double ans[] = new double[3];

        double cmp1 = ((b*b)+(c*c)-(a*a))/(double)(2.0*b*c);

        ans[0] = Math.toDegrees(Math.acos(cmp1));

        double cmp2 = ((a*a)+(c*c)-(b*b))/(double)(2.0*c*a);

        ans[1] = Math.toDegrees(Math.acos(cmp2));
        
        double cmp3 = ((a*a)+(b*b)-(c*c))/(double)(2.0*a*b);

        ans[2] = Math.toDegrees(Math.acos(cmp3));

        Arrays.sort(ans);
        return ans;



        

    }
}