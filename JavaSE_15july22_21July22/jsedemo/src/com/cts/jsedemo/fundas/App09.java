package com.cts.jsedemo.fundas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App09 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("File Name: ");
		String fileName = scan.next();
		
		Path path = Paths.get(fileName);
		
		if(!Files.exists(path) || Files.isDirectory(path)) {
			System.out.println("The file is not found or is a folder");
		}else {
			try {
				List<String> lines = Files.readAllLines(path);
				lines.stream().forEach(System.out::println);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		
		scan.close();
	}
}
