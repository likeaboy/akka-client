package org.jrocky.akka.client;

import java.util.concurrent.TimeUnit;

import org.jrocky.akka.client.command.BaseCommand;
import org.jrocky.akka.client.model.Response;

import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.pattern.Patterns;
import akka.util.Timeout;

/**
 * 任务发送器
 * 
 * @author rocky
 *
 */
public class TaskSender extends AbstractActor {
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	Timeout timeout = new Timeout(Duration.create(5, TimeUnit.SECONDS));
	ActorRef dispatcher;
	private AkkaClusterConfig config;

	@Override
	public Receive createReceive() {
		return receiveBuilder().match(BaseCommand.class, command -> {
			log.info("taskId=" + command.getJob().getTaskId());
			Future<Object> future = Patterns.ask(dispatcher, command, timeout);
			JobResult result = new JobResult(0,"");
			try{
				result = (JobResult) Await.result(future, timeout.duration());
			}catch(Exception e){
				command.getJob().setResponse(Response.TIME_OUT);
			}
			
			log.info("Message received from Server -> {}", result.getText());
			synchronized (command.getJob()) {
				//notify
				command.getJob().notify();
			}
		}).build();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void preStart() {
//		AkkaClusterConfig config = ContextUtils.getBean(AkkaClusterConfig.class, "clusterConfig");
		config = new AkkaClusterConfig();
		// Get a reference to the remote actor
		dispatcher = getContext().actorFor(config.buildRemoteUri());
	}
}
