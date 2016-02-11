package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lines {
	public static int getLine(String s){
		int nLine = 0;
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(s));
			while((br.readLine()) != null){
				nLine++;
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
		
		return nLine;
	}
}
