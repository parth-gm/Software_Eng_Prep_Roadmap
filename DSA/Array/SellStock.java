package leetcode;

public class SellStock {


    public int maxProfitv1(int[] prices) {
        int minprice=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int i=0;i<prices.length;i++){
            if(minprice>prices[i]){
                minprice=prices[i];
            }
            else if(prices[i]-minprice > maxprofit){
                maxprofit=prices[i]-minprice;
            }
        }
        return maxprofit;
    }


    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                int diff=prices[j]-prices[i];
                if(diff>0 && max< diff){
                     max=diff;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
