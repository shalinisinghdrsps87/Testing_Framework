package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.log4j.Logger;



public class PrintInTxtFile {
	//private static Logger log = Logger.getLogger(PrintInTxtFile.class.getName());
	private static final Logger log= LoggerHelper.getLogger(PrintInTxtFile.class);
	public static void printDetails(String msg) throws IOException {
		String path = System.getProperty("user.dir")+"\\output\\details.txt";
		System.out.println(path);
		File f = new File(path);
		if (f.exists()) {
			f.delete();
		}
		f.createNewFile();
		
		FileWriter fw = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fw);
		try {
		bw.write(msg);
			log.info(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			bw.flush();
			bw.close();
		}
		
		
	}
	
}
