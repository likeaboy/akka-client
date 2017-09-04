package org.jrocky.akka.client.command;

import java.io.Serializable;

import org.jrocky.akka.client.model.TaskJob;

public abstract class BaseCommand implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8196001352767372303L;
	private TaskJob job;
	
	public BaseCommand(TaskJob job){
		this.job = job;
	}

	public TaskJob getJob() {
		return job;
	}

	public void setJob(TaskJob job) {
		this.job = job;
	}
	
}
