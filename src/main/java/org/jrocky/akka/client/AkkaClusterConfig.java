package org.jrocky.akka.client;

/**
 * AKKA 集群配置
 * @author rocky
 *
 */
public class AkkaClusterConfig {
	private String masterIp = "127.0.0.1";
	private int taskDispatcherPort = 51620;
	private int seedPortFirst = 2551;
	private int seedPortSecond = 2552;
	
	private String clusterSystem;
	
	
//	private String CLUSTER_SYSTEM = "ClusterSystem";
	private String AKKA_SCHEMA = "akka.tcp://";
	private String ROUTER_PATH = "/user/frontend";

	public String getMasterIp() {
		return masterIp;
	}

	public void setMasterIp(String masterIp) {
		this.masterIp = masterIp;
	}

	public int getTaskDispatcherPort() {
		return taskDispatcherPort;
	}

	public void setTaskDispatcherPort(int taskDispatcherPort) {
		this.taskDispatcherPort = taskDispatcherPort;
	}

	public int getSeedPortFirst() {
		return seedPortFirst;
	}

	public void setSeedPortFirst(int seedPortFirst) {
		this.seedPortFirst = seedPortFirst;
	}

	public int getSeedPortSecond() {
		return seedPortSecond;
	}

	public void setSeedPortSecond(int seedPortSecond) {
		this.seedPortSecond = seedPortSecond;
	}

	/*public String getCLUSTER_SYSTEM() {
		return CLUSTER_SYSTEM;
	}

	public void setCLUSTER_SYSTEM(String cLUSTER_SYSTEM) {
		CLUSTER_SYSTEM = cLUSTER_SYSTEM;
	}*/

	public String getClusterSystem() {
		return clusterSystem;
	}

	public void setClusterSystem(String clusterSystem) {
		this.clusterSystem = clusterSystem;
	}

	public String getAKKA_SCHEMA() {
		return AKKA_SCHEMA;
	}

	public void setAKKA_SCHEMA(String aKKA_SCHEMA) {
		AKKA_SCHEMA = aKKA_SCHEMA;
	}

	public String getROUTER_PATH() {
		return ROUTER_PATH;
	}

	public void setROUTER_PATH(String rOUTER_PATH) {
		ROUTER_PATH = rOUTER_PATH;
	}

	public String buildRemoteUri() {
		// "akka.tcp://ClusterSystem@127.0.0.1:51620/user/frontend"
		return AKKA_SCHEMA + clusterSystem + "@" + masterIp + ":"
				+ taskDispatcherPort + ROUTER_PATH;
	}

}
