/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author ManhLV
 *
 */

public class Main {
	public static void main(String[] args) {
		ArrayList<Block> blockChain = new ArrayList<>();
		Block block1 = new Block("First Block", "0");
		blockChain.add(block1);
		Block block2 = new Block("Second Block", block1.currentHash);
		blockChain.add(block2);
		Block block3 = new Block("Third Block", block2.currentHash);
		blockChain.add(block3);

		for (Block b : blockChain) {
			System.out.println(b.blockToString());
		}
		
		System.out.println("check valid: " + isBlockChainValid(blockChain));
	}

	private static boolean isBlockChainValid(ArrayList<Block> blockChain) {
		if (blockChain.size() > 1) {
			for (int i = 1; i < blockChain.size(); i++) {
				Block currentBlock = blockChain.get(i - 1);
				Block nextBlock = blockChain.get(i);
				if (!(nextBlock.previousHash.equals(currentBlock.currentHash))) {
					return false;
				}
			}
		}
		return true;
	}
}
