package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.MarkBlock;

public class FileManager {
	public static final String ORIGINAL_PATH = "E:\\AI\\data";

	public boolean WriteStringToFile(String content, String filePath, String fileName) {
		try {
			File directory = new File(ORIGINAL_PATH + filePath);
			if (!directory.exists())
				directory.mkdirs();
			File file = new File(ORIGINAL_PATH + filePath + "\\" + fileName);
			if (!file.exists())
				file.createNewFile();

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public int SaveMarkBlockChain(ArrayList<MarkBlock> arrayList) {
		return arrayList.size();
	}
}
