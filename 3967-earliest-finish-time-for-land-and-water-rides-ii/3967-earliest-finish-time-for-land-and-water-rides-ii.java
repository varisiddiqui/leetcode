class Solution {
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
        
        int n = ls.length;
        
        int temp[][] = new int[n][3];

        for(int i=0; i<n; i++){
            temp[i][0] = ls[i];
            temp[i][1] = ld[i];
            temp[i][2] = ls[i]+ld[i];
        }

        Comparator<int[]> cmp = (a, b) -> {
            return a[2]-b[2];
        };

        Arrays.sort(temp, cmp);
        int st = temp[0][0];
        int end = temp[0][1];

        int min_Time=Integer.MAX_VALUE;
        int t=0;
        int m = ws.length;

        for(int i=0; i<m; i++){
            //taking water first
            int max1 = Math.max(st+end, ws[i])+wd[i];
            int max2 = Math.max(ws[i]+wd[i], st)+end;
            min_Time = Math.min(min_Time, Math.min(max1, max2));
        }

        temp = new int[m][3];

        for(int i=0; i<m; i++){
            temp[i][0] = ws[i];
            temp[i][1] = wd[i];
            temp[i][2] = ws[i]+wd[i];
        }

        Arrays.sort(temp, cmp);

        st = temp[0][0];
        end = temp[0][1];

        for(int i=0; i<n; i++){
            int max1 = Math.max(st+end, ls[i])+ld[i];
            int max2 = Math.max(ls[i]+ld[i], st)+end;
            min_Time = Math.min(min_Time, Math.min(max1, max2));
        }



        return min_Time;
    }


     


}