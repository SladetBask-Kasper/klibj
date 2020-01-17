package klibj;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

///
/// Dialogs class in order to remove unnecessarily long lines of code.
///
public class Dialogs {
	
	///
	/// msg was originally made in order to save us from needing a parent
	/// now it's used for automation of simple task involving message boxes
	///
	public static void msg(String txt, JFrame parent) {
		JOptionPane.showMessageDialog(parent, txt);
		return;
	}
	public static void msg(int txt) {msg(String.valueOf(txt), null);}
	public static void msg(boolean txt) {msg(String.valueOf(txt), null);}
	public static void msg(String txt) {msg (txt, null);}
	
	///
	/// Input is a short version of the horribly long "JOptionPane.showInputDialog"
	///
	public static String input(String message, String initialSelectionValue) {
		return JOptionPane.showInputDialog(message, initialSelectionValue);
	}
	public static String input(String message) {return input(message, "");}
	
	public static boolean confirm(String msg, String title) {
		int n = JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.YES_NO_OPTION);
		return n==JOptionPane.YES_OPTION?true:false; // The question mark operator is redundant.
	}
}