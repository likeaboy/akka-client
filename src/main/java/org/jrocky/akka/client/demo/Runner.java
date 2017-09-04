package org.jrocky.akka.client.demo;

import org.jrocky.akka.client.AkkaClientProxy;
import org.jrocky.akka.client.command.StartCommand;
import org.jrocky.akka.client.model.Response;
import org.jrocky.akka.client.model.TaskJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
	
	private final static Logger logger = LoggerFactory.getLogger(Runner.class);
	
	public static void main(String[] args) {
		TaskJob job = new TaskJob("8910232",1);
    	AkkaClientProxy.getInstance().doProcess(new StartCommand(job));
    	
    	try {
    		synchronized (job) {
    			job.wait();
			}
		} catch (InterruptedException e) {
			logger.error("start job error", e);
		}
    	
    	if(job.getResponse() == Response.JOB_SUCCESS){
    		logger.info("start success!");
    	}else{
    		logger.info("start error!");
    	}
	}
}
