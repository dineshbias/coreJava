/**
 * 
 */
package dates;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author edinjos
 *
 */
public class TestDatesAndTimes {

	public static void testResourceBundleSample() {
		Locale fr = new Locale("de");
		Locale.setDefault(new Locale("en", "US"));
		
		ResourceBundle b = ResourceBundle.getBundle("Dolphins", new Locale(
				"xy", "xy"));
		System.out.println(b.getString("name"));
		System.out.println(b.getString("adult"));
		System.out.println(b.getString("age"));

		Stream<LocalDate> s = Stream.of(LocalDate.now());
		Function<LocalDate,LocalDate> u = l -> l;
		System.out.println(s.filter(l -> l != null).map(u));

		throw new Error();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testResourceBundleSample();

		LocalDate d = LocalDate.of(2015, 5, 1);
		Period p = Period.of(1, 2, 3);
		System.out.println(d);
		System.out.println(p);
		d = d.minus(p);
		System.out.println(d);

		DateTimeFormatter df = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(df.format(d));

		testDateTimeWithDurations();

		// testFormatNumberCurrencyPercentage();
		// testResourceBundle();
		// testJavaClassResourceBundle();
		// testParseLocalDateAndTime();
	}

	public static void testDateAndTime() {
		System.out.println("TestDateAndTime");

		// Creating Dates and Time
		// 1. Current Date and Time
		LocalDate localDate = LocalDate.now();
		System.out.println("Local Date :" + localDate);

		LocalTime localTime = LocalTime.now();
		System.out.println("Local Time :" + localTime);

		LocalDateTime localDateAndTime = LocalDateTime.of(localDate, localTime);
		System.out.println("LocalDateTime : " + localDateAndTime);

		System.out.println("LocalDateTime : " + LocalDateTime.now());

		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("ZonedDateTime : " + zonedDateTime);

		System.out.println();
		// 2. Specific date and Times
		localDate = LocalDate.of(2012, Month.FEBRUARY, 29);
		System.out.println("Local Date :" + localDate);

		localTime = LocalTime.of(23, 55);
		System.out.println("Local Time :" + localTime);

		localDateAndTime = LocalDateTime.of(2012, Month.FEBRUARY, 29, 23, 55,
				59, 600);

		System.out.println("LocalDateTime : " + localDateAndTime);

		// TimeZoned Date and Time
		System.out.println("");
		ZoneId.getAvailableZoneIds().stream()
				.filter(k -> k.toUpperCase().contains("US/"))
				.forEach(System.out::println);
		System.out.println("");
		System.out.println("Default ZoneId : " + ZoneId.systemDefault());

		ZoneId zoneId = ZoneId.of("US/Alaska");
		zonedDateTime = ZonedDateTime.of(localDateAndTime,
				ZoneId.systemDefault());
		System.out.println("ZonedDateTime : " + zonedDateTime);

		zonedDateTime = ZonedDateTime.of(localDateAndTime, zoneId);
		System.out.println("ZonedDateTime : " + zonedDateTime);
	}

	public static void testManipulateDateTime() {
		System.out.println("testManipulateDateTime");
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate: " + localDate);

		System.out.println("localDate plus years: " + localDate.plusYears(10));
		System.out.println("localDate plus months: "
				+ localDate.plusMonths(100));
		System.out.println("localDate plus weeks: " + localDate.plusWeeks(10));
		System.out.println("localDate plus days: " + localDate.plusDays(1));
		System.out.println();
		LocalTime localTime = LocalTime.now();
		System.out.println("localTime: " + localTime);
		System.out.println("localTime plus Hours: " + localTime.plusHours(1));
		System.out.println("localTime plus Minutes: "
				+ localTime.plusMinutes(1));
		System.out.println("localTime plus Seconds: "
				+ localTime.plusSeconds(1));

		System.out.println(localTime.plus(1, ChronoUnit.HALF_DAYS));
		System.out.println("localTime plus NanoSeconds: "
				+ localTime.plusNanos(1));

		System.out.println("localTime ChronoUnit"
				+ localTime.plus(1, ChronoUnit.MICROS));

		System.out.println();

		LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
		System.out.println("localDateTime: " + localDateTime);
		System.out.println("localDateTime plus years: "
				+ localDateTime.plusYears(1));
		System.out.println("localDateTime plus months: "
				+ localDateTime.plusMonths(1));
		System.out.println("localDateTime plus weeks: "
				+ localDateTime.plusWeeks(1));
		System.out.println("localDateTime plus days: "
				+ localDateTime.plusDays(1));
		System.out.println("localDateTime plus Hours: "
				+ localDateTime.plusHours(1));
		System.out.println("localDateTime plus Minutes: "
				+ localDateTime.plusMinutes(1));
		System.out.println("localDateTime plus Seconds: "
				+ localDateTime.plusSeconds(1));
		System.out.println("localDateTime plus NanoSeconds: "
				+ localDateTime.plusNanos(1));

		System.out.println("localDateTime ChronoUnit"
				+ localDateTime.plus(1, ChronoUnit.MICROS));

		// Chaining
		System.out.println();
		System.out.println("localDateTime: " + localDateTime);
		localDateTime.minus(1, ChronoUnit.CENTURIES);
		System.out.println("Chained Operation : "
				+ localDateTime.minusYears(1).minusMonths(1).minusWeeks(1)
						.minusDays(1).minusHours(1).minusMinutes(1)
						.minusSeconds(1).minusNanos(1));
	}

