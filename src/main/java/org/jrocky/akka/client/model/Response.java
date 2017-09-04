package org.jrocky.akka.client.model;

public enum Response {
	JOB_SUCCESS(200,"job success"),
	SERVICE_UNAVAILABLE(500,"service unavailable"),
	JOB_ERROR(501,"do job error,more detail see log"),
	TIME_OUT(502,"time out");
	public final int code;
	public final String text;
	private Response(int code,String text){
		this.code = code;
		this.text = text;
	}
}
