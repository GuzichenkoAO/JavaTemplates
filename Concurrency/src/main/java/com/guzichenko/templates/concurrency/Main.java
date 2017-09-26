package com.guzichenko.templates.concurrency;

public class Main {
	private static boolean run = true;

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread();

		thread.start();
		while (run) {
			System.out.println("thread1");
			Thread.currentThread().sleep(5000);
		}
	}


}
