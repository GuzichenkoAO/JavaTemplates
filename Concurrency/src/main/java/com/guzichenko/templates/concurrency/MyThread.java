package com.guzichenko.templates.concurrency;

import org.apache.log4j.Logger;

/**
 * @author - Guzichenko Artem.
 */
public class MyThread extends Thread {
	private static final Logger LOGGER = Logger.getLogger(MyThread.class);

	private int rabbits;

	public MyThread(int rabbits) {
		this.rabbits = rabbits;
	}

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			LOGGER.info(getEmptySpaces(rabbits) + rabbits);
		}
	}

	private String getEmptySpaces(int i) {
		String result = "";
		for (int j = 0; j < i; j++) {
			result = result.concat(" ");
		}
		return result;
	}
}
