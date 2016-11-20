package Interface;

import Data.DataCheck;

public class Verify {

	public static boolean Translation(Integer Instance, String Answer)
	{
		return DataCheck.Match(Schedule.decrypt(Instance), Answer);
	}
}
	