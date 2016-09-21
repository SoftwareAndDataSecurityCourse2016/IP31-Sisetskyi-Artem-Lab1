package decoding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pairs.EncryptedDecryptedPair;
import pairs.StatisticPair;

public class Decoder {
	
	public static final int TOP_COUNT = 29;
	
	private String encryptedText;
	private EncryptedTextStatistic encryptedTextStatistic;
	private List<EncryptedDecryptedPair> decryptedData = new ArrayList<EncryptedDecryptedPair>();
	
	public Decoder(String encryptedText){
		this.encryptedText = encryptedText;
		encryptedTextStatistic = new EncryptedTextStatistic(encryptedText);
		printFirstOrder();
		printSecondOrder();
		printThirdOrder();
	}
	
	public void addDecodeChar(String encryptedChar, String decryptedChar){
		if(Character.isUpperCase(decryptedChar.charAt(0)) && Character.isLowerCase(encryptedChar.charAt(0))){
			decryptedData.add(new EncryptedDecryptedPair(decryptedChar, encryptedChar));
		} else {
			decryptedData.add(new EncryptedDecryptedPair(encryptedChar, decryptedChar));
		}	
	}
	
	public void removeDecodeChar(String charToRemove){
		Iterator<EncryptedDecryptedPair> iterator = decryptedData.iterator();
		while(iterator.hasNext()){
			EncryptedDecryptedPair pair = iterator.next();
			if(pair.getDecryptedChar().equals(charToRemove) || pair.getEncryptedChar().equals(charToRemove)){
				iterator.remove();
				System.out.println("Remove successfully");
				return;
			}
		}
		System.out.println("Char not found");
	}
	
	public void printEncryptedTextWithDecryptedChars(){
		String currEncryptedTextWithDecryptedChars = encryptedText;
		for(EncryptedDecryptedPair pair : decryptedData) {
			currEncryptedTextWithDecryptedChars = currEncryptedTextWithDecryptedChars.replaceAll(pair.getEncryptedChar(), pair.getDecryptedChar());
		}
		System.out.println(currEncryptedTextWithDecryptedChars);
	}
	
	public void printFirstOrder(){
		printList(encryptedTextStatistic.getFirstOrderStatistic());
	}
	
	public void printSecondOrder(){
		printList(encryptedTextStatistic.getSecondOrderStatistic());
	}
	
	public void printThirdOrder(){
		printList(encryptedTextStatistic.getThirdOrderStatistic());
	}
	
	public void printDecryptedData(){
		for(EncryptedDecryptedPair pair : decryptedData){
			System.out.println(pair.getEncryptedChar() + " -> " + pair.getDecryptedChar());
		}
	}
	
	private void printList(List<StatisticPair> list) {
		int countOfPrint = 0;
		for(StatisticPair temp : list){
			countOfPrint++;
			System.out.println(temp.getChar() + " = " + getDecryptedCharsByEncrypteds(temp.getChar()) +  " = " + temp.getValue());
			if (countOfPrint == TOP_COUNT) {
				return;
			}
		}	
	}
	
	private String getDecryptedCharsByEncrypteds(String chars) {
		char[] encryptedChars = chars.toCharArray();
		String result = "";
		for(int i=0; i < encryptedChars.length; i++){
			result+=getDecryptedChar(""+encryptedChars[i]);
		}
		return result;
	}
	
	private String getDecryptedChar(String encryptedChar) {
		for(EncryptedDecryptedPair pair : decryptedData){
			if(pair.getEncryptedChar().equals(encryptedChar)){
				return pair.getDecryptedChar();
			}
		}
		return ".";
	}
	
}
