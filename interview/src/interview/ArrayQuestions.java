package interview;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class ArrayQuestions {

	public static Boolean isUnique(String str) {
		Hashtable<Character, Boolean> hash = new Hashtable<Character, Boolean>();
		for (int i = 0; i < str.length(); i ++){
			if (hash.get(str.charAt(i)) != null){
				return false;
			}
			hash.put(str.charAt(i), true);
		}
		return true;
	}
	
	public static Boolean isPermutation(String a, String b){
		Hashtable<Character, Integer> hashForA, hashForB;
		
		if (a.length() != b.length()) {
			return false;
		}
		
		hashForA = new Hashtable<Character, Integer>();
		hashForB = new Hashtable<Character, Integer>();

		for (int i=0; i< a.length(); i++){
			ifExistsPlus1(a.charAt(i), hashForA);
			ifExistsPlus1(b.charAt(i), hashForB);
		}

		if (hashForA.equals(hashForB)){
			return true;
		}
		return false;
	}
	
	public static void ifExistsPlus1(char character, Hashtable<Character, Integer> table){
		if (table.get(character) == null){
			table.put(character, 1);
		}
		else{
			table.put(character, table.get(character) + 1);
		}
	}
	
	public static void URLify(char[] str, int length){
		int numOfSpace = 0, totalLength = 0;
		for (int i=0; i<length; i++){
			if (str[i] == ' '){
				numOfSpace++;
			} 
		}
		totalLength = length + numOfSpace * 2;
		str[totalLength] = '\0';
		for (int i=length-1; i>=0; i--){
			if (str[i] == ' '){
				str[totalLength-1] = '0';
				str[totalLength-2] = '2';
				str[totalLength-3] = '%';
				totalLength -= 3;
			}
			else{
				str[totalLength-1] = str[i];
				totalLength -= 1;
			}
		} 
		System.out.println(str);
	}
	
	public static void isPalindromePermutation(String str){
		str = str.replaceAll("\\s+","");
		str = str.toLowerCase();
		Hashtable<Character, Integer> count = new Hashtable<Character, Integer>();
		for (int i=0; i<str.length(); i++){
			if (count.containsKey(str.charAt(i))){
				count.put(str.charAt(i), count.get(str.charAt(i)) + 1);
			}
			else{
				count.put(str.charAt(i), 1);
			}
		}
		Set<Character> keys = count.keySet();
		int numOfOdd = 0;
		for(Character ch:keys){
			if (count.get(ch)%2 != 0){
				numOfOdd++;
			}
		}
		System.out.println(count.toString());
		System.out.println(numOfOdd);
		if (numOfOdd > 1){
			System.out.println("False");
			return;
		}
		System.out.println("True");
	}
	public static void main(String[] args){
		isPalindromePermutation("Animal loots foliated detail of stool lamina");
	}
}
