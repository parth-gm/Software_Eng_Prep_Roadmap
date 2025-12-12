package leetcode;

public class TrappingRainWater {


    static int findLeftMax(int[] height, int currentIndex){
        int max=Integer.MIN_VALUE;
        for(int i=currentIndex;i>=0;i--){
            if(height[i]>max){
                max=height[i];
            }
        }
        return max;
    }

    static int findRightMax(int[] height, int currentIndex){
        int max=Integer.MIN_VALUE;
        for(int i=currentIndex;i<height.length;i++){
            if(height[i]>max){
                max=height[i];
            }
        }
        return max;
    }

    static  int[] calculateLeftMax(int[] height){
        int[] leftMaxArr=new int[height.length];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<height.length;i++){
            if(height[i]>max){
                max=height[i];
            }
            leftMaxArr[i]=max;
        }

        return leftMaxArr;
    }


    static  int[] calculateRightMax(int[] height){
        int[] rightMaxArr=new int[height.length];

        int max=Integer.MIN_VALUE;
        for(int i=height.length-1;i>=0;i--){
            if(height[i]>max){
                max=height[i];
            }
            rightMaxArr[i]=max;
        }

        return rightMaxArr;
    }

    public static int trap(int[] height) {


        int[] leftMaxArr=calculateLeftMax(height);
        int[] rightMaxArr=calculateRightMax(height);


        int totalrain=0;

        for(int i=1;i<height.length-1;i++){
            int leftMax=leftMaxArr[i];
            int rightMax=rightMaxArr[i];
            int minOfBoth=Math.min(leftMax,rightMax);

            totalrain=totalrain+(minOfBoth-height[i]);

        }
        return totalrain;
    }

    public static int trapAdvSol(int[] height) {
    	
    	if(height.length<3)
    		return 0;
    	int i=0,j=height.length-1;
    	
    	int leftMax=Integer.MIN_VALUE,rightMax=Integer.MIN_VALUE;
    	int totalrain=0;
    	while(i<j) {
    		
    		
    		if(height[i]<height[j]) {
    			if(height[i]>=leftMax) leftMax=height[i];
    			else totalrain=totalrain+(leftMax-height[i]);
    			i++;
    		}
    		else {
    			if(height[j]>=rightMax) rightMax=height[j];
    			else totalrain=totalrain+(rightMax-height[j]);
    			j--;
    		}
    	}
    	return totalrain;
    	
    	
    }
    
    
    public static void main(String[] args) {
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapAdvSol(arr));
    }

}
