package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CallofWar {

	static long minBullets(Enemy[] enemies, int N) {
		
//		Enemy[] enemiesInOrder = enemies.clone();
//		
////		System.out.println(Arrays.toString(enemiesInOrder));
//		
//		Arrays.sort(enemies, new Comparator<Enemy>() {
//
//			@Override
//			public int compare(Enemy a, Enemy b) {
//				float ratioA = (float)a.damage/a.health;
//				float ratioB = (float)b.damage/b.health;
//				
//				return (int)Math.ceil(ratioB-ratioA);
//			}
//		});
		
//		System.out.println(Arrays.toString(enemies));
		
		int minDiff =Integer.MAX_VALUE ; //store resultant health after damage from previous enemy (Own's Health - Damage from previous enemy) 
		int indexToStart = -1; //Starting point of shooting
		int sum = 0; //No. of bullets
		for(int i=0;i<N;i++) {
			
			//indirectDamage is health after damage
			enemies[i].indirectDamage = (enemies[i].health - enemies[(N+i-1)%N].damage <=0)?0:(enemies[i].health - enemies[(N+i-1)%N].damage);
			
			//Adding bullets to for remaining health of enemy after damage
			sum += enemies[i].indirectDamage;
			
			//keep track of starting point to shoot which has minimum difference of (health-indirectDamage)
			if((enemies[i].health - enemies[i].indirectDamage) < minDiff) {
				indexToStart =  i;
				minDiff = (int)(enemies[i].health - enemies[i].indirectDamage);
			}
			
		}
		sum += minDiff;
		
//		int iterations = N-1;
//		long sum = enemies[indexToStart].health;
//		indexToStart =  (indexToStart+1)%N;
//		while(iterations>0) {
//			
//			sum += enemies[indexToStart].indirectDamage;
//			indexToStart =  (indexToStart+1)%N;
//			
//			iterations--;
//		}
		
		
//		
//		
//		long bullets = 0;
//		for(int i=0;i<N;i++) {
//			
//			if(enemies[i].isAlive) {
//				bullets += enemies[i].health;
//				enemies[i].isAlive = false;
//				recursivelyUpdate(enemies[i], enemiesInOrder, N);
//			}
//			
//			
//		}
		
		
		return sum;
		
	}
	
	private static void recursivelyUpdate(Enemy attackedEnemy, Enemy[] enemiesInOrder, int N) {
		
		int nextId = (attackedEnemy.id +1)%N;
		if(!enemiesInOrder[nextId].isAlive)
		{
			return;
		}
	
		long nextHealth = enemiesInOrder[nextId].health - attackedEnemy.damage;
		enemiesInOrder[nextId].health = nextHealth>0?nextHealth:0;
		if(nextHealth<=0)
		{
			enemiesInOrder[nextId].isAlive = false;
			recursivelyUpdate(enemiesInOrder[nextId], enemiesInOrder, N);
		}
		
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			
			int N = sc.nextInt();
			Enemy[] enemies = new Enemy[N];
			for(int i=0;i<N;i++){
				
				enemies[i] = new Enemy(i, sc.nextLong(), sc.nextLong());
				
			}
			System.out.println(minBullets(enemies, N));
			
		}

	}

}

class Enemy{
	
	long health, damage;
	int id;
	long indirectDamage;
	boolean isAlive;
	
	public Enemy(int id, long health, long damage) {
		this.id = id;
		this.health = health;
		this.damage = damage;
		this.isAlive = true;
		this.indirectDamage = 0;
	}
	
	public String toString() {
		return "Id: "+this.id+" health: "+this.health + ", damage: "+this.damage;
	}
	
}
