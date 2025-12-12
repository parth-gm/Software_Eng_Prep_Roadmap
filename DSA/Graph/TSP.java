package graph_coding_blocks;

public class TSP {

    int n=4;
    int[][] dp=new int[16][4];

    int dist[][]={
            {0,20,42,25},
        {20,0,30,34},
        {42,30,0,10},
        {25,34,10,0}
    };

    int VISITED_ALL=(1<<n)-1;

    int tsp(int mask,int pos){
        if(mask==VISITED_ALL){
            return dist[pos][0];
        }

        if(dp[mask][pos]!=-1){
            return dp[mask][pos];
        }

        int ans=Integer.MAX_VALUE;
        for(int city=0;city<n;city++){

            if((mask&(1<<city))==0){
                int newAns=dist[pos][city]+tsp((mask|(1<<city)),city);
                ans=Math.min(ans,newAns);
            }
        }
        return  dp[mask][pos]=ans;

    }

    public static void main(String[] args) {

        TSP tsp=new TSP();

        for (int i=0;i<(1<<tsp.n);i++){
            for(int j=0;j<tsp.n;j++){
                tsp.dp[i][j]=-1;
            }
        }

        System.out.println("Min weight hamiltonian Path: "+tsp.tsp(1,0));

    }

}
