package homework10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * ��һ���ļ����ı����ݰ��ж���,�����к�
 * @author lcj
 *
 */
public class FileReadTest {
	public static void main(String[] args) {
		File fileRead = new File("english.txt");
		File fileWrite = new File("englishCount.txt");
		try {
			Writer out = new FileWriter(fileWrite);
			BufferedWriter bufferWriter = new BufferedWriter(out);
			Reader in = new FileReader(fileRead);
			BufferedReader bufferReader = new BufferedReader(in);
			String str = null;
			int count=1;
			while((str=bufferReader.readLine())!=null){
				bufferWriter.write(count+" "+str);
				count++;
				bufferWriter.newLine();
			}
			bufferWriter.close();
			out.close();
			in = new FileReader(fileWrite);
			bufferReader = new BufferedReader(in);
			String s = null;
			System.out.println(fileWrite.getName()+"����:");
			while((s=bufferReader.readLine())!=null){
				System.out.println(s);
			}
			bufferReader.close();
			in.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
}
