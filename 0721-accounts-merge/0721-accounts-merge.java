class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        
        int par[] = new int[n];
        int rank[] = new int[n];

        Map<String, Integer> hm = new HashMap<>();

        for(int i=0; i<n; i++) par[i]=i;

        for(int i=0; i<n; i++){
            List<String> li = accounts.get(i);

            for(int j=1; j<li.size(); j++){
                hm.putIfAbsent(li.get(j), i);
                if(hm.containsKey(li.get(j))){
                    int merge_with = hm.get(li.get(j));
                    union(i, merge_with, rank, par);
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();

        Map<Integer, List<String>> map = new HashMap<>();

        for(String mail: hm.keySet()){
            int parNode = hm.get(mail);
            int ultimate_par = find(parNode, par);
            map.putIfAbsent(ultimate_par, new ArrayList<>());
            map.get(ultimate_par).add(mail);
        }
        
        for(int node: map.keySet()){
            Collections.sort(map.get(node));
            
        }

        for(Integer pen_ultimate: map.keySet()){
            String account_name = accounts.get(pen_ultimate).get(0);
            List<String> temp = new ArrayList<>();
            temp.add(account_name);
            

            temp.addAll(map.get(pen_ultimate));
            ans.add(temp);
        }
        return ans;

        


    }

    public int find(int x, int par[]){
        if(x == par[x]) return x;

        return par[x] = find(par[x], par);
    }

    public void union(int x, int y, int rank[], int par[]){
        int px = find(x, par);
        int py = find(y, par);

        if(rank[px] == rank[py]){
            par[px] = py;
            rank[py]++;
        }
        else if(rank[px] < rank[py]){
            par[px] = py;
        }
        else {
            par[py] = px;
        }
    }
}