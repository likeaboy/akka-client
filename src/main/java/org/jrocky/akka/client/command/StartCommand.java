package org.jrocky.akka.client.command;

import org.jrocky.akka.client.model.TaskJob;

public class StartCommand extends BaseCommand{

	public StartCommand(TaskJob job) {
		super(job);
	}

}
