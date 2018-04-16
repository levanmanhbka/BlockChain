package model;

import org.json.simple.JSONObject;

import common.HashUtil;

public class MarkBlock {
	private String studentId;
	private String subjectId;
	private double midleMark;
	private double endMark;
	private String prevHash;
	
	
	
	public MarkBlock(String studentId, String subjectId, double midleMark, double endMark, String prevHash) {
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.midleMark = midleMark;
		this.endMark = endMark;
		this.prevHash = prevHash;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public double getMidleMark() {
		return midleMark;
	}
	public void setMidleMark(double midleMark) {
		this.midleMark = midleMark;
	}
	public double getEndMark() {
		return endMark;
	}
	public void setEndMark(double endMark) {
		this.endMark = endMark;
	}
	public String getPrevHash() {
		return prevHash;
	}
	public void setPrevHash(String prevHash) {
		this.prevHash = prevHash;
	}
	
	public String toHashString()
	{
		return HashUtil.applySha256(studentId + subjectId + midleMark + endMark + prevHash);
	}
	
	public String ToJsonString() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("studentId", studentId);
		jsonObject.put("subjectId", subjectId);
		jsonObject.put("midleMark", new Double(midleMark));
		jsonObject.put("endMark", new Double(endMark));
		jsonObject.put("prevHash", prevHash);
		return jsonObject.toString();
	}	
}
