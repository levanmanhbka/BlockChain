package main;
import java.security.*;
import java.util.ArrayList;

public class Transaction {
	
	public String transactionId; //Contains a hash of transaction*
	public PublicKey sender; //Senders address/public key.
	public PublicKey reciepient; //Recipients address/public key.
	public Certificate value; //Contains the amount we wish to send to the recipient.
	public byte[] signature; //This is to prevent anybody else from spending funds in our wallet.
	
	public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
	public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();
	
	private static int sequence = 0; //A rough count of how many transactions have been generated 
	
	// Constructor: 
	public Transaction(PublicKey from, PublicKey to, Certificate value,  ArrayList<TransactionInput> inputs) {
		this.sender = from;
		this.reciepient = to;
		this.value = value;
		this.inputs = inputs;
	}
	
	public boolean processTransaction() {
		
		if(verifySignature() == false) {
			System.out.println("#Transaction Signature failed to verify");
			return false;
		}
				
		//Gathers transaction inputs (Making sure they are unspent):
		for(TransactionInput i : inputs) {
			i.UTXO = NoobChain.UTXOs.get(i.transactionOutputId);
		}
		
		//Generate transaction outputs:
		
		transactionId = calulateHash();
		outputs.add(new TransactionOutput( this.reciepient, value,transactionId)); //send value to recipient	
		outputs.add(new TransactionOutput( this.sender, value,transactionId));
				
		//Add outputs to Unspent list
		for(TransactionOutput o : outputs) {
			NoobChain.UTXOs.put(o.id , o);
		}
		
		//Remove transaction inputs from UTXO lists as spent:
		for(TransactionInput i : inputs) {
			if(i.UTXO == null) continue; //if Transaction can't be found skip it 
			NoobChain.UTXOs.remove(i.UTXO.id);
		}
		
		return true;
	}
	
	public void generateSignature(PrivateKey privateKey) {
		String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + value.toString()	;
		signature = StringUtil.applyECDSASig(privateKey,data);		
	}
	
	public boolean verifySignature() {
		String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + value.toString()	;
		return StringUtil.verifyECDSASig(sender, data, signature);
	}
	
	private String calulateHash() {
		sequence++; //increase the sequence to avoid 2 identical transactions having the same hash
		return StringUtil.applySha256(
				StringUtil.getStringFromKey(sender) +
				StringUtil.getStringFromKey(reciepient) +
				value.toString() + sequence
				);
	}
}
