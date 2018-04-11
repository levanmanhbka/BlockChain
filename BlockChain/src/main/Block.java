/**
 * 
 */
package main;

import java.util.Date;

/**
 * @author ManhLV
 *
 */
public class Block {
	public String currentHash;
	public String previousHash;
	public String data;
	public long timeStamp;

	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.currentHash = HashUtil.applySha256(this.previousHash + Long.toString(this.timeStamp) + this.data);
	}

	public String calculateHash() {
		String calculatedhash = HashUtil.applySha256(this.previousHash + Long.toString(this.timeStamp) + this.data);
		return calculatedhash;
	}
	
	public String blockToString() {
		return "{"
				+ "\n"+ this.previousHash
				+ "\n"+ this.currentHash
				+ "\n"+ this.timeStamp
				+"\n" + this.data
				+"\n}";
	}
}
