package bitmasking;

public class BasicsOfBitMask {

    static  int getIthBit(int n,int i){
        return (n & (1<<i))!=0?1:0;
    }

    static  int setIthBit(int n,int i){
         int mask= (1<<i);
        return (n |mask);
    }
    static  int clearIthBit(int n,int i) {
        int mask = ~(1 << i);
        return (n & mask);
    }


        static void isOddEven(int d){
        int n=d & 1;
        if (n==1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }
    //Time: O(No of Bits)
    static int countSetBits(int n){

        int count=0;
        while (n>0){
            count+=(n&1);
            n=n>>1;
        }
        return count;

    }

    //Time: O(No of Set Bits)
    static int countSetBitsFast(int n){

        int count=0;
        while (n>0){
            count++;
            n=n&(n-1);
        }
        return count;

    }

    public static void main(String[] args) {
        /*
        //FindUnique
        int arr[]={2,3,5,3,2};
        int no=arr[0];
        for (int i=1;i<arr.length;i++){
            no=no^arr[i];
        }
        System.out.println(no);
        */


        //isOddEven(14);

        //System.out.println(countSetBits(10));
        //System.out.println(countSetBitsFast(10));
        //System.out.println(getIthBit(13,2));

        //System.out.println(setIthBit(13,1));
        System.out.println(clearIthBit(13,2 ));
    }

}
