class Solution {
    public String sortVowels(String s) {
        int n = s.length();

        Map<Character, List<Integer>> hm = new HashMap<>();

        

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == 'a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                hm.putIfAbsent(ch, new ArrayList<>(Arrays.asList(i,0)));
                List<Integer> li = hm.get(ch);
                li.set(1, li.get(1)+1);                
            } 
        }

        int arr[][] = new int[n][3];
        int i=0;

        for(char ch: hm.keySet()){
            List<Integer> li = hm.get(ch);
            arr[i][0] = ch-'a';
            arr[i][1] = li.get(1); //freq
            arr[i][2] = li.get(0); //first index
            i++;
        }

        Comparator<int[]> cmp = (a,b) -> {
            if(a[1] != b[1]) return Integer.compare(b[1], a[1]);
            else return Integer.compare(a[2], b[2]);
        };

        Arrays.sort(arr, cmp);

        char ch[] = s.toCharArray();
        int j=0;

        for(int k=0; k<n; k++){
            if(hm.containsKey(ch[k])){
                ch[k] = (char)(97+arr[j][0]);
                if(arr[j][1]-1 == 0) j++;
                else arr[j][1]--;
            }
        }

        return String.valueOf(ch);






    }
}