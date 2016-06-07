import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class FileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File inFile = new File("tmp"+File.separator+"input.txt");
		FileInputStream inStream = null;
		
		try {
			inStream = new FileInputStream(inFile);
		} catch(FileNotFoundException e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		
		FileChannel inChannel = inStream.getChannel();
		try {
			ByteBuffer buffer = ByteBuffer.allocate((int)(inChannel.size()));
			System.out.println("Read the whole file...");
			while (inChannel.read(buffer) != -1) {
				System.out.println("Read:["+((ByteBuffer)(buffer.flip())).asCharBuffer().toString()+"]\n");
				buffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}

		try {
			ByteBuffer buffer = ByteBuffer.allocate(30*2);
			buffer.position(buffer.limit());
			inChannel.position(0);
			System.out.println("Read chunk...");
			while (inChannel.read(buffer.compact()) != -1) {
				String strBuffer = ((ByteBuffer)(buffer.flip())).asCharBuffer().toString();
				int eol = strBuffer.indexOf('\n');
				System.out.println("Read:["+strBuffer.substring(0, (-1==eol? strBuffer.length(): eol))+"]");
				buffer.position(2 * (-1==eol? strBuffer.length(): eol+1));
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}

	}

}
