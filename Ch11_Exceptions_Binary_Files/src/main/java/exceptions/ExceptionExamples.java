package exceptions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;


import javax.security.auth.Destroyable;
import javax.security.auth.DestroyFailedException;

/**
 * A list of commonly encountered exceptions
 * @author bolitj01
 */
public class ExceptionExamples implements Destroyable{

	public static void main(String[] args) throws InterruptedException, IOException, DestroyFailedException, URISyntaxException {

        ArrayList<Integer> numsAL = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        for (int num: numsAL) {
            numsAL.remove(num);
        }


		//FileNotFound	
		InputStream f = ExceptionExamples.class.getResourceAsStream("/NotHere.txt"); // null: resource does not exist
		//				Scanner reader = new Scanner(f);

		//ArrayIndexOutOfBounds
		int[] nums = {1, 2, 3, 4};
		for(int i = 0; i <= nums.length; i++) {
			//									System.out.println(nums[i]);
		}

		//IllegalArgument
						Thread.sleep(-1);  

		RandomAccessFile reader = new RandomAccessFile(new File(ExceptionExamples.class.getResource("/Numbers.dat").toURI()), "r");
		reader.seek(1000000L);

		ArrayList<String> names = new ArrayList<>();
		names.addAll(Arrays.asList("Bob", "Sue", "Joe"));

		AtomicInteger counter = new AtomicInteger(0);

		//ConcurrentModification
		for (String name : names) {
			//Remove the first element
//						if (counter.getAndIncrement() == 0) {
//							names.remove(0);
//						}
//			names.remove(0);
		}

		SecureData data = new ExceptionExamples().new SecureData("password");
		data.display();

		data.destroy();
		System.out.println("Data destroyed successfully.");
		data.destroy();
		data.display(); // This will throw an exception


	}

	private class SecureData implements Destroyable {
		private char[] password;
		private boolean destroyed = false;

		public SecureData(String password) {
			this.password = password.toCharArray();
		}

		@Override
		public void destroy() throws DestroyFailedException {
			if (destroyed) {
				throw new DestroyFailedException("Data already destroyed.");
			}
			Arrays.fill(password, '\0'); // Overwrite sensitive data
			destroyed = true;
		}

		@Override
		public boolean isDestroyed() {
			return destroyed;
		}

		public void display() {
			if (destroyed) {
				throw new IllegalStateException("Data is destroyed.");
			}
			System.out.println("Stored password: " + new String(password));
		}

	}

}
