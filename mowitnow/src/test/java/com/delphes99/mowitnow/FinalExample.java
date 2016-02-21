package com.delphes99.mowitnow;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.delphes99.mowitnow.core.Garden;
import com.delphes99.mowitnow.parser.Parser;

public class FinalExample {
	@Test
	public void finalExample() throws Exception {
		List<String> fileLine = new ArrayList<String>();
		fileLine.add("5 5");
		fileLine.add("1 2 N");
		fileLine.add("GAGAGAGAA");
		fileLine.add("3 3 E");
		fileLine.add("AADAADADDA");
		Parser parser = new Parser(fileLine);
		Garden garden = parser.parse();
		assertEquals("1 3 N\n5 1 E", garden.activateAllMowers());
	}
}
