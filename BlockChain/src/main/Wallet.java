package main;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wallet {
	
	public PrivateKey privateKey;
	public PublicKey publicKey;
	
	public HashMap<String,TransactionOutput> UTXOs = new HashMap<String,TransactionOutput>();
	
	public Wallet() {
		generateKeyPair();
	}
		
	public void generateKeyPair() {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
			// Initialize the key generator and generate a KeyPair
			keyGen.initialize(ecSpec, random); //256 
	        KeyPair keyPair = keyGen.generateKeyPair();
	        // Set the public and private keys from the keyPair
	        privateKey = keyPair.getPrivate();
	        publicKey = keyPair.getPublic();
	        
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Certificate> getBalance() {
		ArrayList<Certificate> total = new ArrayList<Certificate>();
        for (Map.Entry<String, TransactionOutput> item: NoobChain.UTXOs.entrySet()){
        	TransactionOutput UTXO = item.getValue();
            if(UTXO.isMine(publicKey)) { //if output belongs to me ( if coins belong to me )
            	UTXOs.put(UTXO.id,UTXO); //add it to our list of unspent transactions.
            	total.add(UTXO.value); 
            }
        }          
		return total;
	}
	
	public Transaction sendFunds(PublicKey _recipient, Certificate value ) {		
		ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
		value.publicKey = publicKey;
		
		Transaction newTransaction = new Transaction(publicKey, _recipient , value, inputs);
		newTransaction.generateSignature(privateKey);		
		
		for(TransactionInput input: inputs){
			UTXOs.remove(input.transactionOutputId);
		}
		
		return newTransaction;
	}
	
}


