package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import model.MSubject;
import model.MarkBlock;
import model.Student;

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
		String content = "";
		for(int i=0; i<arrayList.size(); i++)
		{
			content += arrayList.get(i).ToJsonString();
			content += "\n";
		}
		WriteStringToFile(content, "", "MarkBlockChain.txt");
		return arrayList.size();
	}
	
	public ArrayList<MarkBlock> GetMarkBlockChain()
	{
		ArrayList<MarkBlock> arrayList = new ArrayList<>();
		try {
			File directory = new File(ORIGINAL_PATH + "");
			if (!directory.exists())
				directory.mkdirs();
			File file = new File(ORIGINAL_PATH + "\\" + "MarkBlockChain.txt");
			if (!file.exists())
				file.createNewFile();
			BufferedReader reader = new BufferedReader(new FileReader(ORIGINAL_PATH + "\\" + "MarkBlockChain.txt"));
			String str;

			while ((str = reader.readLine()) != null) {
				if (!str.equals("") && !str.equals("\n")) {
					Object obj = JSONValue.parse(str);
					JSONObject object = (JSONObject) obj;
					
					String studentId = (String) object.get("studentId");
					String subjectId = (String) object.get("subjectId");
					double midleMark = Double.parseDouble(((Double) object.get("midleMark")).toString());
					double endMark = Double.parseDouble(((Double) object.get("endMark")).toString());
					String prevHash = (String) object.get("prevHash");
					
					MarkBlock block = new MarkBlock(studentId, subjectId, midleMark, endMark, prevHash);
					arrayList.add(block);
				}
			}
		} catch (IOException e) {
		}	
		return arrayList;
	}
	
	
	public int SaveStudentBlockChain(ArrayList<Student> arrayList) {
		String content = "";
		for(int i=0; i<arrayList.size(); i++)
		{
			content += arrayList.get(i).ToJsonString();
			content += "\n";
		}
		WriteStringToFile(content, "", "StudentBlockChain.txt");
		return arrayList.size();
	}
	
	public ArrayList<Student> GetStudentBlockChain()
	{
		ArrayList<Student> arrayList = new ArrayList<>();
		try {
			File directory = new File(ORIGINAL_PATH + "");
			if (!directory.exists())
				directory.mkdirs();
			File file = new File(ORIGINAL_PATH + "\\" + "StudentBlockChain.txt");
			if (!file.exists())
				file.createNewFile();
			BufferedReader reader = new BufferedReader(new FileReader(ORIGINAL_PATH + "\\" + "StudentBlockChain.txt"));
			String str;

			while ((str = reader.readLine()) != null) {
				if (!str.equals("") && !str.equals("\n")) {
					Object obj = JSONValue.parse(str);
					JSONObject object = (JSONObject) obj;
					
					String name = (String) object.get("name");
					String id = (String) object.get("id");
					long birth = Long.parseLong(((Long) object.get("birth")).toString());
					String prevHash = (String) object.get("prevHash");
					
					Student student = new Student(name, birth, id, prevHash);
					arrayList.add(student);
				}
			}
		} catch (IOException e) {
		}	
		return arrayList;
	}
	
	
	public int SaveSubjectBlockChain(ArrayList<MSubject> arrayList) {
		String content = "";
		for(int i=0; i<arrayList.size(); i++)
		{
			content += arrayList.get(i).ToJsonString();
			content += "\n";
		}
		WriteStringToFile(content, "", "SubjectBlockChain.txt");
		return arrayList.size();
	}
	
	public ArrayList<MSubject> GetSubjectBlockChain()
	{
		ArrayList<MSubject> arrayList = new ArrayList<>();
		try {
			File directory = new File(ORIGINAL_PATH + "");
			if (!directory.exists())
				directory.mkdirs();
			File file = new File(ORIGINAL_PATH + "\\" + "SubjectBlockChain.txt");
			if (!file.exists())
				file.createNewFile();
			BufferedReader reader = new BufferedReader(new FileReader(ORIGINAL_PATH + "\\" + "SubjectBlockChain.txt"));
			String str;

			while ((str = reader.readLine()) != null) {
				if (!str.equals("") && !str.equals("\n")) {
					Object obj = JSONValue.parse(str);
					JSONObject object = (JSONObject) obj;
					
					String name = (String) object.get("name");
					String id = (String) object.get("id");
					String prevHash = (String) object.get("prevHash");
					
					MSubject subject = new MSubject(name, id, prevHash);
					arrayList.add(subject);
				}
			}
		} catch (IOException e) {
		}	
		return arrayList;
	}
	
}
