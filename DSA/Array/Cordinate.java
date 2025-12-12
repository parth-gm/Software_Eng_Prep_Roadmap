package leetcode;

public class Cordinate {
    int x,y;
    double distFromOrigin;

    public Cordinate(int x, int y) {
        this.x = x;
        this.y = y;
        distFromOrigin= Math.sqrt(x*x+y*y);
    }
}
