class Solution {
    static class Pair{
        char ch;
        int f;
        public Pair(char ch, int f){
            this.ch = ch;
            this.f = f;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        Comparator<Pair> cmp = (x, y) -> {
            if(x.f != y.f) return y.f-x.f;
            return x.ch-y.ch;
        };

        PriorityQueue<Pair> pq = new PriorityQueue<>(cmp);

        if(a>0)
        pq.add(new Pair('a', a));
        if(b>0)
        pq.add(new Pair('b', b));
        if(c>0)
        pq.add(new Pair('c', c));

        

        StringBuilder str = new StringBuilder("");

        while(pq.size()>=2){
            Pair p1 = pq.remove();
            Pair p2 = pq.remove();

            if(p1.f == p2.f){
                if(str.length()==0 || p1.ch != str.charAt(str.length()-1)){
                    if(p1.f>=2){
                        str.append(p1.ch+""+p1.ch);
                        if(p1.f-2>0) pq.add(new Pair(p1.ch, p1.f-2));
                    }
                    else
                    str.append(p1.ch);

                    if(p2.f>=2){
                        str.append(p2.ch+""+p2.ch);
                        if(p2.f-2>0) pq.add(new Pair(p2.ch, p2.f-2));
                    }
                    else
                    str.append(p2.ch);
                }
                else{

                    if(p2.f>=2){
                        str.append(p2.ch+""+p2.ch);
                        if(p2.f-2>0) pq.add(new Pair(p2.ch, p2.f-2));
                    }
                    else
                    str.append(p2.ch);

                    if(p1.f>=2){
                        str.append(p1.ch+""+p1.ch);
                        if(p1.f-2>0) pq.add(new Pair(p1.ch, p1.f-2));
                    }
                    else
                    str.append(p1.ch);
                }
            }

            //case-2
            else if(p1.f > p2.f){
                if(str.length()==0 || str.charAt(str.length()-1) != p1.ch){
                    if(p1.f>=2){
                        str.append(p1.ch+""+p1.ch);
                        if(p1.f-2>0) pq.add(new Pair(p1.ch, p1.f-2));
                    }
                    else
                    str.append(p1.ch);

                    str.append(p2.ch);
                    if(p2.f-1>0) pq.add(new Pair(p2.ch, p2.f-1));
                }
                else{
                    str.append(p2.ch);
                    if(p2.f-1>0) pq.add(new Pair(p2.ch, p2.f-1));
                    

                    if(p1.f>=2){
                        str.append(p1.ch+""+p1.ch);
                        if(p1.f-2>0) pq.add(new Pair(p1.ch, p1.f-2));
                    }
                    else
                    str.append(p1.ch);

                }
            }

            //case-2

            else if(p2.f > p1.f){
                if(str.length()==0 || str.charAt(str.length()-1) != p2.ch){
                    if(p2.f>=2){
                        str.append(p2.ch+""+p2.ch);
                        if(p2.f-2>0) pq.add(new Pair(p2.ch, p2.f-2));
                    }
                    else
                    str.append(p2.ch);

                    str.append(p1.ch);
                    if(p1.f-1>0) pq.add(new Pair(p1.ch, p1.f-1));
                }
                else{
                    str.append(p1.ch);
                    if(p1.f-1>0) pq.add(new Pair(p1.ch, p1.f-1));
                    

                    if(p2.f>=2){
                        str.append(p2.ch+""+p2.ch);
                        if(p2.f-2>0) pq.add(new Pair(p2.ch, p2.f-2));
                    }
                    else
                    str.append(p2.ch);
                }
            }

        }

        if(pq.size()>0){
            Pair p = pq.remove();
            if(str.length()==0|| str.charAt(str.length()-1) != p.ch){
                
                if(p.f>=2)
                    str.append(p.ch+""+p.ch);
                    else
                    str.append(p.ch);
            }
        }

        return str.toString();


    
    }
}