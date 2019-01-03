/**
 * 
 */
package ocp.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author edinjos
 *
 */
public class TestIO {

	private static String testHome = "C:\\Users\\edinjos\\Desktop\\backup\\ubuntu_BackUp\\Workspace\\Workspace_CoreJava8\\Java8\\io";
	private static String fileSeparator = java.io.File.separator;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "ramagliod@bbva.com;DANIEL MARCELO;;RAMAGLIO;OPERACIONES Y SINIESTROS;2009-05-07;;SUBGTE OPERAC Y SINIESTROS/SE;;;;;1967-02-12;;;CAPITAL FEDERAL;;ARGENTINA;ramagliod@bbva.com;BBVA CONSOLIDAR SEGUROS S.A.;DESARROLLO DE NEGOCIO;SEGUROS ARGENTINA;OPERACIONES Y SINIESTROS;;;;;";
		String[] token = s.split(";");
		for (String ss : token)
			System.out.println(ss);

		File f2 = new File("abc.txt");
		System.out.println(f2);
		System.out.println(f2.toPath());
		URI uri = f2.toURI();
		Path p = Paths.get(uri).toAbsolutePath();

		Path path = Paths.get("/user/.././../../../../root", "../kodiacbear.txt");
		System.out.println(path.normalize());

		testSerialization();
		// printSystemProperties();
		File file = new File(testHome);
		deleteDirectoryAndFileContentsFromFile(file);
		// createDirectory("test1");
		// createDirectory("emptyDir");
		// createDirectoryAndFiles("test");
		System.out.println();

		List<ocp.io.A> list = new ArrayList<ocp.io.A>();
		A a = new A();
		Example e = new Example();
		e.tConsatnt = "Changed";
		e.setId(123);
		e.setName("Dinesh");
		e.setSalary((float) 1414.67);
		a.setE(e);
		a.setTime(System.currentTimeMillis());
		list.add(a);

		A a2 = new A();
		Example e2 = new Example();
		e2.setId(987);
		e2.setName("Joshi");
		e2.setSalary((float) 777.67);
		a2.setE(e2);
		a2.setTime(System.currentTimeMillis() + 100);
		list.add(a2);
		list.add(null);
		File f = new File("A.ser");
		createSerializedFile(f, list);
		readSerializedFile(f);

		System.out.println();
		readDirectoryAndFileContents();
		copyAnyFiles(
				new File("C:\\Users\\edinjos\\Desktop\\backup\\ubuntu_BackUp\\Workspace\\Workspace_CoreJava8\\Java8"
						+ fileSeparator + "file" + fileSeparator + "SamplePDF.pdf"),
				new File("C:\\Users\\edinjos\\Desktop\\backup\\ubuntu_BackUp\\Workspace\\Workspace_CoreJava8\\Java8"
						+ fileSeparator + "file" + fileSeparator + "copySamplePDF.pdf"));
		copyTextFiles(
				new File("C:\\Users\\edinjos\\Desktop\\backup\\ubuntu_BackUp\\Workspace\\Workspace_CoreJava8\\Java8"
						+ fileSeparator + "file" + fileSeparator + "abc.txt"),
				new File("C:\\Users\\edinjos\\Desktop\\backup\\ubuntu_BackUp\\Workspace\\Workspace_CoreJava8\\Java8"
						+ fileSeparator + "file" + fileSeparator + "copyabc.txt"));

		copyAnyFileUsingBuffer(
				new File("C:\\Users\\edinjos\\Desktop\\backup\\ubuntu_BackUp\\Workspace\\Workspace_CoreJava8\\Java8"
						+ fileSeparator + "file" + fileSeparator + "lwam-1.1.3.0.zip"),
				new File("C:\\Users\\edinjos\\Desktop\\backup\\ubuntu_BackUp\\Workspace\\Workspace_CoreJava8\\Java8"
						+ fileSeparator + "file" + fileSeparator + "copylwam-1.1.3.0.zip"));
		copyTextFilesUsingBuffer(
				new File("C:\\Users\\edinjos\\Desktop\\backup\\ubuntu_BackUp\\Workspace\\Workspace_CoreJava8\\Java8"
						+ fileSeparator + "file" + fileSeparator + "Answer.java"),
				new File("C:\\Users\\edinjos\\Desktop\\backup\\ubuntu_BackUp\\Workspace\\Workspace_CoreJava8\\Java8"
						+ fileSeparator + "file" + fileSeparator + "CopyAnswer.java"));

