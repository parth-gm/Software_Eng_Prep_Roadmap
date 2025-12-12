package graph_coding_blocks;

public class SanckGame {

    public static void main(String[] args) {

        int[] board=new int[50];
        System.out.println(board[1]);
        board[2]=13;
        board[5]=2;
        board[9]= 18;
        board[18]=11;
        board[25]=10;
        board[17]=-13;
        board[20]=-14;
        board[24]=-8;
        board[32]=-2;
        board[34]=-22;
        Graph graph=new Graph(50);

         for(int u=0;u<36;u++){
             for(int dice=1;dice<=6;dice++){
                 int v=u+dice+board[u+dice];
                 graph.addEdge(u,v,false);
             }
         }

        graph.bfs(0,36);

//        graph.addEdge(0,1);
//        graph.addEdge(1,2);
//        graph.addEdge(0,4);
//        graph.addEdge(2,4);
//        graph.addEdge(3,2);
//        graph.addEdge(3,5);
//        graph.addEdge(3,4);
//        graph.printAdjList();



    }
}
