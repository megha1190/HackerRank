package com.megha.certification.problemSolving.basic;


import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
public class RoadRepair {
	public static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {
		int sum=0;
		Collections.sort(crew_id);
		Collections.sort(job_id);
		for(int i=0;i<job_id.size();i++)
		{
			sum = sum+ Math.abs(crew_id.get(i)-job_id.get(i));
		}
		return sum;
	}

	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


		int crew_idCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> crew_id = IntStream.range(0, crew_idCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(toList());

		int job_idCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> job_id = IntStream.range(0, job_idCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(toList());

		long result = RoadRepair.getMinCost(crew_id, job_id);

		System.out.println(String.valueOf(result));

		bufferedReader.close();
	}
}
