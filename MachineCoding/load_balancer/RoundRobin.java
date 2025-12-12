package load_balancer;

import java.util.ArrayList;
import java.util.List;

public class RoundRobin implements LoadBalancingStrategy {

	private List<Server> servers;
	int currentAssignedServerIdx;
	
	
	public RoundRobin() {
		currentAssignedServerIdx = 0;
		this.servers = new ArrayList<Server>();
	}

	@Override
	public Server getServerForRequest(Request req) {
		int currentServerIdx = currentAssignedServerIdx;
		currentAssignedServerIdx = (currentAssignedServerIdx+1)%servers.size();
		return servers.get(currentServerIdx);
	}

	@Override
	public void removeServer(Server server) {
		this.servers.remove(server);
		
	}

	@Override
	public void addServer(Server server) {
		this.servers.add(server);
		
	}

	
	
}
