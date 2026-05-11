class Solution {
    public int countMonobit(int n) {
        int cnt=0;
        for(int i=0; i<=n; i++){
            String bin = Integer.toBinaryString(i);
            if(bin.contains("1")&&bin.contains("0")) continue;
            cnt++;

        }
        return cnt;
    }
}