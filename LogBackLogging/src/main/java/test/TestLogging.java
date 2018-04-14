/**
 * 
 */
package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;
public class TestLogging {
	public static void main(String[] args) {
	    Logger logger = LoggerFactory.getLogger(TestLogging.class);
	    logger.info("Hello world.");
	}
}

