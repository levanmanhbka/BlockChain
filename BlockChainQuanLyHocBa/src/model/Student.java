package model;

import org.json.simple.JSONObject;

import common.HashUtil;

public class Student {
	private String name;
	private long birth;
	private String id;
	private String prevHash;
	
	public Student(String name, long birth, String id, String prevHash) {
		this.name = name;
		this.birth = birth;
		this.id = id;
		this.prevHash = prevHash;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getBirth() {
		return birth;
	}
	public void setBirth(long birth) {
		this.birth = birth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrevHash() {
		return prevHash;
	}
	public void setPrevHash(String prevHash) {
		this.prevHash = prevHash;
	}
	
	public String toHashString()
	{
		return HashUtil.applySha256(name + id + birth+ prevHash);
	}
	public String ToJsonString() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("id", id);
		jsonObject.put("birth", new Long(birth));
		jsonObject.put("prevHash", prevHash);
		return jsonObject.toString();
	}
}
