package com.tyss.log4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Demo {

	static Logger log=LogManager.getLogger("dimple");
	public static void main(String[] args) {
		System.out.println("----------I am ready-------------");
		log.trace("I am trace method");
		log.debug("I am debug method");
		log.info("I am info method");
		log.warn("I am warn method");
		log.error("I am error method");
		log.fatal("I am fatal method");
	}
}
