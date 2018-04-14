/**
 * 
 */
package chapters.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Foo {
	
	String markerText = "SAMPLE";
	static final Logger logger = LoggerFactory.getLogger(Foo.class);
	public void doIt() {
		logger.debug("Did it again--!");
		logger.info("Did it again!");
	}
}
