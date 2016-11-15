package homework10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;

/**
 * ≤‚ ‘≥§∂»
 * @author lcj
 *
 */
public class E {
	public static void main(String[] args) {
		File file = new File("E:/JAVA/EclipseWorkspaces/java2/src/homework10/E.java");
		try {
			RandomAccessFile in = new RandomAccessFile(file, "rw");
			System.out.println(file.length());
			FileOutputStream out = new FileOutputStream(file);
			System.out.println(file.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
		testPrintStream();
	}
	
	public static void testPrintStream(){
		try {
			File file = new File("p.txt");
			FileOutputStream out = new FileOutputStream(file);
			PrintStream ps = new PrintStream(out);
			ps.print(12345.6789);
			ps.println("how are you");
			ps.println(true);
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
