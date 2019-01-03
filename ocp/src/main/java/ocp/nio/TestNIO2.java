package ocp.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.ProviderNotFoundException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Duration;
import java.time.Period;
import java.util.stream.Stream;

public class TestNIO2 {

	static class Walk implements AutoCloseable {
		@Override
		public void close() {
			System.out.println("Inside close");
			throw new RuntimeException("snow");
		}
	}

	public static void test() {
		try (Walk walk1 = new Walk(); Walk walk2 = new Walk();) {
		} catch (Exception e) {
			System.out.println(e.getMessage() + " " + e.getSuppressed().length);
		}
	}

	public static void main(String... args) throws IOException {
		Path path1 = Paths.get(".").toAbsolutePath();

		testPathMethods();

		int[] z = { 100 };
		System.out.println(z[0]);
		z[0]++;
		System.out.println(z[0]);

		// test();
		Duration d = Duration.ofDays(1);
		System.out.println(d);
		Period p = Period.ofDays(1);
		System.out.println(p);

		Path path = Paths.get(".").toAbsolutePath(); // h1

		Files.isSameFile(path, path);
		System.out.println(path + " " + path.getNameCount());
		System.out.println(path + " " + path.getName(0));

		path = Paths.get("C:\\Users"); // h1

		System.out.println(path + " " + path.getNameCount());
		System.out.println(path + " " + path.getName(0) + " " + path.getRoot() + " " + path.getRoot().getParent());

		int count = 0;
		for (int i = 0; i < path.getNameCount(); ++i) {
			count++;
		}
		System.out.println(count);

		testFileSystem();
		testPath();
		testPathMethods();
		testFileMethods();
		testDirectoryWalking();
		testIOAndNIO();
		createDirectoryAndSubDirectory(Paths.get("baseDir"));
		deleteDirectoryAndContents(FileSystems.getDefault().getPath("copy2"));
		moveDirectoryAndContents(Paths.get("baseDir"), FileSystems.getDefault().getPath("copy2"));
	}

