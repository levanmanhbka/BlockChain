package common;

import java.security.MessageDigest;
import java.util.ArrayList;

import model.MSubject;
import model.MarkBlock;
import model.Student;

public class HashUtil {
	public static String applySha256(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer(); // This will contain hash as hex decimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) {

		}
		return null;
	}

	public static boolean isMarkBlockChainValid(ArrayList<MarkBlock> blockChain) {
		if (blockChain.size() > 1) {
			for (int i = 1; i <= blockChain.size() - 1; i++) {
				MarkBlock currentBlock = blockChain.get(i - 1);
				MarkBlock nextBlock = blockChain.get(i);
				if (!(nextBlock.getPrevHash().equals(currentBlock.toHashString()))) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isStudentBlockChainValid(ArrayList<Student> blockChain) {
		if (blockChain.size() > 1) {
			for (int i = 1; i <= blockChain.size() - 1; i++) {
				Student currentBlock = blockChain.get(i - 1);
				Student nextBlock = blockChain.get(i);
				if (!(nextBlock.getPrevHash().equals(currentBlock.toHashString()))) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isSubjectBlockChainValid(ArrayList<MSubject> blockChain) {
		if (blockChain.size() > 1) {
			for (int i = 1; i <= blockChain.size() - 1; i++) {
				MSubject currentBlock = blockChain.get(i - 1);
				MSubject nextBlock = blockChain.get(i);
				if (!(nextBlock.getPrevHash().equals(currentBlock.toHashString()))) {
					return false;
				}
			}
		}
		return true;
	}
}
