/**
 * 
 */
package com.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author edinjos
 *
 */
public class GenerateTrafficModelOCS {

	private static final String xmlHeader = "<?xml version=\"1.0\" ?>";
	private static String modelTemplate = "";
	private static String trafficModelTemplate = "";
	private static String requestTemplate = "";
	private static List<String> msisdns = new ArrayList<String>();

	private static final String ffsHeaderStart = "<FFS xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"schema/config3.xsd\">";
	private static final String ffsHeaderEnd = "</FFS>";
	private static final String ffsModelStart = "<Models>";
	private static final String ffsModelEnd = "</Models>";
	private static final String ffsTrafficModelStart = "<TrafficModel>";
	private static final String ffsTrafficModelEnd = "</TrafficModel>";
	private static final String ffsSlotStart = "<Slot times=\"0\" duration=\"0\" tps=\"0\" activeModels=\"0\">";
	private static final String ffsSlotEnd = "</Slot>";

	static {

		File file1 = new File("Model.xml");
		boolean exists = file1.exists();
		if (!exists) {
			System.out.println("Could not find Model.xml");
			System.exit(0);
		}
		File file2 = new File("TrafficModel.xml");
		exists = file2.exists();
		if (!exists) {
			System.out.println("Could not find TrafficModel.xml");
			System.exit(0);
		}
		File file3 = new File("testAirtimePurchaseSuccessfulltemplate.xml");
		exists = file3.exists();
		if (!exists) {
			System.out
					.println("Could not find testAirtimePurchaseSuccessfulltemplate.xml");
			System.exit(0);
		}

		StringBuffer buff = new StringBuffer();
		try (FileReader reader = new FileReader("Model.xml")) {
			int character;
			while ((character = reader.read()) != -1) {
				buff.append((char) character);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		modelTemplate = buff.toString();

		StringBuffer buff2 = new StringBuffer();
		try (FileReader reader = new FileReader("TrafficModel.xml")) {
			int character;
			while ((character = reader.read()) != -1) {
				buff2.append((char) character);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		trafficModelTemplate = buff2.toString();

		StringBuffer buff3 = new StringBuffer();
		try (FileReader reader = new FileReader(
				"testAirtimePurchaseSuccessfulltemplate.xml")) {
			int character;
			while ((character = reader.read()) != -1) {
				buff3.append((char) character);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		requestTemplate = buff3.toString();

		File file = new File("Senegal_requests");
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String msisdnFile = "msisdns.txt";
		if (args.length > 0) {
			msisdnFile = args[0];
		}

		loadMsisdnsFromFile(msisdnFile);

		StringBuffer buff = new StringBuffer();
		buff.append(xmlHeader);
		buff.append("\n");
		buff.append(ffsHeaderStart);
		buff.append("\n");
		buff.append(getConstantPart());
		buff.append("\n");
		buff.append("\n");
		buff.append(ffsModelStart);
		buff.append("\n");
		for (String msisdn : msisdns) {
			buff.append(getModelPart(msisdn));
		}
		buff.append("\n");
		buff.append(ffsModelEnd);
		buff.append("\n");
		buff.append(ffsTrafficModelStart);
		buff.append("\n");
		buff.append(ffsSlotStart);
		buff.append("\n");
		for (String msisdn : msisdns) {
			buff.append(gettrafficModelPart(msisdn));
			buff.append("\n");
		}
		buff.append(ffsSlotEnd);
		buff.append("\n");
		buff.append(ffsTrafficModelEnd);

		buff.append(ffsHeaderEnd);

		writeConfig(buff.toString());
		for (String msisdn : msisdns) {
			writeRequest(getRequest(msisdn), "Senegal_requests/"
					+ "testAirtimePurchase_" + msisdn + ".xml");
		}
	}

	private static String getConstantPart() {
		StringBuffer buff = new StringBuffer();
		try (FileReader reader = new FileReader("ConstantsPart.xml")) {
			int character;
			while ((character = reader.read()) != -1) {
				buff.append((char) character);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buff.toString();
	}

	private static String getModelPart(String msisdn) {
		String model = new String(modelTemplate);
		model = model.replaceAll("XXTemplateXX", msisdn);
		return model;
	}

	private static String gettrafficModelPart(String msisdn) {
		String model = new String(trafficModelTemplate);
		model = model.replaceAll("XXTemplateXX", msisdn);
		return model;
	}

	private static String getRequest(String msisdn) {
		String model = new String(requestTemplate);
		model = model.replaceAll("XXTemplateXX", msisdn);
		return model;
	}

	private static void writeConfig(String content) {
		try {
			FileWriter writer = new FileWriter("senegal_ocs.xml", true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(content);
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeRequest(String content, String filename) {
		try {
			FileWriter writer = new FileWriter(filename, true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(content);
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadMsisdnsFromFile(String filename) {
		File file4 = new File(filename);
		boolean exists = file4.exists();
		if (exists) {
			StringBuffer buff4 = new StringBuffer();
			try (FileReader reader = new FileReader(filename)) {
				int character;
				while ((character = reader.read()) != -1) {
					buff4.append((char) character);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] temp = buff4.toString().split(";");
			for (String msisdn : temp) {
				msisdns.add(msisdn);
			}
		} else {
			System.out.println("Exiting --- msisdn not loded.");
			System.exit(0);
		}
	}
}
