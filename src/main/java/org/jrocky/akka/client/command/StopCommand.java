package org.jrocky.akka.client.command;

import org.jrocky.akka.client.model.TaskJob;

public class StopCommand extends BaseCommand{

	public StopCommand(TaskJob job) {
		super(job);
	}

}
