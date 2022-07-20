package com.cts.jsedemo.fundas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App08 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("File Name: ");
		String fileName = scan.next();
		
		Path path = Paths.get(fileName);
		
		List<String> lines = new ArrayList<String>();
		
		String line="";
		
		System.out.println("Enter data and use '@STOP' to stop: ");
		while(!"@STOP".equals(line)) {
			line = scan.nextLine();
			if(!"@STOP".equals(line))
				lines.add(line);
		}
		
		try {
			Files.write(path, lines);
			System.out.println("File got saved!");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		scan.close();
	}
}
