package decoding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pairs.StatisticPair;

public class EncryptedTextStatistic {
	
	Alphabet alphabet = new Alphabet();
	private String encryptedText;
	private float countChars;
	
	private List<StatisticPair> topFirstOrder = new ArrayList<StatisticPair>();
	private List<StatisticPair> topSecondOrder = new ArrayList<StatisticPair>();
	private List<StatisticPair> topThirdOrder = new ArrayList<StatisticPair>();
	/*private HashMap<String, Float> topFirstOrder = new HashMap<String, Float>();
	private HashMap<String, Float> topSecondOrder = new HashMap<String, Float>();
	private HashMap<String, Float> topThirdOrder = new HashMap<String, Float>();*/
	
	public EncryptedTextStatistic(String encryptedText){
		this.encryptedText = encryptedText;
		countChars = encryptedText.length();
		countStatisticForFirstOrder();
		countStatisticForSecondOrder();
		countStatisticForThirdOrder();
	}
	
	private void countStatisticForFirstOrder(){
		Iterator<String> iterator = alphabet.getFirstOrderIterator();
		while(iterator.hasNext()){
			String subString = iterator.next();
			Pattern p = Pattern.compile(subString);
			Matcher m = p.matcher(encryptedText);
			int repeats = 0;
			while (m.find()){
				repeats +=1;
			}
			if(repeats!=0){
				//topFirstOrder.add(subString, repeats/countChars);
				topFirstOrder.add(new StatisticPair(subString, repeats/countChars));
			}
		}
		
	}
	
	private void countStatisticForSecondOrder(){
		Iterator<String> iterator = alphabet.getSecondOrderIterator();
		while(iterator.hasNext()){
			String subString = iterator.next();
			Pattern p = Pattern.compile(subString);
			Matcher m = p.matcher(encryptedText);
			int repeats = 0;
			while (m.find()){
				repeats +=1;
			}
			if(repeats!=0){
				topSecondOrder.add(new StatisticPair(subString, repeats/countChars));
			}
		}
		
	}
	
	private void countStatisticForThirdOrder(){
		Iterator<String> iterator = alphabet.getThirdOrderIterator();
		while(iterator.hasNext()){
			String subString = iterator.next();
			Pattern p = Pattern.compile(subString);
			Matcher m = p.matcher(encryptedText);
			int repeats = 0;
			while (m.find()){
				repeats +=1;
			}
			if(repeats!=0){
				topThirdOrder.add(new StatisticPair(subString, repeats/countChars));
			}
		}
		
	}
	
	
	public List<StatisticPair> getFirstOrderStatistic(){
		Collections.sort(topFirstOrder, new Comparator<StatisticPair>() {
			@Override
			public int compare(StatisticPair arg0, StatisticPair arg1) {
				return arg0.getValue().compareTo(arg1.getValue());
			}
		});
		Collections.reverse(topFirstOrder);
		return topFirstOrder;
	}
	
	public List<StatisticPair> getSecondOrderStatistic(){
		Collections.sort(topSecondOrder, new Comparator<StatisticPair>() {
			@Override
			public int compare(StatisticPair arg0, StatisticPair arg1) {
				return arg0.getValue().compareTo(arg1.getValue());
			}
		});
		Collections.reverse(topSecondOrder);
		return topSecondOrder;
	}
	
	public List<StatisticPair> getThirdOrderStatistic(){
		Collections.sort(topThirdOrder, new Comparator<StatisticPair>() {
			@Override
			public int compare(StatisticPair arg0, StatisticPair arg1) {
				return arg0.getValue().compareTo(arg1.getValue());
			}
		});
		Collections.reverse(topThirdOrder);
		return topThirdOrder;
	}
	
	
}
