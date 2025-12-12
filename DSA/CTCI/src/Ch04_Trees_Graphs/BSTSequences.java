package Ch04_Trees_Graphs;

public class BSTSequences {

    public static  int countNoKeys(int N){
        int[] arr=new int[N+1];
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<=N;i++){
            for(int j=0;j<i;j++){
                arr[i]=arr[i]+arr[i-j-1]*arr[j];
            }
        }
        return arr[N];
    }


    public static void main(String[] args) {
        System.out.println(countNoKeys(4));


    }

}
