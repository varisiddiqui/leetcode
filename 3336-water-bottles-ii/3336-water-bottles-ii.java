class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int consumed = numBottles;
        int empty = numBottles;
        while(empty >= numExchange){
            empty -= numExchange;
            consumed++;
            numExchange++;
            empty++;
        }
        return consumed;
    }
}