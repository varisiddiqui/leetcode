class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        if(n==1){
            return 1;
        }

        int c=0;

        int i=0;
        int j = n-1;

        while(i<j) {
            if(people[i]+people[j] <= limit){
                c++;
                i++;
                j--;
            }
            else{
                j--;
                c++;
            }
        }
        if(i==j)
        c++;

        
         
        return c;
    }
}