class Solution {
    HashSet<String> res = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        
        StringBuilder str = new StringBuilder();
        int n = tiles.length();
        int vis[] = new int[n];
        Arrays.fill(vis, -1);

        ways(tiles, vis, str);

        System.out.println(res);

        return res.size();
        
    }

    public void ways(String tiles, int vis[], StringBuilder str){
        int n = tiles.length();

        boolean allVisited = true;

        for(int i=0; i<n; i++){
            if(vis[i] == -1){
                allVisited = false;
                break;
            }

        }

        if(allVisited){
            if(str.length()>0)
            res.add(new String(str));
            return;
        } 


       

        for(int i=0; i<n; i++){
            if(vis[i] == -1){
                vis[i] = 1;
                str.append(tiles.charAt(i));
                ways(tiles, vis, str);
                vis[i] = 0;
                str.deleteCharAt(str.length()-1);
                ways(tiles, vis, str);
                vis[i]=-1;
            }
        }

    
    }
}