		testPrintStream();
		testPrintWriter();
		// testConsole();
	}

	public static void printSystemProperties() {
		Properties properties = System.getProperties();
		properties.forEach(
				(Object propertyName, Object propertyValue) -> System.out.println(propertyName + ":" + propertyValue));
	}

	public static void createDirectory(String filename) {

		System.out.println(fileSeparator);
		File file = (filename == null ? new File(testHome) : new File(testHome + fileSeparator + filename));

		System.out.println("Create Directory :" + file.getAbsolutePath() + " " + file.mkdirs());

		System.out.println("File absolute path:" + file.getAbsolutePath());
		System.out.println("File isdirectory:" + file.isDirectory());
		System.out.println("File isFile:" + file.isFile());
		System.out.println("File length:" + file.length());
		System.out.println("File parent:" + file.getParent());
		System.out.println("File name:" + file.getName());

		System.out.println("File last modified:" + file.lastModified());

		Date d = new Date(file.lastModified());
		System.out.println("File last modified:" + d);
		System.out.println("File exists:" + file.exists());

		if ("test1".equals(filename)) {
			file.renameTo(new File(testHome + fileSeparator + "test"));
		}
		System.out.println("");
	}

	public static void createDirectoryAndFiles(String dir) {

		String absolutePath = testHome + fileSeparator + dir + fileSeparator + "bufferedWriter.txt";
		System.out.println("Creating file " + absolutePath);
		File file = new File(absolutePath);

		// Create File Using Buffered writer. writes character stream to
		// outputstream
		try {
			BufferedWriter buff = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			buff.write("This is writtern using bufferedWriter.");
			buff.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		// Create file using Output Stream writer
		absolutePath = testHome + fileSeparator + "oswriter.txt";
		System.out.println("Creating file " + absolutePath);
		file = new File(absolutePath);
		try (FileOutputStream oswriter = new FileOutputStream(file);) {
			oswriter.write("This is writtern using file output stream.".getBytes());
			oswriter.write("\n".getBytes());
			oswriter.write("Bbyee...".getBytes());
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	public static void readDirectoryAndFileContents() {
		String absolutePath = testHome;
		System.out.println("Reading " + absolutePath);
		readDirectoryAndFileContentsFromFile(new File(absolutePath));
	}

	public static void readDirectoryAndFileContentsFromFile(File file) {

		if (file.exists()) {
			if (file.isFile()) {
				System.out.println("File :" + file.getName());
				readContentOfFilesContainChar(file);
			} else if (file.isDirectory()) {
				System.out.println("Directory :" + file.getName());
				for (File tmpFile : file.listFiles()) {
					readDirectoryAndFileContentsFromFile(tmpFile);
				}
			}
		}
	}

	public static void readContentOfFiles(File file) {

		try (FileInputStream in = new FileInputStream(file);) {

			System.out.print((char) in.read());
			in.mark(3);
			if (in.markSupported()) {
				System.out.print((char) in.read());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	public static void readContentOfFilesContainChar(File file) {

		try (FileReader reader = new FileReader(file);) {
			System.out.println("******** markSupported : " + reader.markSupported());
			int lengthRead = 0;
			char[] data = new char[1024];

			while ((lengthRead = reader.read(data)) > 0) {
				System.out.print(data);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	public static void deleteDirectoryAndFileContentsFromFile(File file) {

		if (file.exists()) {
			if (file.isFile()) {
				System.out.println("Deleting File :" + file.getName());
				file.delete();
			} else if (file.isDirectory()) {
				System.out.println("Directory :" + file.getName());
				for (File tmpFile : file.listFiles()) {
					deleteDirectoryAndFileContentsFromFile(tmpFile);
				}
				System.out.println("Deleting Directory :" + file.getName());
				file.delete();
			}
		}
	}

	public static void copyAnyFiles(File source, File destination) {
		try {
			FileInputStream fis = new FileInputStream(source);
			FileOutputStream fos = new FileOutputStream(destination);
			for (int i = fis.read(); i != -1; i = fis.read()) {
				fos.write(i);
			}
			fis.close();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void copyTextFiles(File source, File destination) {

		try (FileReader freader = new FileReader(source); FileWriter fwriter = new FileWriter(destination);) {
			for (int b = freader.read(); b != -1; b = freader.read()) {
				fwriter.write(b);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void copyAnyFileUsingBuffer(File source, File destination) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {

			fis = new FileInputStream(source);
			fos = new FileOutputStream(destination);
			bis = new BufferedInputStream(fis, 1_024);
			bos = new BufferedOutputStream(fos, 1_024);

			byte[] b = new byte[1_048_576];
			int bytesRead = 0;
			System.out.println("mark supported.." + bis.markSupported());
			if (bis.markSupported()) {
				bis.mark(1024);
			}
			while ((bytesRead = bis.read(b)) > 0) {
				bos.write(b, 0, bytesRead);
				bos.flush();

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != fis)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (null != fos)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	public static void copyTextFilesUsingBuffer(File source, File destination) {
		FileReader fR = null;
		FileWriter fW = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {

			fR = new FileReader(source);
			fW = new FileWriter(destination);
			br = new BufferedReader(fR, 1_024);
			bw = new BufferedWriter(fW, 1_024);
			System.out.println("mark supported.." + br.markSupported() + " " + source);
			if (br.markSupported()) {
				br.mark(1024);
			}
			System.out.println(" " + destination);
			String line = null;
			for (line = br.readLine(); line != null; line = br.readLine()) {
				bw.write(line);
				bw.write("\n");
				bw.write(line);
				bw.flush();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			try {

				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void createSerializedFile(File file, List<A> list) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
			for (A a : list) {
				oos.writeObject(a);
				System.out.println("Write Object[ " + a + "]");
			}
			oos.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void readSerializedFile(File file) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {
			int i = 0;
			do {

				A a = (A) ois.readObject();
				System.out.println("Read Object[" + a);
				i++;
			} while (i < 4);

			System.out.println("*************");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testPrintWriter() {
		try {
			PrintWriter pw = new PrintWriter(new File("printwriter.log"));
			pw.print("Test PrintStream Logging");
			pw.write(String.valueOf(5));
			pw.println();
			pw.println(100);
			pw.format("It may rain 23.4567 cm");
			pw.println();
			pw.format("It may rain %,6.2f", 124.7453);
			pw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testPrintStream() {
		try (PrintStream ps = new PrintStream("printStream.log");) {
			ps.print("Test PrintStream Logging");
			ps.write(2);
			ps.println();
			ps.print(100);
			ps.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testConsole() {
		Console console = System.console();

		if (null != console) {

			String userInput = console.readLine();

			console.writer().println(userInput);
			System.out.println("You have eneterd : " + userInput);

			char[] pass = console.readPassword("Enter your password");
			console.format("Enter your password again");
			console.flush();
			char[] verify = console.readPassword();
			Arrays.equals(pass, verify);

		}
	}

	public static void testSerialization() {
		Zebra z = new Zebra();
		System.out.println(z);
		try (ObjectOutputStream objStream = new ObjectOutputStream(new FileOutputStream("abc.ser"));) {
			objStream.writeObject(z);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();

		try (ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream("abc.ser"))) {
			Zebra zs = (Zebra) objInputStream.readObject();
			System.out.println(zs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testSample(InputStream in, OutputStream out) throws IOException {
		final byte[] buffer = new byte[100];
		int lengthRead;

		while ((lengthRead = in.read(buffer)) > 0) {
			out.flush();
			out.write(buffer, 0, lengthRead);
			out.flush();
		}

	}
}

class Zebra implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final long serialUID = 1L;
	private transient String name = "George";
	private static String birthPlace = "Africa";
	private transient Integer age;
	private java.util.List<String> friends = new java.util.ArrayList<>();
	private Object tail;
	private java.util.List<A> a;
	private P p = new P();
	{
		age = 10;
		friends.add("Sample");
		A a1 = new A();
		Example e = new Example();
		e.setId(1);
		e.setName("Dinesh");
		a1.setE(e);
		a = new ArrayList<>();
		a.add(a1);

	}

	public Zebra() {
		this.name = "Sophia";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return serialUID + " name:" + name + " birthPlace:" + birthPlace + " age:" + age + " friends:" + friends
				+ " tail:" + tail + " P:" + p + " A:" + a;
	}

	@Override
	public Zebra clone() {
		try {
			return (Zebra) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}

class P implements Serializable {

}