package Interface;

import java.util.ArrayList;

public class SQLMaster 
{
	public String URL;
	
	public String SQL;
	
	ArrayList<String> GenKey;
	
	public SQLMaster(Boolean Default)
	{
		this.GenKey = new ArrayList<String>();
		this.resetArray(Default);
	}
	
	public void resetArray(Boolean Default)
	{
		GenKey.clear();
		if (Default)
		{
			GenKey.add	("c");
			GenKey.add	("1");
		}
	}
	
	public void addtoArray(String[] Input)
	{
		for (String input: Input) 
		{GenKey.add(input);}
	}
	
	public String generateInput(String Desc1, String Desc2, String Subject, String Topic, String Type)
		{return "('"+Desc1+"','"+Desc2+"','"+Subject+"','"+Topic+"','"+Type+"')";}
		
	public String generateSQL()
	{
		switch (GenKey.get(0))
		{
			case "c": 	this.URL = "jdbc:sqlite:SBData1.db";					break; 
			case "s":	this.URL = "https://www.freenudecelebs.com";			break; 
			default:	System.out.println(GenKey.get(0)+" is invalid 0");
		}
		switch (GenKey.get(2))
		{
			case "s": 	this.SQL = "SELECT FROM ";								break; 
			case "c":	this.SQL = "SELECT COUNT(*) AS length FROM ";			break; 
			case "i":	this.SQL = "INSERT INTO ";								break; 
			default:	System.out.println(GenKey.get(2)+" is invalid 2");
		}
		switch (GenKey.get(1))
		{
			case "1": 	this.SQL += "Table1 ";									break; 
			default:	System.out.println(GenKey.get(1)+" is invalid 1");
		}
		if (this.GenKey.size() > 3){
		switch (GenKey.get(3))
		{
			case "i": 	this.SQL += "WHERE rowid = '" 	+ GenKey.get(4) + "' ";							break; 
			case "1": 	this.SQL += "WHERE Desc1 = '" 	+ GenKey.get(4) + "' ";							break; 
			case "2": 	this.SQL += "WHERE Desc2 = '" 	+ GenKey.get(4) + "' ";							break; 
			case "s": 	this.SQL += "WHERE Subject = '" + GenKey.get(4) + "' ";							break; 
			case "t": 	this.SQL += "WHERE Topic = '" 	+ GenKey.get(4) + "' ";							break; 
			case "k": 	this.SQL += "WHERE Type = '" 	+ GenKey.get(4) + "' ";							break; 
			case "w": 	this.SQL += "WHERE Wins = " 	+ GenKey.get(4) + " ";							break; 
			case "f": 	this.SQL += "WHERE Fails = " 	+ GenKey.get(4) + " ";							break; 
			case "I":	this.SQL += "(Desc1,Desc2,Subject,Topic, Type) VALUES" + GenKey.get(4) + " ";	break; 
			default:	System.out.println(GenKey.get(3)+" is invalid 3");
		}
		if (this.GenKey.size() > 7){
		switch (GenKey.get(5))
		{
			case "&":	this.SQL +=	"AND "; break;
			case "/":	this.SQL +=	"OR ";	break;
			default:	System.out.println(GenKey.get(5)+" is invalid 5");
		}
		switch (GenKey.get(6))
		{
			case "i": 	this.SQL += "rowid = '" 	+ GenKey.get(7) + "' ";	break; 
			case "1": 	this.SQL += "Desc1 = '" 	+ GenKey.get(7) + "' ";	break; 
			case "2": 	this.SQL += "Desc2 = '" 	+ GenKey.get(7) + "' ";	break;
			case "s": 	this.SQL += "Subject = '"	+ GenKey.get(7) + "' ";	break; 
			case "t": 	this.SQL += "Topic = '" 	+ GenKey.get(7) + "' ";	break; 
			case "k": 	this.SQL += "Type = '" 		+ GenKey.get(7) + "' ";	break; 
			case "w": 	this.SQL += "Wins = " 		+ GenKey.get(7) + " ";	break; 
			case "f": 	this.SQL += "Fails = " 		+ GenKey.get(7) + " ";	break; 	
			default:	System.out.println(GenKey.get(6)+" is invalid 6");
		}}}
		return this.SQL;
	}
	
	public static void main(String args[])
	{
		SQLMaster test = new SQLMaster(true);
		String[] array = {"c","s","Irish","/","s","Maths"};
		test.addtoArray(array);
		System.out.println(test.generateSQL());
		//System.out.println(test.GenKey.get(4));
		
	}
}
