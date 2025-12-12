package leetcode;

import java.util.*;

public class  KClosePoint {


    public int[][] kClosestVfinal(int[][] points, int K) {

        PriorityQueue<int[]> pqueue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t0, int[] t1) {
                return calculateDistance(t1)-calculateDistance(t0);
            }
        });

        for(int i=0;i<K;i++){
            pqueue.add(points[i]);
        }

        for(int j=K;j<points.length;j++){
            if(calculateDistance(points[j])<calculateDistance(pqueue.peek())){
                pqueue.poll();
                pqueue.add(points[j]);
            }
        }

        int[][] kpoints=new int[K][2];

//        int i=0;
//        while(K-->0){
//            kpoints[i]=pqueue.poll();
//        }

        return pqueue.toArray(kpoints);
    }


    private int calculateDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] kClosestv2(int[][] points, int K) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> calculateDistance(a) - calculateDistance(b));

        for(int[] point : points)
            minHeap.offer(point);

        int[][] kClosestPoints = new int[K][2];
        int i = 0;
        while(K-- != 0)
            kClosestPoints[i++] = minHeap.poll();

        return kClosestPoints;
    }

    public static int[][] kClosest(int[][] points, int K) {
        int[][] kpoints=new int[K][2];
        ArrayList<Cordinate> acc=new ArrayList<>();
        for(int i=0;i<points.length;i++){
            acc.add(new Cordinate(points[i][0],points[i][1]));
        }

        Collections.sort(acc, new Comparator<Cordinate>() {
            @Override
            public int compare(Cordinate t0, Cordinate t1) {
                if(t0.distFromOrigin>t1.distFromOrigin){
                    return 1;
                }
                return -1;
            }
        });

        for(int i=0;i<K;i++){
            points[i][0]=acc.get(i).x;
            points[i][1]=acc.get(i).y;
        }

        return points;
    }

    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int K = 1;

        points= kClosest(points,K);

//        for(int i=0;i<K;i++){
//            System.out.println(points[i][0]+" , "+points[i][1]);
//        }

        KClosePoint kp=new KClosePoint();

        points= kp.kClosestVfinal(points,K);

        for(int i=0;i<K;i++){
            System.out.println(points[i][0]+" , "+points[i][1]);
        }

    }

}
