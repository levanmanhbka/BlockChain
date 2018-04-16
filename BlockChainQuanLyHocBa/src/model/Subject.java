package model;

import common.HashUtil;

public class Subject {
	private String name;
	private String id;
	private String prevHash;
	
	public Subject(String name, String id, String prevHash) {
		this.name = name;
		this.id = id;
		this.prevHash = prevHash;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
		return HashUtil.applySha256(name + id + prevHash);
	}
}
