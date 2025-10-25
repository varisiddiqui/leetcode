class Solution {

    static class Pair{
        double fr;
        double a;
        double b;

        public Pair(int a, int b){
            this.a = a*1.0d;
            this.b = b*1.0d;
            this.fr = (double)(this.a/this.b);
        }
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;

        Comparator<Pair> cmp = (a, b) -> {
            return Double.compare(a.fr, b.fr);
        };

        PriorityQueue<Pair> pq = new PriorityQueue<>(cmp);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                pq.add(new Pair(arr[i], arr[j]));
            }
        }
        k--;

        while(k-->0){
            pq.remove();
        }

        int num1 = (int)(pq.peek().a);
        int num2 = (int)(pq.peek().b);

        return new int[]{num1, num2};

    }
}