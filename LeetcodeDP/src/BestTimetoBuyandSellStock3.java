import java.util.HashSet;
import java.util.Set;


public class BestTimetoBuyandSellStock3 {
	public static int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int nextStart=0;
        int maxProfit=0;
        int profit=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            
            if(prices[i]-prices[i-1]<0){
                nextStart=findNextstart(prices,i);
                maxProfit=Math.max(maxProfit,secondTransaction(prices,nextStart,profit));
                
                i=nextStart--;
                System.out.println("nextStart:"+nextStart+" maxprofit:"+maxProfit);
            }
            int temp=prices[i]-min;
            if(temp<0){
                min=prices[i];
            }
            if(temp>profit){
                profit=temp;
            }
            System.out.println("profit:"+profit);
            maxProfit=Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
    private static int findNextstart(int[] prices,int start){
        int i;
        for(i=start+1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0){
                return i-1;
            }
        }
        return i-1;
    }
    
    private static int secondTransaction(int[] prices,int start,int firstProfit){
        int profit=0;
        int min=prices[start];
        for(int i=start+1;i<prices.length;i++){
            int temp=prices[i]-min;
            if(temp<0){
                min=prices[i];
            }
            if(temp>profit){
                profit=temp;
            }
        }
        return profit+firstProfit;
    }
    
    public static void main(String args[]) {
    	int[] prices={5,6,6,5,4,1,9,2,4,5};
    	maxProfit(prices);
	}

    /*better c++ solution
     class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(prices.size() <= 1)
            return 0;
            
        //stores the max profit in [0, ... , i] subarray in prices
        vector<int> maxEndWith;
        {//build the maxEndWith.
            int lowest = prices[0];
            int maxprofit = 0;
            maxEndWith.push_back(0);
            for(int i = 1; i < prices.size(); ++i) {
                int profit = prices[i] - lowest;
                if(profit > maxprofit) {
                    maxprofit = profit;
                }
                maxEndWith.push_back(maxprofit);
                if(prices[i] < lowest) lowest = prices[i];
            }
        }
        
        int ret = maxEndWith[prices.size() - 1];
        {//reverse to see what is the maxprofit of [i, ... , n-1] subarray in prices
        //and meanwhile calculate the final result
            int highest = prices[prices.size() - 1];
            int maxprofit = 0;
            for(int i = prices.size() - 2; i >= 0; --i) {
                int profit = highest - prices[i];
                if(profit > maxprofit)  maxprofit = profit;
                int finalprofit = maxprofit + maxEndWith[i];
                if(finalprofit > ret) ret = finalprofit;
                if(prices[i] > highest) highest = prices[i];
            }
        }

        return ret;
    }
};
     */
}
