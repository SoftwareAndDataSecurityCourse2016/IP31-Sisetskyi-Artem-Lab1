package pairs;

public class EncryptedDecryptedPair {
	private String encryptedChar;
	private String decryptedChar;

	public EncryptedDecryptedPair(String encryptedChar, String decryptedChar){
	        this.encryptedChar = encryptedChar;
	        this.decryptedChar = decryptedChar;
	    }

	public String getEncryptedChar() {
		return encryptedChar;
	}

	public String getDecryptedChar() {
		return decryptedChar;
	}

	public void setEncryptedChar(String ch) {
		this.encryptedChar = ch;
	}

	public void setDecryptedChar(String ch) {
		this.decryptedChar = ch;
	}
}
