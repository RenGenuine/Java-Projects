import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Csv
{
	public static void main(String args[])
	{
		Csv csv = new Csv("test.csv");
		String line;
		while((line = csv.getLine()) != null)
		{
			System.out.println("line = '" + line + "'");
			for(int i = 0; i < csv.getFieldLength(); i++)
				System.out.println("field[" + i + "] = '" + csv.getField(i) + "'");
		}
	}
	
	private BufferedReader reader;
	private String seperator;
	private String[] fields;
	
	public Csv()
	{
		this(System.in, ",");
	}
	
	public Csv(InputStream in)
	{
		this(in, ",");
	}
	
	public Csv(String in)
	{
		this(in, ",");
	}
	
	public Csv(String in, String sep)
	{
		try
		{
			reader = new BufferedReader(new FileReader(in));
			seperator = sep;
			fields = new String[0];
		}
		catch(FileNotFoundException e)
		{
			System.err.println("ERROR: Cannot find file \"" + in + "\"");
		}
	}
	
	public Csv(InputStream in, String sep)
	{
		reader = new BufferedReader(new InputStreamReader(in));
		seperator = sep;
		fields = new String[0];
	}
	
	public String getLine()
	{
		try
		{
			String line = reader.readLine();
			if(line != null)
				fields = split(line, seperator);
			return line;
		}
		catch(IOException e)
		{
			System.err.println("ERROR: IO exception while reading");
			fields = new String[0];
			return "";
		}
	}
	
	public int getFieldLength()
	{
		return fields.length;
	}
	
	public String getField(int i)
	{
		if(i >= 0 || i < fields.length)
			return fields[i];
		return "";
	}
	
	private String[] split(String line, String sep)
	{
		List<String> list = new ArrayList<String>(0);
		boolean quoted = false;
		String field = "";
		int spaces = 0;
		for(int i = 0; i < line.length(); i++)
		{
			if(!quoted && sep.contains("" + line.charAt(i)))
			{
				list.add(field.substring(0, field.length() - spaces));
				field = "";
				spaces = 0;
				continue;
			}
			if(line.charAt(i) == '"')
			{
				if(quoted && i + 1 < line.length() && line.charAt(i + 1) == '"')
					field = field + line.charAt(i++);
				else
					quoted = !quoted;
				continue;
			}
			if(!quoted && line.charAt(i) == ' ')
			{
				if(field.length() != 0)
				{
					field = field + ' ';
					spaces++;
				}
			}
			else
			{
				field = field + line.charAt(i);
				spaces = 0;
			}
		}
		list.add(field.substring(0, field.length() - spaces));
		return list.toArray(new String[0]);
	}
}
