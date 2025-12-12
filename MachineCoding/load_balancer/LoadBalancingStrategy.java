package load_balancer;


public interface LoadBalancingStrategy {

	Server getServerForRequest(Request req);
	void addServer(Server server);
	void removeServer(Server server);
	
}
