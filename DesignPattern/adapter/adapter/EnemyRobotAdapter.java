package adapter;

public class EnemyRobotAdapter implements EnemyAttacker {
	EnemyRobot enemyRobot;
	public EnemyRobotAdapter(EnemyRobot robot) {
		this.enemyRobot = new EnemyRobot();
	}
	
	
	@Override
	public void fireWeapon() {
		
		enemyRobot.smashWithHands();
	}

	@Override
	public void driveForward() {
		// TODO Auto-generated method stub
		enemyRobot.walkForward();
	}

	@Override
	public void assignDriver(String driverName) {
		// TODO Auto-generated method stub
		enemyRobot.reactToHuman(driverName);
	}
	
	
	

}
