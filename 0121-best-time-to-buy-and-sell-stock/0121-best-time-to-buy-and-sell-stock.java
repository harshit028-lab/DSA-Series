class Solution {
    public int maxProfit(int[] prices) {
      int minProfit = Integer.MAX_VALUE;
       int maxProfit=0;
        
        for(int price:prices){
            if(price<minProfit){
             minProfit =price;
            }
            if(price-minProfit > maxProfit){
                maxProfit = price-minProfit;
            }
        }
        return maxProfit;
    }
}