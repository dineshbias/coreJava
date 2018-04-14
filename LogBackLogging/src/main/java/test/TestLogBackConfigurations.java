/**
 * 
 */
package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import chapters.configuration.Foo;

public class TestLogBackConfigurations {

	final static Logger logger = LoggerFactory
			.getLogger(TestLogBackConfigurations.class);
	public static void main(String[] args) {
		logger.info("Entering application.");
		Foo foo = new Foo();
		foo.doIt();
		logger.info("Exiting application.");
	}
}
