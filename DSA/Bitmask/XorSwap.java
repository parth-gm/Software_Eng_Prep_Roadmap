package bitmasking;

public class XorSwap {

    static void swap(int a,int b){
        a=a^b;
        b=b^a;
        a=a^b;

        System.out.println("A:"+a);
        System.out.println("B:"+b);
    }

    public static void main(String[] args) {
        swap(5,7);
    }
}
