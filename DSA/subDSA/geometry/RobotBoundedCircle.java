package geometry;

import java.util.HashMap;

public class RobotBoundedCircle {

	
	//GGLLRR
	public boolean isRobotBounded(String instructions) {
	
		int currentX = 0, currentY = 0;
		int curDirection = 0;
		HashMap<Character, Integer[]> map = new HashMap<Character, Integer[]>();
		map.put('N', new Integer[]{0, 1});
		map.put('S', new Integer[]{0, -1});
		map.put('E', new Integer[]{1, 0});
		map.put('W', new Integer[]{-1, 0});
		char[] directions = {'E', 'N', 'W', 'S'};
		for(int i=0;i<instructions.length();i++) {
			char inst = instructions.charAt(i);
			switch(inst) {
				case 'G':
					currentX += map.get(directions[curDirection])[0];
					currentY += map.get(directions[curDirection])[1];
					break;
				case 'L':
					curDirection = (curDirection + 1)%4;
					break;
				case 'R':
					curDirection = curDirection<1? (((curDirection - 1 )%4) + 4): (curDirection - 1)%4;
					break;
			}
			
		}
		if((currentX==0 && currentY==0) || (curDirection!=0)) {
			return true;
		}
		return false;
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int curDirection = ( - 1)%4;
		System.out.println(curDirection);
	}

}
