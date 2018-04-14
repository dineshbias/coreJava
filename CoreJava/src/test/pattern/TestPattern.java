/**
 * 
 */
package test.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author edinjos
 *
 */
public class TestPattern {
	private final static String LIST_PREFIX = "list:";
	
	private static class ListFormat {
		private String header = "";
		private String footer = "";
		private String lineFormat = "";

		private boolean bullets;
	}
	
	/**
	 * 
	 */
	public TestPattern() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parseListFormat("list:\"(header Vouchers available and not redeemed)\"  Ref: $SenegalViewVoucherText");
	}
	
	
	private static ListFormat parseListFormat(final String text) {
		final ListFormat result = new ListFormat();

		final Pattern pattern = Pattern
				.compile(TestPattern.LIST_PREFIX
						+ "(?<noBullets>no_bullets:)?(\"(?<header>[^\"]*)\")?(?<line>.*?)(\"(?<footer>[^\"]*)\")?");

		final Matcher matcher = pattern.matcher(text);
		if (matcher.matches()) {
			result.header = matcher.group("header") == null ? "" : matcher
					.group("header");
			result.lineFormat = matcher.group("line") == null ? "" : matcher
					.group("line").trim();
			result.footer = matcher.group("footer") == null ? "" : matcher
					.group("footer");
			result.bullets = matcher.group("noBullets") == null ? true
					: matcher.group("noBullets").isEmpty();
		}

		return result;
	}
	
}
