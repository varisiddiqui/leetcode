class Solution {
    public int largestRectangleArea(int[] a) {
        int n = a.length;
        long max=0;
        Stack<Integer> s = new Stack<>();
    
        int nextMin[] = new int[n];
        int prevMin[] = new int[n];

        for(int i=n-1; i>=0; i--){
            if(i==n-1){
                s.push(i);
                nextMin[i]=n;
            }
            else{
                if(a[i]>a[s.peek()]){
                    nextMin[i]=s.peek();
                    s.push(i);
                }
                else{
                    while(!s.isEmpty() && a[i] <= a[s.peek()]){
                        s.pop();
                }
                if(s.isEmpty()){
                    s.push(i);
                    nextMin[i]=n;
                }
                if(a[i] > a[s.peek()]){
                    nextMin[i]=s.peek();
                    s.push(i);
                }

                }
            }
        }

        s.clear();
        for(int i=0; i<n; i++){
            if(i==0){
                s.push(i);
                prevMin[i]=-1;
            }
            else{
                if(a[i]>a[s.peek()]){
                    prevMin[i]=s.peek();
                    s.push(i);
                }
                else{
                    while(!s.isEmpty() && a[i] <= a[s.peek()]){
                        s.pop();
                }
                if(s.isEmpty()){
                    s.push(i);
                    prevMin[i]=-1;
                }
                if(a[i] > a[s.peek()]){
                    prevMin[i]=s.peek();
                    s.push(i);
                }

                }
            }
        }
        /* for(int i=0; i<n; i++)
        System.out.print(nextMin[i]+" ");
        System.out.println();

        for(int i=0; i<n; i++)
        System.out.print(prevMin[i]+" "); */

        for(int i=0; i<n; i++){
            long width = (nextMin[i]-prevMin[i])-1;
            long area = a[i]*width;
            max = Math.max(area, max);
        }
        return (int)max;

    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int height[] = new int[n];

        int maxAr=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1')
                    height[j]++;
                    else
                    height[j]=0;
            }
            int area = largestRectangleArea(height);
            maxAr = Math.max(area, maxAr);
        }  
        return maxAr; 

    }
    
}