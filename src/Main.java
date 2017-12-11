import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int val = 14;
        int[] coins = {1, 5, 10, 20};

        System.out.println("Minimum coins required is "+ findMinCoinNumber(coins, val) );
    }

    private static int findMinCoinNumber(final int[] coins, final int val){

        int[] minCoin = new int[val + 1];
        for (int j = 0; j <= val; j++){
            minCoin[j] = Integer.MAX_VALUE;
        }

        minCoin[0] = 0;

        for (int i = 1; i <= val; i++) {
            for ( int coin: coins)
            {
                if (i >= coin && i - coin >= 0 && minCoin[i-coin] + 1 < minCoin[i]){
                    minCoin[i] = 1 + minCoin[i-coin];
                }
            }
        }
        return minCoin[val];
    }
}
