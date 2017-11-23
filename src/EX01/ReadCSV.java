package EX01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
	
	public static String[][] CSVtoMatrix(String fileName){
		int raws, lines;
		raws = 11;
		lines = LCtr(fileName);
		String[][] mtx = new String[lines][raws];
		
		//enter the file to matrix
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			if(str==null||!str.startsWith("WigleWifi"))
				return null;
			for(int j=0;j<lines;j++){
				mtx[j] = str.split(",");
				str = br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
		return mtx;
	}
	
	//returns sum of lines in the file
		private static int LCtr(String fileName){
			int lines = 0;
			try {
				FileReader nfr = new FileReader(fileName);
				BufferedReader nbr = new BufferedReader(nfr);
				while(nbr.ready()){
					lines++;
					nbr.readLine();
				}
				nbr.close();
				nfr.close();
			}
			catch(IOException ex) {
				System.out.print("Error reading file\n" + ex);
				System.exit(2);
			}
			return lines;
		}

}