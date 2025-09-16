class Solution {
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
        int l=ls.length;
        int w = ws.length;

        int max = Integer.MAX_VALUE;

        for(int i=0; i<l; i++){
            int l1=ls[i];
            int lc=ld[i];
            for(int j=0; j<w; j++){
                int w1=ws[j];
                int wc=wd[j];
                int time=0;

                if(l1 < w1){
                    time += l1+lc;
                    int gap = Math.max(time, w1);
                    time += gap-time;
                    time += wc;
                    max = Math.min(max, time);
                }
                else if(l1 == w1){
                    time += l1+lc+wc;
                     max = Math.min(max, time);
                }
                else{
                    time += w1+wc;
                    int gap = Math.max(time, l1);
                    time += gap-time;
                    time += lc;
                     max = Math.min(max, time);
                }
            }
        }
        return max;
    }
}