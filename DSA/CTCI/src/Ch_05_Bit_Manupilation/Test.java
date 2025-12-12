package Ch_05_Bit_Manupilation;

public class Test {

    static int repeatedAirthmaticShift(int x,int count){
        for(int i=0;i<count;i++){
            x>>=1;
        }
        return  x;
    }

    static int repeatedLogicalShift(int x,int count){
        for(int i=0;i<count;i++){
            x>>>=1;
        }
        return x;
    }

    static void getBit(int num,int i){
        System.out.println(((num & (1<<i))!=0));
    }

    static void setBit(int num,int i){
        num=num|(1<<i);
        System.out.println(num|(1<<i));
        System.out.println(num);
    }

    static void clearBit(int num,int i){
        //int mask=~(1<<i);
        //int mask=(1<<i)-1;
        int mask=(-1<<(i+1));
        System.out.println(mask);
        num=num & mask;
        System.out.println(num);
    }

    public static void main(String[] args) {

        //getBit(9,0);
        //setBit(9,3);
        clearBit(14,2);
//        System.out.println(Integer.toBinaryString(-93242).length());
//        System.out.println(repeatedAirthmaticShift(-93242,40));
//        System.out.println(repeatedLogicalShift(-93242,40));
    }
}
