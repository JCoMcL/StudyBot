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
		Integer n = 2;
		Boolean spec = false;
		switch (GenKey.get(0))
		{
			case "c": 	this.URL = "jdbc:sqlite:SBData1.db";				break; 
			case "s":	this.URL = "http://www.placeholder.com";			break; 
			default:	System.out.println(GenKey.get(0)+" is invalid 0");
		}
		switch (GenKey.get(n))
		{
			case "s": 	this.SQL = "SELECT "; spec = true;						break; 
			case "c":	this.SQL = "SELECT COUNT(*) AS length FROM ";			break; 
			case "i":	this.SQL = "INSERT INTO ";								break; 
			default:	System.out.println(GenKey.get(n)+" is invalid "+n);
						System.out.println(this.SQL);
		}
		if (spec){
		n++;
		switch (GenKey.get(n))
		{
			case "i": 	this.SQL += "rowid FROM ";		break; 
			case "1": 	this.SQL += "Desc1 FROM ";		break; 
			case "2": 	this.SQL += "Desc2 FROM ";		break; 
			case "s": 	this.SQL += "Subject FROM ";	break; 
			case "t": 	this.SQL += "Topic FROM ";		break; 
			case "k": 	this.SQL += "Type FROM ";		break; 
			case "w": 	this.SQL += "Wins FROM ";		break; 
			case "f": 	this.SQL += "Fails FROM "; 		break;
			default:	System.out.println(GenKey.get(n)+" is invalid "+n);
						System.out.println(this.SQL);
		}spec=false;}
		switch (GenKey.get(1))
		{
			case "1": 	this.SQL += "Table1 ";			break; 
			default:	System.out.println(GenKey.get(1)+" is invalid 1");
						System.out.println(this.SQL);
		}
		n++;
		if (this.GenKey.size() > n){
		switch (GenKey.get(n))
		{
			case "i": 	this.SQL += "WHERE rowid = '" 	+ GenKey.get(n+1) + "' ";	n++;						break; 
			case "1": 	this.SQL += "WHERE Desc1 = '" 	+ GenKey.get(n+1) + "' ";	n++;						break; 
			case "2": 	this.SQL += "WHERE Desc2 = '" 	+ GenKey.get(n+1) + "' ";	n++;						break; 
			case "s": 	this.SQL += "WHERE Subject = '" + GenKey.get(n+1) + "' ";	n++;						break; 
			case "t": 	this.SQL += "WHERE Topic = '" 	+ GenKey.get(n+1) + "' ";	n++;						break; 
			case "k": 	this.SQL += "WHERE Type = '" 	+ GenKey.get(n+1) + "' ";	n++;						break; 
			case "w": 	this.SQL += "WHERE Wins = " 	+ GenKey.get(n+1) + " ";	n++;						break; 
			case "f": 	this.SQL += "WHERE Fails = " 	+ GenKey.get(n+1) + " ";	n++;						break; 
			case "I":	this.SQL += "(Desc1,Desc2,Subject,Topic, Type) VALUES" + GenKey.get(4) + " "; n++;		break; 
			default:	System.out.println(GenKey.get(n)+" is invalid :-(");
						System.out.println(this.SQL);
		}
		n++;
		if (this.GenKey.size() > n){
		switch (GenKey.get(n))
		{
			case "&":	this.SQL +=	"AND "; break;
			case "/":	this.SQL +=	"OR ";	break;
			default:	System.out.println(GenKey.get(n)+" is invalid "+n);
						System.out.println(this.SQL);
		}
		n++;
		switch (GenKey.get(n))
		{
			case "i": 	this.SQL += "rowid = '" 	+ GenKey.get(n+1) + "' ";	break; 
			case "1": 	this.SQL += "Desc1 = '" 	+ GenKey.get(n+1) + "' ";	break; 
			case "2": 	this.SQL += "Desc2 = '" 	+ GenKey.get(n+1) + "' ";	break;
			case "s": 	this.SQL += "Subject = '"	+ GenKey.get(n+1) + "' ";	break; 
			case "t": 	this.SQL += "Topic = '" 	+ GenKey.get(n+1) + "' ";	break; 
			case "k": 	this.SQL += "Type = '" 		+ GenKey.get(n+1) + "' ";	break; 
			case "w": 	this.SQL += "Wins = " 		+ GenKey.get(n+1) + " ";	break; 
			case "f": 	this.SQL += "Fails = " 		+ GenKey.get(n+1) + " ";	break; 	
			default:	System.out.println(GenKey.get(n)+" is invalid "+n);
						System.out.println(this.SQL);
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
