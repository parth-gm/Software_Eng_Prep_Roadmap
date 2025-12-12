package graph_coding_blocks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FloodFill {

    int R,C;

    void print(char mat[][]){

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }

    }

    public void floodFill(char mat[][],int i,int j,char ch,char color){

        if(i<0||j<0||i>=R||j>=C||mat[i][j]!=ch){
            return;
        }
        mat[i][j]=color;

        floodFill(mat,i-1,j,ch,'R');
        floodFill(mat,i,j-1,ch,'R');
        floodFill(mat,i+1,j,ch,'R');
        floodFill(mat,i,j+1,ch,'R');

    }





    public static void main(String[] args) throws FileNotFoundException {
        char[][] mat=new char[50][50];
        Scanner sc= null;

        sc = new Scanner(new FileInputStream(args[0]));

        FloodFill ff=new FloodFill();
        ff.R=sc.nextInt();
        ff.C=sc.nextInt();


        for(int i=0;i<ff.R;i++){
            mat[i]=sc.next().substring(0,ff.C).toCharArray();
        }
        ff.print(mat);
        ff.floodFill(mat,3,2,'.','R');
        ff.print(mat);
    }
}
