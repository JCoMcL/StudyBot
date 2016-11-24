package Interface;

import java.util.Arrays;
import java.util.Collections;
import Data.DataCount;
import Data.DataQuery;

public class Schedule 
{
	public Integer[] Order;
	
	public Schedule(){}
	
	public void generate(String SQL)
	{
		DataCount CountSubject = new DataCount();
		SQLMaster sql = new SQLMaster(true);
		String[] Input = {"c","s","Irish","/","s","Maths"};
		sql.addtoArray(Input);
		Integer Count = CountSubject.count(sql.generateSQL());
		this.Order = new Integer[Count+1];
		DataQuery Array = new DataQuery();
		Array.queryArrayInt(sql.generateSQL(),"rowid");
		for (int i = 1; i <= Count; i++)			{Order[i] =  Array.ArrayInt [i-1];}
		
		Collections.shuffle(Arrays.asList(Order));
	}
	
	public Integer decrypt(Integer x)	{return Order[x];}
	public Integer length()				{return Order.length - 1;}
	
	public static void main(String[] args)
	{
		Schedule boi = new Schedule();
		boi.generate("kill me please");
		System.out.println(boi.Order);
	}
}