	public static void testDateTimewithPeriods() {
		System.out.println("testDateTimewithPeriods");

		LocalDateTime startLocalDateTime = LocalDateTime.of(2012, 2, 29, 2, 30,
				55, 567);

		LocalDateTime endLocalDateTime = LocalDateTime.now();
		System.out.println("startLocalDateTime :" + startLocalDateTime);
		System.out.println("endLocalDateTime   :" + endLocalDateTime);

		Period period = Period.ofYears(1);
		System.out.println("Period: " + period);
		while (startLocalDateTime.isBefore(endLocalDateTime)) {
			startLocalDateTime = startLocalDateTime.plus(period);
			System.out.println("Years in between : " + startLocalDateTime);
		}

		period = Period.ofMonths(1);
		System.out.println("");
		System.out.println("Period: " + period);
		System.out.println("startLocalDateTime :" + startLocalDateTime);
		System.out.println("endLocalDateTime   :" + endLocalDateTime);
		while (startLocalDateTime.isAfter(endLocalDateTime)) {
			startLocalDateTime = startLocalDateTime.minus(period);
			System.out.println("Months of Year : " + startLocalDateTime);
		}

		period = Period.ofWeeks(1);
		System.out.println("");
		System.out.println("Period: " + period);
		System.out.println("startLocalDateTime :" + startLocalDateTime);
		System.out.println("endLocalDateTime   :" + endLocalDateTime);
		while (startLocalDateTime.isBefore(endLocalDateTime)) {
			startLocalDateTime = startLocalDateTime.plus(period);
			System.out.println("Months of Year : " + startLocalDateTime);
		}

		LocalDate localDate = LocalDate.now();
		period = Period.of(0, 1, 0);
		System.out.println();
		System.out.println("localDate " + localDate);
		System.out.println("localDate " + localDate.plus(period));

		System.out.println("Period: " + period);

		System.out.println();
		localDate = LocalDate.now();
		period = Period.ofYears(1).ofMonths(1).ofWeeks(1).ofDays(1);
		System.out.println("localDate " + localDate);
		System.out.println("localDate " + localDate.plus(period));

	}

