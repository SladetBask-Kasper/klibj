package klibj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
	
	///
	/// Returns True if forThis is in file.
	/// Args: forThis = phrase to search for
	/// 	  file    = File name and path
	/// Desc:
	/// Read files and looks for phrase.
	///
	public static boolean scan(String forThis, String file) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       if (line.contains(forThis)) {
		    	   return true;
		       }
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	///
	/// Returns array with file content.
	/// Args: file    = File name and path
	/// Desc:
	/// Read files into array.
	///
	public static String[] readFile(String file) {
		List<String> rv = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	rv.add(line);
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] array = rv.toArray(new String[0]);
		
		return (String[]) array;
	}
	///
	/// Returns True if file has been written to.
	/// Args: content = what you want to append to the file
	/// 	  file    = File name and path
	/// Desc:
	/// Writes text to new text file.
	///
	public static boolean writeFile(String content, String file) {
		try (PrintWriter out = new PrintWriter(file)) {
		    out.println(content);
		    return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	///
	/// Returns True if file has been written to.
	/// Args: content = what you want to append to the file
	/// 	  file    = File name and path
	/// Desc:
	/// Appends text to already existing text file.
	///
	public static boolean appendFile(String content, String file) {
		File ofile = new File(file);
		FileWriter fr = null;
		try {
			fr = new FileWriter(ofile, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fr.write(content);
			fr.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	///
	/// Why can't there be a frickin' CSV reader somewhere for java >:-(
	///
	public static String[][] readCSV(String file, String separator) {
		String[][] rv = new String[1024][];
		String[] content = readFile(file);
		for (int i = 0; i < content.length; i++) {
			String [] data = content[i].split(separator);
			rv[i] = data;
		}
		return rv;
	}
	public static String[][] readCSV(String file) {return readCSV(file, ",");}
	public static String[] CSVgetAllIndex(String[][] contentCSV, int index) {
		List<String> rv = new ArrayList<String>();
		for (int i = 0; i < contentCSV.length-1; i++) {
			if (contentCSV[i] == null) {
				break;
			}
			rv.add(contentCSV[i][index]);
		}
		String[] array = rv.toArray(new String[0]);
		
		return (String[]) array;
	}
}
