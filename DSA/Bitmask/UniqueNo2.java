package bitmasking;

public class UniqueNo2 {

    static  void findUnique(int[] arr,int n){
        int nores=arr[0];
        for (int i=1;i<n;i++){
            nores=nores^arr[i];
        }
        int index=0;
        int temp=nores;
        while (temp>0){
            if((temp&1)==1) break;
            temp=temp>>1;
            index++;
        }
        int mask=1<<index;

        int firstNo=0;
        for(int i=0;i<n;i++){
            if((arr[i]&mask)!=0){
                firstNo=firstNo^arr[i];
            }
        }
        int secondNo=firstNo^nores;
        System.out.println("First: "+firstNo+" Second: "+secondNo);

    }

    public static void main(String[] args) {
        int[] arr={1,3,5,7,3,2,1,2};
        findUnique(arr,arr.length);
    }

}