	public static void testDateTimeWithDurations() {
		System.out.println("testDateTimeWithDurations");
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("localDateTime :" + localDateTime);

		Duration duration = Duration.ofDays(1);
		System.out.println("localDateTime Days: "
				+ localDateTime.plus(duration));
		duration = Duration.ofHours(1);
		duration = Duration.of(1, ChronoUnit.WEEKS);

		System.out.println("localDateTime Hours: "
				+ localDateTime.plus(duration));
		duration = Duration.ofMinutes(1);
		System.out.println("localDateTime Minutes: "
				+ localDateTime.plus(duration));
		duration = Duration.ofSeconds(1);
		System.out.println("localDateTime Seconds: "
				+ localDateTime.plus(duration));
		duration = Duration.ofMillis(1);
		System.out.println("localDateTime Milliseconds: "
				+ localDateTime.plus(duration));
		duration = Duration.ofNanos(1);
		System.out.println("localDateTime Nanos: "
				+ localDateTime.plus(duration));

		localDateTime = LocalDateTime.now();
		duration = Duration.of(6, ChronoUnit.DAYS);
		System.out.println("localDateTime Days: "
				+ localDateTime.plus(duration));

		LocalDate localDate = LocalDate.now();
		System.out.println("localDate :" + localDate);
		System.out.println("localDate Period:"
				+ localDate.plus(Period.ofDays(1)));
		// System.out.println("localDate Duration:"
		// +localDate.plus(Duration.ofDays(1)));

		LocalTime localTime1 = LocalTime.now();
		LocalTime localTime2 = LocalTime.of(23, 00);
		System.out.println("localTime1 :" + localTime1);
		System.out.println("localTime2 :" + localTime2);
		Duration d = Duration.ofHours(1);
		int counter = 0;
		while (localTime1.isBefore(localTime2)) {
			localTime1 = localTime1.plus(d);
			System.out.println("localTime1 :" + localTime1);
			counter++;
			if (counter > 5)
				break;
		}

		LocalDateTime localDateTime1 = LocalDateTime.now();
		LocalDateTime localDateTime2 = localDateTime1.plusHours(1);
		duration = Duration.ofMinutes(15);

		System.out.println("localDateTime1 :" + localDateTime1);
		System.out.println("localDateTime2 :" + localDateTime2);
		while (localDateTime1.isBefore(localDateTime2)) {
			localDateTime1 = localDateTime1.plus(duration);
			System.out.println("localDateTime1 :" + localDateTime1);
		}
		duration = Duration.ofNanos(1);
		Period p = Period.ofDays(1);
		System.out.println("Duration:" + duration);
		System.out.println("Period:" + p);
	}

	public static void testDateAndTimeWithInstant() {
		Period p = Period.ofWeeks(2);
		System.out.println("Period:" + p);

		// Creating Instant
		// 1. Using now()
		Instant startInstant = Instant.now();
		System.out.println("Instant       :" + startInstant);
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("localDateTime :" + localDateTime);

		Instant endInstant = Instant.now();
		System.out.println("Duration : "
				+ (Duration.between(startInstant, endInstant)).toMillis()
				+ " milliseconds");

		// 2. Using LocalDateTime
		System.out.println();
		localDateTime = LocalDateTime.now();

		ZoneId zoneId = ZoneId.of("US/Alaska");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
		System.out.println("localDateTime : " + localDateTime);
		System.out.println("zonedDateTime : " + zonedDateTime);
		System.out.println("Instant       : " + zonedDateTime.toInstant());

		// 3. Using number of seconds since 1970
		Instant instant = Instant.ofEpochSecond(923456789);
		System.out.println("instant  : " + instant);

		// Instant Operations.
		System.out.println();
		instant = Instant.now();
		System.out.println("instant          : " + instant);
		System.out.println("Instant and Days : "
				+ instant.minus(1, ChronoUnit.DAYS));
		System.out.println("Instant and Hours : "
				+ instant.plus(1, ChronoUnit.HOURS));
		System.out.println("Instant and Seconds : "
				+ instant.plus(10, ChronoUnit.SECONDS));

		System.out.println("Instant and Months : "
				+ instant.plus(10, ChronoUnit.MONTHS));
	}

	public static void testDateAndTimeWithDayLightSaving() {

		// Test changeover in the month of March.
		LocalDateTime localDateTime = LocalDateTime.of(2016, Month.MARCH, 13,
				1, 30, 55);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zone);
		System.out.println("zonedDateTime          : " + zonedDateTime);
		System.out.println("zonedDateTime plus 1 hr: "
				+ zonedDateTime.plus(1, ChronoUnit.HOURS));

		System.out.println();
		// Test Clock reset in the month of November
		localDateTime = LocalDateTime.of(2016, Month.NOVEMBER, 6, 1, 30, 55);

