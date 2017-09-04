package org.jrocky.akka.client.model;

import java.io.Serializable;
import org.jrocky.akka.client.model.Response;

/**
 * 任務
 * @author rocky
 *
 */
public class TaskJob implements Serializable{
	
	private static final long serialVersionUID = 4710032761217853520L;
	/**
	 * 服务注册标识
	 */
	public static final String BACKEND_REGISTRATION = "BackendRegistration";
	
	private Response response = Response.JOB_SUCCESS;

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public TaskJob(String taskId,int taskType){
		this.taskId = taskId;
		this.taskType = taskType;
	}
	
	/**
	 * 任务ID
	 */
	private String taskId;
	/**
	 * 任务类型
	 */
	private int taskType;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	public int getTaskType() {
		return taskType;
	}

	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}
}
