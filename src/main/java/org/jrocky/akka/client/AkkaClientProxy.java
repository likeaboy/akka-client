package org.jrocky.akka.client;

import org.jrocky.akka.client.command.BaseCommand;
import org.jrocky.akka.client.command.ICommandProcessHandler;

import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * AKKA 客户端代理
 * @author rocky
 *
 */
public class AkkaClientProxy implements ICommandProcessHandler{

	private volatile static AkkaClientProxy instance = new AkkaClientProxy();
	private AkkaClientSystem delegate = new AkkaClientSystem();
	LoggingAdapter log = Logging.getLogger(delegate.getContext(), this);
	
	private AkkaClientProxy() {
	}

	public static AkkaClientProxy getInstance() {
		return instance;
	}

	@Override
	public void doProcess(BaseCommand command) {
		log.info("AkkaClientProxy doProcess before [taskId="+command.getJob().getTaskId()+"]");
		delegate.doProcess(command);
	}

}
