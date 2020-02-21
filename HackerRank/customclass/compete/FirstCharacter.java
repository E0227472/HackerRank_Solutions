package com.capgemini.compete;

public class FirstCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		System.out.println();
	}
	
	 public static String solution(String s) {
	        char c = s.charAt(0);
	        if (Character.isUpperCase(c)) {  // please fix condition
	            return "upper";
	        } else if (Character.isLowerCase(c)) {  // please fix condition
	            return "lower";
	        } else if (Character.isDigit(c)) {  // please fix condition
	            return "digit";
	        } else {
	            return "other";
	        }
	    }

}
