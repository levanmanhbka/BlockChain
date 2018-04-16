package main;

import java.security.PublicKey;
import java.util.Date;

public class Certificate {

	public Date date;
	public String studentName;
	public String universityName;
	public String course;
	public PublicKey publicKey;
	
	@Override
	public String toString() {
		String str = "Certificate of Completion\n";
		str += "This certificate is awarded to\n" + studentName + "\n";
		str += "For completion of the\n" + course;
		str += " given by " + universityName + " on " + date + "\n";
		if (publicKey != null) {
			str += "Public key: " + StringUtil.getStringFromKey(publicKey) + "";
		}
		return str;
	}
	
	

}