		zonedDateTime = ZonedDateTime.of(localDateTime, zone);
		System.out.println("zonedDateTime          : " + zonedDateTime);
		System.out.println("zonedDateTime plus 1 hr: "
				+ zonedDateTime.plus(1, ChronoUnit.HOURS));
	}

	public static void testDateAndTimeinJava7() {
		System.out
				.println("testDateAndTimeinJava7. Java 7 and previous dates ");
		// Creating Date
		// 1. Current Date and Time
		Date date = new Date();
		System.out.println("Date : " + date);

		SimpleDateFormat dateFormatter = new SimpleDateFormat(
				"E, y-M-d 'at' h:m:s a z");
		System.out.println("Date : " + dateFormatter.format(date));

		dateFormatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println("Format 2:   " + dateFormatter.format(date));

		Calendar cal = Calendar.getInstance();
		System.out.println("Cal : " + cal.getTime());
		cal.set(2012, 1, 29, 26, 55, 59);
		System.out.println("Cal : " + cal.getTime());

		GregorianCalendar gCal = new GregorianCalendar();
		System.out.println("gCal : " + gCal.getTime());
		System.out.println("gCal : " + gCal.getCalendarType() + " "
				+ gCal.toInstant());
	}

	public static void testManipulaDateAndTimeinJava7() {

		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		cal.add(Calendar.HOUR_OF_DAY, 1);
		System.out.println("Adding Hour:" + cal.getTime());
		cal.add(Calendar.HOUR_OF_DAY, -5);
		System.out.println("Subtracting Hour:" + cal.getTime());
		cal.add(Calendar.DATE, 1);
		System.out.println("Adding date:" + cal.getTime());
		cal.add(Calendar.WEEK_OF_MONTH, 1);
		System.out.println("Adding Week:" + cal.getTime());
		cal.add(Calendar.MONTH, 1);
		System.out.println("Adding Month:" + cal.getTime());
		cal.add(Calendar.YEAR, 1);
		System.out.println("Adding Year:" + cal.getTime());

		String s = "Apple";
		String z = s + " Mango";

		System.out.println(s);
		System.out.println(z);

	}

	public static void testInternationalizationAndLocalization() {
		System.out.println("testInternationalizationAndLocalization..");
		// 1. Default Locale
		Locale locale = Locale.getDefault();
		System.out.println("Default locale:" + locale);

		// 2.Existing locales
		System.out.println("Germany locale:" + Locale.GERMANY);

		// 3. Creating own Locale

		Locale hiLocale = new Locale("hi", "IN");
		hiLocale = new Locale("hi");
		System.out.println("Own locale:" + hiLocale);

		// 4. Using Builder.
		Locale usLocale = new Locale.Builder().setRegion("US")
				.setLanguage("en").build();
		System.out.println("Builder locale:" + usLocale);

		System.out.println("Reset Default locale:" + Locale.getDefault());

		System.out.println();
		printPropertiesBasedOnLocalesFromPropertyFileResourceBundle(
				Locale.GERMANY, "Footer");
		System.out.println();
		Properties p = printPropertiesBasedOnLocalesFromPropertyFileResourceBundle(
				usLocale, null);
		System.out.println();
		printPropertiesBasedOnLocalesFromPropertyFileResourceBundle(hiLocale,
				null);
		System.out.println();
		System.out.println(p.getOrDefault("Title", "DefaultMessage"));
		System.out.println(p.getOrDefault("Hello", "TestMessage"));

		System.out.println();
		System.out.println("Default Locale " + Locale.getDefault());
		printPropertiesBasedOnLocalesFromPropertyFileResourceBundle(null, null);

	}

	public static Properties printPropertiesBasedOnLocalesFromPropertyFileResourceBundle(
			Locale locale, String key) {

		System.out.print(locale + " ***");
		ResourceBundle resourceBundle;
		if (null != locale) {
			resourceBundle = ResourceBundle.getBundle("zoo", locale);
		} else {
			resourceBundle = ResourceBundle.getBundle("zoo");
		}
		if (null != key && !key.isEmpty())
			System.out.println(resourceBundle.getLocale() + " " + "name:"
					+ resourceBundle.getBaseBundleName() + " " + key
					+ resourceBundle.getString(key));

		resourceBundle
				.keySet()
				.stream()
				.forEach(
						s -> System.out.println(s + " "
								+ resourceBundle.getString(s)));
		/*
		 * Enumeration<String> keys = resourceBundle.getKeys(); while
		 * (keys.hasMoreElements()) { String element = keys.nextElement();
		 * System.out.println(element + " " +
		 * resourceBundle.getString(element)); }
		 */

		// Converting resource bundle into properties.
		Properties properties = new Properties();
		resourceBundle.keySet().stream().forEach(s -> {
			properties.put(s, resourceBundle.getString(s));
		});
		return properties;

	}

	public static void testResourceBundle() {

		System.out.println("Default Locale :" + Locale.getDefault());
		Locale locale = new Locale("hi", "IN");
		System.out.println("Locale :" + locale);
		ResourceBundle rb = ResourceBundle.getBundle("TAX");
		// Probable resource bundles
		// TAX_hi_IN.java, TAX_hi.java, TAX.java
		// TAX_hi_IN.properties, TAX_hi.properties, TAX.properties
		// TAX_en_US.java, TAX_en.java
		// TAX_en_US.properties, TAX_en.properties
		rb.keySet().stream()
				.forEach(s -> System.out.println(s + " " + rb.getObject(s)));
		System.out.println("**********");
		System.out.println(rb.getString("TAXDefault"));
		System.out.println(rb.getString("TAXY"));
	}

	public static void testJavaClassResourceBundle() {

		System.out.println("Default Locale :" + Locale.getDefault());
		Locale locale = new Locale("hi", "IN");
		System.out.println("Locale :" + locale);
		ResourceBundle rb = ResourceBundle.getBundle("ocp.dates.TAX");
		// Probable resource bundles
		// TAX_hi_IN.java, TAX_hi.java, TAX.java
		// TAX_hi_IN.properties, TAX_hi.properties, TAX.properties
		// TAX_en_US.java, TAX_en.java
		// TAX_en_US.properties, TAX_en.properties
		rb.keySet().stream()
				.forEach(s -> System.out.println(s + " " + rb.getObject(s)));
	}

	public static void testFormatTextOfResourceBundles() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("zoo");
		String s = resourceBundle.getString("Title");
		Object[] sArray = { "Delhi Zoo", "Tiger" };

		String fS = MessageFormat.format(s, sArray);

		System.out.println(fS);
	}

	public static void testFormatNumberCurrencyPercentage() {

		// 1. Format Numbers
		int a = 12345_678_00;
		System.out.println(Locale.getDefault());
		System.out.println("No format int : " + a);
		NumberFormat numberFormat = NumberFormat.getInstance();
		System.out.println("Number Format int : " + numberFormat.format(a));
		numberFormat = NumberFormat.getInstance(Locale.GERMANY);
		System.out.println("GER Number Format int : " + numberFormat.format(a));
		numberFormat = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		System.out.println("FRE Number Format int : " + numberFormat.format(a));

		System.out.println();
		// 2. Format Currency
		float price = (float) 98_76_54_321.5678;
		System.out.println("No format price : " + price);
		numberFormat = NumberFormat.getCurrencyInstance();
		System.out.println("Default CURRency format price : "
				+ numberFormat.format(price));
		numberFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
		System.out.println("GER Number Format price : "
				+ numberFormat.format(price));
		numberFormat = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
		System.out.println("FRE Number Format price : "
				+ numberFormat.format(price));

		System.out.println();
		// 3. Format percentage
		double percent = 0.5;
		System.out.println("No format percent : " + percent);
		numberFormat = NumberFormat.getPercentInstance();
		System.out.println("Default Percentage format percent : "
				+ numberFormat.format(percent));
		numberFormat = NumberFormat.getPercentInstance(Locale.GERMANY);
		System.out.println("GER Percentage Format percent : "
				+ numberFormat.format(percent));
		numberFormat = NumberFormat.getPercentInstance(Locale.CANADA_FRENCH);
		System.out.println("FRE Percentage Format percent : "
				+ numberFormat.format(percent));

	}

	public static void testParseNumberCurrencyPercentage() {

		try {
			// Parsing Numbers
			NumberFormat numberFormat = NumberFormat.getNumberInstance();
			String value = "1234567800";
			System.out.println();
			System.out
					.println("Parsing Integer : " + numberFormat.parse(value));
			value = "1,234,567,800";
			System.out
					.println("Parsing Integer : " + numberFormat.parse(value));
			value = "1.234.567.800";
			numberFormat = NumberFormat.getNumberInstance(Locale.GERMANY);
			System.out
					.println("Parsing Integer : " + numberFormat.parse(value));
			value = "1 234 567 800";
			numberFormat = NumberFormat.getNumberInstance(Locale.CANADA_FRENCH);
			System.out
					.println("Parsing Integer : " + numberFormat.parse(value));

			// Parsing currency
			numberFormat = NumberFormat.getCurrencyInstance();
			System.out.println();
			value = "$987,654,321.57";
			System.out.println("Parsing Currency : "
					+ numberFormat.parse(value));
			value = "987.654.321,57 €";
			numberFormat = NumberFormat.getNumberInstance(Locale.GERMANY);
			System.out.println("Parsing Currency : "
					+ numberFormat.parse(value));
			value = "987 654 321,57 $";
			numberFormat = NumberFormat.getNumberInstance(Locale.CANADA_FRENCH);
			System.out.println("Parsing Currency : "
					+ numberFormat.parse(value));

			// Parsing percentage
			numberFormat = NumberFormat.getPercentInstance();
			System.out.println();
			value = "50%";
			System.out.println("Parsing Percentage : "
					+ numberFormat.parse(value));

			numberFormat = NumberFormat.getNumberInstance(Locale.GERMANY);
			System.out.println("Parsing Percentage : "
					+ numberFormat.parse(value));

			numberFormat = NumberFormat.getNumberInstance(Locale.CANADA_FRENCH);
			System.out.println("Parsing Percentage : "
					+ numberFormat.parse(value));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void testDateTimeFormatter() {
		System.out.println("DateTimeFormatter..");
		LocalDate localDate = LocalDate.now();

		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
		System.out.println("localDate :" + localDate + "  F LocalDate :"
				+ DateTimeFormatter.ISO_DATE.format(localDate));
		System.out.println("localTime :" + localTime + "  F LocalTime :"
				+ DateTimeFormatter.ISO_TIME.format(localTime));
		System.out.println("localDateTime :" + localDateTime
				+ "  F LocalDateTime :"
				+ DateTimeFormatter.ISO_DATE_TIME.format(localDateTime));

		System.out.println("localDate :" + localDate + "  F LocalDate :"
				+ localDate.format(DateTimeFormatter.ISO_DATE));
		System.out.println("localDateTime :" + localDateTime
				+ "  F LocalDateTime :"
				+ localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));

		System.out.println();

		DateTimeFormatter dtfForDate = DateTimeFormatter
				.ofLocalizedDate(FormatStyle.FULL);
		DateTimeFormatter dtfForTime = DateTimeFormatter
				.ofLocalizedTime(FormatStyle.SHORT);
		DateTimeFormatter dtfForDateTime = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(dtfForDate.format(localDate) + "..."
				+ dtfForTime.format(localTime) + "..."
				+ dtfForDateTime.format(localDateTime));

		dtfForDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		dtfForTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		dtfForDateTime = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(dtfForDate.format(localDate) + "..."
				+ dtfForTime.format(localTime) + "..."
				+ dtfForDateTime.format(localDateTime));

		dtfForDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		dtfForTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		dtfForDateTime = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(dtfForDate.format(localDate) + "..."
				+ dtfForTime.format(localTime) + "..."
				+ dtfForDateTime.format(localDateTime));

		dtfForDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		dtfForTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		dtfForDateTime = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(dtfForDate.format(localDate) + "..."
				+ dtfForTime.format(localTime) + "..."
				+ dtfForDateTime.format(localDateTime));

		// Customized Date/Time Formatter
		System.out.println();
		DateTimeFormatter cdtf = DateTimeFormatter
				.ofPattern("G Q dd-MMMM-YYYY, hh:mm:ss:A:n a");
		LocalDate localeDate = LocalDate.of(2016, Month.JANUARY, 1);
		LocalTime time = LocalTime.of(10, 20, 3, 300);
		LocalDateTime localDateTime1 = LocalDateTime.of(localeDate, time);
		System.out.println(cdtf.format(localDateTime1));
		cdtf = DateTimeFormatter.ofPattern("dd-MMM-YYY, hh:mm:ss");
		System.out.println(cdtf.format(localDateTime1));
		cdtf = DateTimeFormatter.ofPattern("dd-MM-YY, hh:mm:ss");
		System.out.println(cdtf.format(localDateTime1));
		cdtf = DateTimeFormatter.ofPattern("d-M-Y, h:m:s");
		System.out.println(cdtf.format(localDateTime1));
	}

	public static void testParseLocalDateAndTime() {
		String strDateTime = "1986-04-08 12:30";
		String strDate = "1986-04-08";
		String strTime = "12:30";

		DateTimeFormatter formatterDate = DateTimeFormatter
				.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter formatterDateTime = DateTimeFormatter
				.ofPattern("yyyy-MM-dd HH:mm");
		LocalDate.parse(strDate, formatterDate);
		LocalTime.parse(strTime, formatterTime);
		LocalDateTime localDateTime = LocalDateTime.parse(strDateTime,
				formatterDateTime);
		
		System.out.println(localDateTime.getYear() + " "
				+ localDateTime.getMonthValue() + " "
				+ localDateTime.getDayOfYear());
	}
}
