package com.megha.certification.problemSolving.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class VowelSubString {
	public static String findSubstring(String s, int k) {
		String result = "Not Found!";
		String checkString="";
		int max = 0;
		if(k>0 && k<=s.length())
		{
			int beginIndex=0;
			while(beginIndex+k<=s.length())
			{
				checkString= s.substring(beginIndex, beginIndex+k);
				int vowelSum= getNumberOfVowel(checkString);
				if(vowelSum==k)
				{
					result = checkString;
					break;
				}
				else if(vowelSum > max)
				{
					max = vowelSum;
					result = checkString;

				}
				beginIndex++;
			}
		}
		return result;

	}
	private static int getNumberOfVowel(String checkString) {
		 int vowels = 0;
		 checkString = checkString.toLowerCase();
	        for(int i = 0; i < checkString.length()/2; i++)
	        {
	            char ch = checkString.charAt(i);
	            char ch1 = checkString.charAt(checkString.length()-i-1);
	            if(ch == 'a' || ch == 'e' || ch == 'i'
	                || ch == 'o' || ch == 'u') {
	                ++vowels;
	            }
	            if(ch1 == 'a' || ch1 == 'e' || ch1 == 'i'
		                || ch1 == 'o' || ch1 == 'u') {
		                ++vowels;
		            }
	           
	        }
	        if(checkString.length()%2!=0)
	        {
	        	int i = (checkString.length()/2) +1;
	        	char ch = checkString.charAt(i);
	            if(ch == 'a' || ch == 'e' || ch == 'i'
	                || ch == 'o' || ch == 'u') {
	                ++vowels;
	            }
	        }
	        System.out.println(checkString + " ---> "+ vowels);
		return vowels;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String s = bufferedReader.readLine();

		int k = Integer.parseInt(bufferedReader.readLine().trim());

		String result = VowelSubString.findSubstring(s, k);

		System.out.println(result);

		bufferedReader.close();

	}

}
