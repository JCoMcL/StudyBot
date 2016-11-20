package Interface;

import java.util.Arrays;
import java.util.Collections;
import Data.DataCount;
import Data.DataQuery;

public class Schedule 
{
	private static Integer[] Order;
	
	public static void generateFull()
	{	
		DataCount CountAll = new DataCount("");
		Integer Count = CountAll.count();
		Order = new Integer[Count+1];

		for (int i = 1; i <= Count; i++)			{Order[i] = i;} 

		Collections.shuffle(Arrays.asList(Order));
	}

	public static void generateSubject(String Subject)
	{
		DataCount CountSubject = new DataCount("WHERE Subject = '"+Subject+"'");
		Integer Count = CountSubject.count();
		Order = new Integer[Count+1];
		for (int i = 1; i <= Count; i++)			{Order[i] = DataQuery.queryId(Subject)[i-1];}
		
		Collections.shuffle(Arrays.asList(Order));
	}
	
	public static Integer decrypt(Integer x)	{return Order[x];}
	public static Integer length()				{return Order.length - 1;}
	
	public static void main(String[] args)
	{Schedule.generateSubject("Maths");}
}
