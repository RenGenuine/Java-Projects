import java.util.*
import java.io.*

public class PhoneDict
{
	public static void main(String args[])
	{
		PhoneDict phoneDict = new PhoneDict();
		
		phoneDict.readIn(phoneDict.words, phoneDict.read);
		
		phoneDict.readIn(phoneDict.stdin, phoneDict.code);
		
		phoneDict.build();
		
		phoneDict.compile();
	}
	
	String space = "0+";
	
	ArrayList<String> words;
	
	ArrayList<String> code;
	
	Scanner stdin;
	
	Scanner read;
	
	Hashtable<String, ArrayList<String>> Dict;
	
	public PhoneDict()
	{
		this("words", System.in);
	}
	
	public PhoneDict(String in)
	{
		this("words", in);
	}
	
	public PhoneDict(InputStream in)
	{
		this("words", in);
	}
	
	public PhoneDict(String i, InputStream in)
	{
		try
		{
			stdin = new Scanner(in);
			File file = new File(i);
			read = new Scanner(file);
			words = new ArrayList<String>();
			code = new ArrayList<String>();
			Dict = new Hashtable<String, ArrayList <String>>();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: '"+ i +"' not found\n");
		}
	}
	
	public void readIn(Scanner in, ArrayList<String> iList)
	{
		String line;
		while(in.hasNext())
		{
			line = in.next();
			iList.add(line);
		}
	}
	
	public PhoneDict(String i, String in)
	{
		try
		{
			stdin = new Scanner(in);
			File file = new File(i);
			read = new Scanner(file);
			words = new ArrayList<String>();
			code = new ArrayList<String>();
			Dict = new Hashtable<String, ArrayList <String>>();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: '"+ i +"' not found\n");
		}
	}
	public ArrayList<String> parseCode(String j)
	{
		ArrayList<String> phrase = new ArrayList<String>();
		String[] splitJ = j.split(space);
		
		for(String k: splitJ)
		{
			phrase.add(k);
		}
		return phrase;
	}
	
	public String pW (String cW)
	{
		ArrayList<String> temp = (ArrayList<String>) Dict.get(cW);
		String out = "";
		
		if(temp == null)
		{
			cW = cW.replaceAll(".", "*");
			out += (cW + " ");
		}
		else if(temp.size() == 1)
		{
			return (temp.get(0) + " ");
		}
		else if(temp.size() > 1)
		{
			out += "(";
			for (String i: temp)
			{
				out += (i + "|");
			}
			out = out.substring(0, (out.length()) - 1));
			out += ") ";
		}
		return out;
	}
	
	public String convert(String e)
	{
		String ii = ("aAbBcC");
		String iii = ("dDeEfF");
		String iv = ("gGhHiI");
		String v = ("jJkKlL");
		String vi = ("mMnNoO");
		String vii = ("pPqQrRsS");
		String viii = ("tTuUvV");
		String ix = ("wWxXyYzZ");
		String finish = "";
		
		for(int a = 0, a < e.length(); a++)
		{
			String eInit = ("" + e.charAt(a));
			if(ii.contains(eInit))
			{
				finish += "2";
			}
			else if(iii.contains(eInit))
			{
				finish += "3";
			}
			else if(iv.contains(eInit))
			{
				finish += "4";
			}
			else if(v.contains(eInit))
			{
				finish += "5";
			}
			else if(vi.contains(eInit))
			{
				finish += "6";
			}
			else if(vii.contains(eInit))
			{
				finish += "7";
			}
			else if(viii.contains(eInit))
			{
				finish += "8";
			}
			else if(ix.contains(eInit))
			{
				finish += "9";
			}
		}
		return finish;
	}
	
	public void build()
	{
		for (String t: words)
		{
			String e = convert(t);
			ArrayList<String> temp = (ArrayList<String>) Dict.get(e);
			
			if (temp == null)
			{
				temp = new ArrayList<String>();
				temp.add(t);
				Dict.put(e, temp);
			}
			else
			{
				temp.add(t);
			}
		}
	}
	
	public void compile()
	{
		String ePhrase;
		
		for(String t: code)
		{
			ePhrase = "";
			ArrayList<String> phrase = parseCode(t);
			
			for(String j: phrase)
			{
				ePhrase += printWord(j);
			}
			
			System.out.println(ePhrase);
		}
	}
}