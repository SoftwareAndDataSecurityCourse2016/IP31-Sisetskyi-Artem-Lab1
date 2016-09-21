package decoding;
import java.util.Iterator;

public class Alphabet{
	public static char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
	
	private final String TWO_LAST_CHAR_IN_ALPHABET = "" + ALPHABET[ALPHABET.length-1] + ALPHABET[ALPHABET.length-1];
	private final String THREE_LAST_CHAR_IN_ALPHABET = "" + ALPHABET[ALPHABET.length-1] + ALPHABET[ALPHABET.length-1] + ALPHABET[ALPHABET.length-1];
	
	public Iterator<String> getFirstOrderIterator(){
		return new Iterator<String>() {
			int currIndex = 0;
			@Override
			public boolean hasNext() {
				if(currIndex == ALPHABET.length ){
					return false;
				} else {
					return true;
				}
			}

			@Override
			public String next() {
				String currOrder = "" + ALPHABET[currIndex];
				currIndex++;
				return currOrder;
			}
		};
	}
	
	public Iterator<String> getSecondOrderIterator(){
		return new Iterator<String>() {
			String currSequence = "";
			int firstCharIndex = 0;
			int secondCharIndex = 0;
			@Override
			public boolean hasNext() {
				if(currSequence.equals(TWO_LAST_CHAR_IN_ALPHABET)){
					return false;
				} else {
					return true;
				}
			}

			@Override
			public String next() {
				if(secondCharIndex == ALPHABET.length){
					firstCharIndex++;
					secondCharIndex=0;
				}
				currSequence = "" + ALPHABET[firstCharIndex] + ALPHABET[secondCharIndex];
				secondCharIndex++;
				return currSequence;
			}
		};
	}
	
	public Iterator<String> getThirdOrderIterator(){
		return new Iterator<String>() {
			String currSequence = "";
			int firstCharIndex = 0;
			int secondCharIndex = 0;
			int thirdCharIndex = 0;
			@Override
			public boolean hasNext() {
				if(currSequence.equals(THREE_LAST_CHAR_IN_ALPHABET)){
					return false;
				} else {
					return true;
				}
			}

			@Override
			public String next() {
				if(thirdCharIndex == ALPHABET.length){
					secondCharIndex++;
					thirdCharIndex=0;
				}
				if(secondCharIndex == ALPHABET.length){
					firstCharIndex++;
					secondCharIndex=0;
					thirdCharIndex=0;
				}
				currSequence = "" + ALPHABET[firstCharIndex] + ALPHABET[secondCharIndex] + ALPHABET[thirdCharIndex];
				thirdCharIndex++;
				return currSequence;
			}
		};
	}

}
