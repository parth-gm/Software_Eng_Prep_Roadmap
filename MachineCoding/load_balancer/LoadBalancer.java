package load_balancer;


public class LoadBalancer {

	//Servers information should be present here
	String loadBId;
	LoadBalancingStrategy lstrategy;
	
	public LoadBalancer(String lId, LoadBalancingStrategy lstrategy) {
		this.lstrategy = lstrategy;

	}
	
	public Server getAssignedServer(Request req) {
		return lstrategy.getServerForRequest(req);
	}

	public String getLoadBId() {
		return loadBId;
	}

	public void setLoadBId(String loadBId) {
		this.loadBId = loadBId;
	}

	public LoadBalancingStrategy getLstrategy() {
		return lstrategy;
	}

	public void setLstrategy(LoadBalancingStrategy lstrategy) {
		this.lstrategy = lstrategy;
	}

	public void addServer(Server server) {
		this.lstrategy.addServer(server);
	}
	
	public void removeServer(Server server) {
		this.lstrategy.removeServer(server);
	}
	
	
	
	
	
	
	
}
