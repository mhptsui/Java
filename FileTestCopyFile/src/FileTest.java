import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;


public class FileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File fromFile = new File("tmp"+File.separator+"Beginning Java 2, JDK 5 Edition.pdf");
		FileInputStream fromStream = null;
		try {
			fromStream = new FileInputStream(fromFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		FileChannel fromChannel = fromStream.getChannel();
		
		File toFile = new File("tmp"+File.separator+"test.pdf");
		FileOutputStream toStream = null;
		FileChannel toChannel = null;

		try {
			toStream = new FileOutputStream(toFile);
			toChannel = toStream.getChannel();
			fromChannel.transferTo(0, fromChannel.size(), toChannel);
			toStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.err);
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
		
		try {
			toFile = new File("tmp"+File.separator+"test2.pdf");
			toStream = new FileOutputStream(toFile);
			toChannel = toStream.getChannel();
			toChannel.transferFrom(fromChannel, 0, fromChannel.size());
			toChannel.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.err);
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}

	}

}
