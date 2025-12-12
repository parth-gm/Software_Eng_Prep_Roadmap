package elevator;

public class Request {

	int sourcefloorId;
	Direction direction;
	int destfloorId;
	
	public Request(int sourcefloorId, int destFloorId, Direction dir) {
		this.sourcefloorId = sourcefloorId;
		this.destfloorId = destFloorId;
		this.direction = dir;
	}
	
	
}
