package homework10;

import java.io.RandomAccessFile;

/**
 * 将一个文件倒置输出
 * @author lcj
 *
 */
public class InversionFile {
	public static void main(String[] args) {
		RandomAccessFile inAndOut = null;
		int data[] = {1,2,3,4,5,6,7,8,9,10};
		try {
			inAndOut = new RandomAccessFile("tom.dat", "rw");
			for(int i=0;i<data.length;i++){
				inAndOut.writeInt(data[i]);
				
			}
			
			for(long i=data.length-1;i>=0;i--){
				inAndOut.seek(i*4);
				System.out.printf("\t%d",inAndOut.readInt());
			}
			inAndOut.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