	public static void testFileSystem() throws IOException {

		System.out.println("************************************");
		FileSystem fs1 = FileSystems.getDefault();
		System.out.println("Default:" + fs1);
		System.out.println("separator:" + fs1.getSeparator());
		fs1.getRootDirectories().forEach((Path p) -> System.out.println(p + " " + p.getRoot()));
		fs1.getFileStores().forEach((FileStore fs1tore) -> {
			try {
				System.out.print(fs1tore.name() + " ");
				System.out.print(fs1tore.getTotalSpace());
				System.out.println(" " + fs1tore.getUnallocatedSpace());
			} catch (Exception e) {
				System.out.println();
			}
		});

		Path path = fs1.getPath("abc.txt");
		System.out.println("fileName: " + path.getFileName());
		System.out.println("root: " + path.getRoot());

		try {
			FileSystem fs2 = FileSystems.getFileSystem(new URI("http://www.google.com"));
			fs2.getPath("abc.txt");
			System.out.println("separator:" + fs2.getSeparator());
			fs2.getRootDirectories().forEach((Path p) -> System.out.println(p));
			fs1.getFileStores().forEach((FileStore fs1tore) -> {
				try {
					System.out.print(fs1tore.name() + " ");
					System.out.print(fs1tore.getTotalSpace());
					System.out.println(" " + fs1tore.getUnallocatedSpace());
				} catch (Exception e) {
					System.out.println();
				}
			});
		} catch (URISyntaxException | ProviderNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testPath() {
		System.out.println("************************************");
		// Relative Path
		Path path1 = Paths.get("test", "io", "files", "a.txt");
		System.out.print(" Parent:" + path1.getParent());
		System.out.print(" File name:" + path1.getFileName());
		System.out.print(" Absolute:" + path1.isAbsolute() + " " + path1.toAbsolutePath());
		System.out.print(" Name count:" + path1.getNameCount());
		System.out.println(" Root:" + path1.getRoot());
		System.out.println(" Root:" + path1.toAbsolutePath().getRoot());

		Path path = Paths.get("C:/test/io/files", "sample", "xyz.txt");
		System.out.print(" Parent:" + path.getParent());
		System.out.print(" File name:" + path.getFileName());
		System.out.print(" Absolute:" + path.isAbsolute() + " " + path.toAbsolutePath());
		System.out.print(" Name count:" + path.getNameCount());
		System.out.println(" Root:" + path.getRoot());
		System.out.println(" Root:" + path.toAbsolutePath().getRoot());

		// Absolute Path
		Path path2 = Paths.get("c:", "Users", "edinjos", "Desktop", "backup", "ubuntu_BackUp", "Workspace",
				"Workspace_CoreJava8", "xyz.txt");
		System.out.print(" Parent:" + path2.getParent());
		System.out.print(" File name:" + path2.getFileName());
		System.out.print(" Absolute:" + path2.isAbsolute() + path2.toAbsolutePath());
		System.out.print(" Name count:" + path2.getNameCount());
		System.out.println(" Root:" + path2.getRoot());

		Path path3 = Paths
				.get("C:\\Users\\edinjos\\Desktop\\backup\\ubuntu_BackUp\\Workspace\\Workspace_CoreJava8\\Java8");
		System.out.print(" Parent:" + path3.getParent());
		System.out.print(" File name:" + path3.getFileName());
		System.out.print(" Absolute:" + path3.isAbsolute() + path3.toAbsolutePath());
		System.out.println(" Root:" + path3.getRoot());

		Path path10 = Paths.get("C:\\");
		System.out.print(" Parent:" + path10.getParent());
		System.out.print(" File name:" + path10.getFileName());
		System.out.print(" Absolute:" + path10.isAbsolute() + path10.toAbsolutePath());
		System.out.println(" Root:" + path10.getRoot());

		// URI Path
		try {
			Path path4 = Paths.get(new URI(
					"file:///c:/Users/edinjos/Desktop/backup/ubuntu_BackUp/Workspace/Workspace_CoreJava8/Java8"));
			System.out.print("URI Parent:" + path4.getParent());
			System.out.print(" URI File name:" + path4.getFileName());
			System.out.print(" URI Absolute:" + path4.isAbsolute() + path4.toAbsolutePath());
			System.out.println(" URI Root:" + path4.getRoot());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Path path5 = Paths.get(new URI("http://google.com"));
			System.out.print(" Parent:" + path5.getParent());
			System.out.print(" File name:" + path5.getFileName());
			System.out.println(" Root:" + path5.getRoot());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileSystemNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void testPathMethods() {
		System.out.println("************************************");
		Path path1 = Paths.get("C:/");
		System.out.println("Empty Path:" + path1 + " NameCount:" + path1.getNameCount() + " FileName:"
				+ path1.getFileName() + " Parent:" + path1.getParent() + " Root:" + path1.getRoot() + " AbsolutPath:"
				+ path1.isAbsolute());

		// Chaining
		path1 = Paths.get("/zoo/../home").normalize();
		path1 = path1.toAbsolutePath();
		System.out.println("Path:" + path1 + " NameCount:" + path1.getNameCount() + " FileName:" + path1.getFileName()
				+ " Parent:" + path1.getParent() + " Root:" + path1.getRoot() + " AbsolutPath:" + path1.isAbsolute());
		path1 = Paths.get("zoo/../home").getParent();
		path1 = path1.normalize();
		path1 = path1.toAbsolutePath();
		System.out.println("Path:" + path1 + " NameCount:" + path1.getNameCount() + " FileName:" + path1.getFileName()
				+ " Parent:" + path1.getParent() + " Root:" + path1.getRoot() + " AbsolutPath:" + path1.isAbsolute());

		System.out.println();
		path1 = Paths.get("/land/hippo/harry.happy");
		System.out.println("Path:" + path1 + " NameCount:" + path1.getNameCount() + " FileName:" + path1.getFileName()
				+ " Parent:" + path1.getParent() + " Root:" + path1.getRoot() + " AbsolutPath:" + path1.isAbsolute());

		for (int i = 0; i < path1.getNameCount(); i++)
			System.out.print(path1.getName(i) + " ");
		System.out.println();
		path1 = Paths.get("c:", "Users", "edinjos", "Desktop", "backup", "ubuntu_BackUp", "Workspace",
				"Workspace_CoreJava8", "xyz.txt");
		System.out.println("Path:" + path1 + " NameCount:" + path1.getNameCount() + " FileName:" + path1.getFileName()
				+ " Parent:" + path1.getParent() + " Root:" + path1.getRoot() + " AbsolutPath:" + path1.isAbsolute());

		for (int i = 0; i < path1.getNameCount(); i++)
			System.out.print(path1.getName(i) + " ");
		System.out.println("\n");
		// subpath
		path1 = Paths.get("");
		System.out.println("Path:" + path1 + " nameCOunt:" + path1.getNameCount() + " subpath:"
				+ path1.subpath(0, path1.getNameCount()));
		path1 = Paths.get("C:\\edinjos\\abc1\\def2").toAbsolutePath();
		Path path = path1.subpath(0, 2);

		System.out.println("Path:" + path1 + " nameCOunt:" + path1.getNameCount() + " subpath:" + path);

		// Path Symbols
		path1 = Paths.get("d1/d11/d111/../d12/abc.png");
		Path path2 = Paths.get("d1/d12/d121/../d11/def.png");

		System.out.println();
		System.out.println(
				"Path:" + path1 + " nameCOunt:" + path1.getNameCount() + " absolute path" + path1.toAbsolutePath());
		System.out.println(
				"Path:" + path2 + " nameCOunt:" + path2.getNameCount() + " absolute path" + path2.toAbsolutePath());

		// Normalize
		System.out.println("Path:" + path1 + " nameCOunt:" + path1.getNameCount() + " Normalize absolute path:"
				+ path1.normalize().toAbsolutePath());
		System.out.println("Path:" + path2 + " nameCOunt:" + path2.getNameCount() + "Normalize absolute path:"
				+ path2.normalize().toAbsolutePath());

		System.out.println("");

		// Relativize
		path1 = Paths.get("d1/d11/d111/d12/abc.png");
		path2 = Paths.get("/d1/d12/d121/d11/def.png");
		System.out
				.println("PATH1: " + path1 + " nameCount:" + path1.getNameCount() + " absolute:" + path1.isAbsolute());
		System.out
				.println("PATH2: " + path2 + " nameCount:" + path2.getNameCount() + " absolute:" + path2.isAbsolute());

		path1 = path1.toAbsolutePath();
		path2 = path2.toAbsolutePath();
		System.out
				.println("PATH1: " + path1 + " nameCount:" + path1.getNameCount() + " absolute:" + path1.isAbsolute());
		System.out
				.println("PATH2: " + path2 + " nameCount:" + path2.getNameCount() + " absolute:" + path2.isAbsolute());
		System.out.println("Relative Path: " + path1.relativize(path2));
		System.out.println("Relative Path: " + path2.relativize(path1));
		System.out.println("Normalized Relative Path: " + path1.relativize(path2).normalize());
		System.out.println("Normalized Relative Path: " + path2.relativize(path1).normalize());

		// Resolve
		path1 = Paths.get("d1/d11/abc.png");
		path2 = Paths.get("d1/d12/def.png");
		System.out.println("resolvePath: " + path1.resolve(path2));
		path1 = Paths.get("d1/d11/abc.png");
		path2 = Paths.get("/d1/d12/def.png");
		System.out
				.println(path1.isAbsolute() + " " + path2.isAbsolute() + " " + "resolvePath: " + path1.resolve(path2));

		// Normalize
		System.out.println();
		Path path3 = Paths.get("E:\\data");
		Path path4 = Paths.get("E:\\user\\home");
		Path relativePath = path3.relativize(path4);
		System.out.println("relativePath: " + relativePath + " " + relativePath.isAbsolute());
		System.out.println("resolvePath: " + path3.resolve(relativePath));
		System.out.println("resolvePath: " + relativePath.resolve(path3));
		System.out.println("Normalized resolvePath: " + path3.resolve(relativePath).normalize());

		// Check real Path
		try {
			path1 = Paths.get("d1/d11/abc.png").toRealPath(LinkOption.NOFOLLOW_LINKS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			path2 = Paths.get("file/abc.txt").toRealPath();
			System.out.println(path2 + " " + path2.isAbsolute());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testFileMethods() {
		System.out.println("************************************");
		Path path1 = Paths.get("./");
		System.out.println("path1:" + path1);
		path1 = path1.toAbsolutePath();
		System.out.println("path1:" + path1);

		// Check if file exists.
		System.out.println("File exists:" + Files.exists(path1, LinkOption.NOFOLLOW_LINKS));

		Path path2 = path1.subpath(5, path1.getNameCount());
		System.out.println("path2:" + path2);
		path2 = path2.toAbsolutePath();
		System.out.println("path2:" + path2);
		System.out.println("File exists:" + Files.exists(path2, LinkOption.NOFOLLOW_LINKS));

		// Check for same file
		try {
			path1 = Paths.get("file");
			path2 = Paths.get("C:/Users/edinjos/Desktop/backup/ubuntu_BackUp/Workspace/Workspace_CoreJava8/Java8/file");
			System.out.println("path1 : " + Files.isSymbolicLink(path1) + " " + path1);
			System.out.println("path2 : " + Files.isSymbolicLink(path2) + " " + path2);
			System.out.println("Same file: " + Files.isSameFile(path1, path2));

			path1 = Paths.get("file/../../Workspace_CoreJava8/Java8/file");
			path2 = Paths.get("C:/Users/edinjos/Desktop/backup/ubuntu_BackUp/Workspace/Workspace_CoreJava8/Java8/file");
			System.out.println("Same file: " + Files.isSameFile(path1, path2));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creating Directory/Directories
		path1 = Paths.get("testDir");

		path2 = Paths.get(path1.toAbsolutePath() + "/1/2/3/4/5/6/7/8/9.txt");

		try {
			Files.deleteIfExists(path1);
			Files.createDirectory(path1);
			Files.createDirectories(path2);
			System.out.println("Is Dir : " + Files.isDirectory(path1, LinkOption.NOFOLLOW_LINKS));
			System.out.println("Is Dir : " + Files.isDirectory(path2, LinkOption.NOFOLLOW_LINKS));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Copy Files from file Directory.
		path1 = Paths.get(".");
		path1 = path1.toAbsolutePath();
		path1 = path1.normalize();
		path1 = path1.resolve("file/test/abc.txt");

		try {
			if (!Files.exists(Paths.get("copy"), LinkOption.NOFOLLOW_LINKS))
				Files.createDirectory(Paths.get("copy"));
			Files.deleteIfExists(Paths.get("copy/abc.txt"));
			path2 = Paths.get("copy/abc.txt");
			Files.copy(path1, path2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// moving files
		try {
			Files.move(Paths.get("file1"), Paths.get("file"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Copying files using streams.

		try {
			path2 = Paths.get("io/copyUsingInputStream.txt");

			Files.deleteIfExists(path2);
			InputStream is = new FileInputStream(new File("file/test/abc.txt"));
			Files.copy(is, path2);
			OutputStream os = new FileOutputStream("io/copyUsingOutputStream.txt");
			Files.copy(path2, os);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Display Contents of a file
		try {
			Files.readAllLines(path2).forEach(System.out::print);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Reading and writing file content using java.io stream
		try {
			System.out.println();
			BufferedReader br = Files.newBufferedReader(path2);
			br.lines().forEach((String s) -> System.out.print(s));
			// br.lines().forEach(System.out::println);
			char[] data = new char[1024];
			int count = br.read(data, 0, 1024);
			System.out.println(data);
			BufferedWriter bw = Files.newBufferedWriter(Paths.get("io/fileBuff.txt"), Charset.defaultCharset());
			bw.write("This is sample text writtern");
			bw.write(3414);
			System.out.println();
			path1 = Paths.get("io/oswriter.txt");
			System.out.println("Directory:" + Files.isDirectory(path1));
			System.out.println("Regular file:" + Files.isRegularFile(path1));
			System.out.println("Executable file:" + Files.isExecutable(path1));
			System.out.println("Hidden file:" + Files.isHidden(path1));
			System.out.println("Readable file:" + Files.isReadable(path1));
			System.out.println("Symbolic Link:" + Files.isSymbolicLink(path1));
			System.out.println("Writeable file:" + Files.isWritable(path1));
			System.out.println("File size:" + Files.size(path1));
			System.out.println("File time:" + Files.getLastModifiedTime(path1));
			System.out.println("File owner:" + Files.getOwner(path1));

			// Read only view
			BasicFileAttributes attribute = Files.readAttributes(path1, BasicFileAttributes.class);

			System.out.println(
					attribute.isDirectory() + " " + attribute.isRegularFile() + " " + attribute.isSymbolicLink());

			//
			BasicFileAttributeView attributeView = Files.getFileAttributeView(path1, BasicFileAttributeView.class);

			FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
			attributeView.setTimes(fileTime, null, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testDirectoryWalking() {
		System.out.println("************************************");
		Path path1 = Paths.get("io");
		try {
			Files.walk(path1).forEach(System.out::println);
			Files.walk(path1, FileVisitOption.FOLLOW_LINKS);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testIOAndNIO() {
		File file1 = new File("test/pathFromFile/abc.txt");
		Path pathFromFile = file1.toPath();
		System.out.println("absolute path " + pathFromFile.isAbsolute() + " " + pathFromFile.toAbsolutePath() + " "
				+ Files.exists(pathFromFile));

		Path path1 = FileSystems.getDefault().getPath("test/fileFromPath/xyz.txt");
		File fileFromPath = path1.toFile();
		System.out.println("absolute path " + fileFromPath.isAbsolute() + " " + fileFromPath.getAbsolutePath() + " "
				+ fileFromPath.exists());

		Path path2 = FileSystems.getDefault().getPath("test/fileFromPath/xyz.txt");
		URI fileFromPath2 = path2.toUri();
		System.out.println("absolute path " + fileFromPath2.isAbsolute() + " " + fileFromPath2);

	}

	public static void createDirectoryAndSubDirectory(Path path) {
		Path dir1 = Paths.get("test");
		Path baseDir = path.resolve(dir1).normalize();
		System.out.println("BaseDir : " + baseDir);

		try {

			try (Stream<Path> paths = Files.list(Paths.get("copy"));) {
				paths.forEach((Path p) -> {
					System.out.println("createDirectoryAndSubDirectory:" + p);
				});
			} finally {

			}
			// Delete Directory
			deleteDirectoryAndContents(path);

			// Create baseDirectory
			Files.createDirectories(baseDir);
			System.out.println("Created Directories");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Path fp1 = Paths.get("abc.txt");
		Path file1 = path.resolve(fp1).normalize();
		System.out.println("file1 : " + file1);

		try {
			Files.write(file1, "This is writtern to file abc.txt. A sample file".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Path fp2 = Paths.get("test/pqr.txt");
		Path file2 = path.resolve(fp2).normalize();
		System.out.println("file2 : " + file2);

		try {
			Files.write(file2, "This is writtern to file pqr.txt. A sample file".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteDirectoryAndContents(Path path) {
		System.out.println("deleteDirectoryAndContents:" + path);

		if (Files.exists(path)) {
			try (Stream<Path> paths = Files.list(path);) {
				paths.forEach((Path p) -> {
					System.out.println("deleteDirectoryAndContents:" + p);
					try {
						if (Files.isRegularFile(p)) {
							Files.delete(p);
							System.out.println("deleteDirectoryAndContents:Delete File :" + p);
						} else {
							deleteDirectoryAndContents(p);
							Files.delete(p);
							System.out.println("deleteDirectory :" + p);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				});
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				Files.delete(path);
				System.out.println("deleteDirectory :" + path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void deleteDirectory(Path path) {
		System.out.println("deleteDirectory" + path);
		try {
			Files.delete(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void moveDirectoryAndContents(Path source, Path destination) {
		System.out.println("copyDirectoryAndContents Source:" + source);
		System.out.println("copyDirectoryAndContents Destination:" + destination);
		try {
			Files.move(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
