class Solution {
    public int minimumLevels(int[] possible) {
        int zero=0;
        int one=0;
        int sum=0;
        int n = possible.length;
        for(int i=0; i<n; i++){
            if(possible[i] == 0)
            sum -= 1;
            else
            sum += 1;
        }

        int alice=0;
        int z=0, o=0;
        int res=-2;
        for(int i=0; i<n; i++){
            if(possible[i] == 0) z++;
            else o++;

            alice = (o*1)-(z*1);
            int bob = sum-alice;
            if(alice>bob){
                res = i+1;
                break;
            }
        }
        if(res!= n && res!=-2) return res;
        return -1;
    }
}