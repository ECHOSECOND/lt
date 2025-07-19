package tanxin;

public class maiMaiGuPiao {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit=0;

        // 每一次 prices[i] 与 min 算利润 更新即可

        // min一直更新！！

        for(int i=1;i<prices.length;i++){
            maxProfit = Math.max(maxProfit, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }
}
