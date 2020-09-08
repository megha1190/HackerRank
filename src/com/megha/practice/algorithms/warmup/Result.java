package com.megha.practice.algorithms.warmup;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Result {

	/*
	 * Complete the 'birthdayCakeCandles' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts INTEGER_ARRAY candles as parameter.
	 */

	public static int birthdayCakeCandles(List<Integer> candles) {
		int result = 0;
		Map<Integer, Integer> candleMap = new HashMap<Integer, Integer>();
		if(candles.size()>0)
		{
				
			for(Integer candleInput:candles)
			{
				if(candleMap.containsKey(candleInput))
				{
					int count = candleMap.get(candleInput);
					candleMap.put(candleInput, ++count);
					
				}
				else
					candleMap.put(candleInput, 1);
			}
			int maxKey = Collections.max(candleMap.keySet());
			result= candleMap.get(maxKey);
		}
		return result;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());
		List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		int result = Result.birthdayCakeCandles(candles);

		System.out.println(result);

		bufferedReader.close();

	}
}
