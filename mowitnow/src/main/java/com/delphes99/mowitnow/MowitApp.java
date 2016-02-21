package com.delphes99.mowitnow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.delphes99.mowitnow.core.Garden;
import com.delphes99.mowitnow.exception.FileException;
import com.delphes99.mowitnow.exception.ParserException;
import com.delphes99.mowitnow.parser.Parser;

public class MowitApp {
	public static void main(String[] args) throws FileException, FileNotFoundException, ParserException {
		if (args == null || args.length == 0) {
			throw new FileException("filename is mandatory");
		}
		List<String> fileLines = readFile(args);

		Parser parser = new Parser(fileLines);
		Garden garden = parser.parse();

		System.out.println(garden.activateAllMowers());
	}

	private static List<String> readFile(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);

		List<String> fileLines = new ArrayList<String>();
		while (scanner.hasNextLine()) {
			fileLines.add(scanner.nextLine());
		}

		scanner.close();

		return fileLines;
	}
}
