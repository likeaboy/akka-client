package org.jrocky.akka.client;

import org.jrocky.akka.client.command.BaseCommand;
import org.jrocky.akka.client.command.ICommandProcessHandler;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.ConfigFactory;
/**
 * Akka Client Actor System 
 * @author rocky
 *
 */
public class AkkaClientSystem implements ICommandProcessHandler{
	//初始化本地角色系统
	private ActorSystem _system = ActorSystem.create(
			AkkaClientConfig.CLIENT_SYSTEM, ConfigFactory.load().getConfig(AkkaClientConfig.CLIENT_SYSTEM_CONFIG));

	@Override
	public void doProcess(BaseCommand commd) {
		ActorRef taskSender = _system.actorOf(Props.create(TaskSender.class));
		taskSender.tell(commd, ActorRef.noSender());
	}

	public ActorSystem getContext(){
		return _system;
	}
}
