package GenericUtility;

import java.util.Random;

public class JavaUtility {
	
	/**
	 * This method is used for random value
	 * @return
	 */
	
	public int getRandomNum() {
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}

}
