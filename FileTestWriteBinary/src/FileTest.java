import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
	import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.channels.FileChannel;

public class FileTest {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dataInt = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		long[] dataLong = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		File outFile = new File("tmp"+File.separator+"testout.txt");
		try {
			PrintWriter outWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
			for (int element: dataInt) {
				outWriter.printf("%3d", element);
				System.out.printf("%3d", element);
			}
			outWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.err);
		}
		
		ByteBuffer writeBuffer = ByteBuffer.allocate(200);

		try {
			IntBuffer intBuffer = writeBuffer.asIntBuffer();
			intBuffer.put(dataInt);
			writeBuffer.position(4 * intBuffer.position());

			LongBuffer longBuffer = writeBuffer.asLongBuffer();
			longBuffer.put(dataLong);
			writeBuffer.limit(writeBuffer.position()+ 8 * longBuffer.position()).position(0);
		} catch (BufferOverflowException e) {
			e.printStackTrace(System.err);
		}
		
		outFile = new File("tmp"+File.separator+"testout.bin");
		try {
			FileOutputStream outStream = new FileOutputStream(outFile);
			FileChannel outChannel = outStream.getChannel();
			
			outChannel.write(writeBuffer);
			outStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.err);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}

		return;
	}

}
