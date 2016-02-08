package file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;

public class Write {

	public static String changeOption(String s, boolean clavier, int sens, int fenX, int fenY, boolean fullS){
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(s,"UTF-8");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erreur, fichier inaccessible", "Erreur fichier", JOptionPane.ERROR_MESSAGE);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erreur, fichier inécrivable", "Erreur encodage", JOptionPane.ERROR_MESSAGE);
		}
		
		writer.println(clavier);
		writer.println(sens);
		writer.println(fenX);
		writer.println(fenY);
		writer.print(fullS);
		writer.close();
		
		return null;
	}
	
}
