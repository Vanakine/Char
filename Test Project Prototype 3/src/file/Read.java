package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read {
	public static String readAtLine(String s, int line){
		String finalString = null, string = null;
		BufferedReader br = null;
		int i = 1;
		
		try {
			br = new BufferedReader(new FileReader(s));
			while ((i <= line) && ((string=br.readLine()) != null)){ 
				finalString=string;
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return finalString;
	}
	
	public static String readLastLine(String s){
		String finalString = null, string = null;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(s));
			while((string = br.readLine()) != null){
				finalString = string;
			}
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			try{
				if (br != null)br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return finalString;
	}
	
	public static String[] readAll(String s){
		String[] finalString = null;
		int lines = Lines.getLine(s);
		finalString = new String[lines];
		String string = null;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(s));
			for(int i = 0;(string = br.readLine()) != null; i++){
				finalString[i] = string;
			}
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			try{
				if (br != null)br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return finalString;
	}
}
