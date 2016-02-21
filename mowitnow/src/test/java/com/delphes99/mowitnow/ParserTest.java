package com.delphes99.mowitnow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import com.delphes99.mowitnow.action.IMowerAction;
import com.delphes99.mowitnow.core.Direction;
import com.delphes99.mowitnow.core.Garden;
import com.delphes99.mowitnow.core.IMower;
import com.delphes99.mowitnow.core.Mower;
import com.delphes99.mowitnow.exception.ParserException;
import com.delphes99.mowitnow.parser.Parser;

public class ParserTest {
	private Parser defaultParser;

	@Before
	public void initializeParser() {
		defaultParser = new Parser(new ArrayList<String>());
	}

	/***************************** Garden *****************************/
	@Test(expected = ParserException.class)
	public void should_throw_exception_when_reading_invalid_garden_definition() throws Exception {
		defaultParser.parseGarden("aaaaa");
	}

	@Test
	public void should_create_garden_when_valid_garden_definition() throws Exception {
		Garden garden = defaultParser.parseGarden("5 6");
		assertEquals(5, garden.getWidth());
		assertEquals(6, garden.getHeight());
	}

	@Test
	public void should_create_garden_when_valid_garden_definition_2_number() throws Exception {
		Garden garden = defaultParser.parseGarden("11 12");
		assertEquals(11, garden.getWidth());
		assertEquals(12, garden.getHeight());
	}

	@Test(expected = ParserException.class)
	public void should_throw_exception_when_reading_invalid_garden_dimension() throws Exception {
		defaultParser.parseGarden("0 6");
	}

	/***************************** Mower *****************************/
	@Test(expected = ParserException.class)
	public void should_throw_exception_when_reading_invalid_mower_definition() throws Exception {
		defaultParser.parseMower("aaaaa", new Garden(5, 5));
	}

	@Test
	public void should_create_mower_when_valid_garden_definition() throws Exception {
		IMower mower = defaultParser.parseMower("1 2 N", new Garden(5, 5));
		assertEquals(1, mower.getPosition().getCoordinates().getX());
		assertEquals(2, mower.getPosition().getCoordinates().getY());
		assertEquals(Direction.NORTH, mower.getPosition().getDirection());
	}

	@Test(expected = ParserException.class)
	public void should_throw_exception_when_reading_invalid_mower_position() throws Exception {
		defaultParser.parseMower("12 12 N", new Garden(5, 5));
	}

	@Test(expected = ParserException.class)
	public void should_throw_exception_when_reading_invalid_mower_direction() throws Exception {
		defaultParser.parseMower("1 1 X", new Garden(5, 5));
	}

	@Test
	public void should_add_mower_to_the_garden_when_valid_garden_definition() throws Exception {
		Garden garden = new Garden(5, 5);
		assertEquals(0, garden.getNumberOfMowers());
		defaultParser.parseMower("1 2 N", garden);
		assertEquals(1, garden.getNumberOfMowers());
	}

	/***************************** Action *****************************/
	@Test(expected = ParserException.class)
	public void should_throw_exception_when_reading_invalid_action_definition() throws Exception {
		IMower mower = new Mower(new Garden(5, 5), 0, 0, Direction.NORTH);
		defaultParser.parseAction("aaaaa", mower);
	}

	@Test
	public void should_create_no_action_when_empty_action_definition() throws Exception {
		IMower mower = new Mower(new Garden(5, 5), 0, 0, Direction.NORTH);
		Queue<IMowerAction> queue = defaultParser.parseAction("", mower);
		assertEquals(0, queue.size());
	}

	@Test
	public void should_create_action_when_valid_action_definition() throws Exception {
		IMower mower = new Mower(new Garden(5, 5), 0, 0, Direction.NORTH);
		Queue<IMowerAction> queue = defaultParser.parseAction("A", mower);
		assertEquals(1, queue.size());
	}

	@Test
	public void should_create_multiple_action_when_valid_action_definition() throws Exception {
		IMower mower = new Mower(new Garden(5, 5), 0, 0, Direction.NORTH);
		Queue<IMowerAction> queue = defaultParser.parseAction("AGD", mower);
		assertEquals(3, queue.size());
	}

	@Test
	public void should_add_action_to_the_mower_when_valid_action_definition() throws Exception {
		IMower mower = new Mower(new Garden(5, 5), 0, 0, Direction.NORTH);
		assertEquals(0, mower.getActionQueueSize());
		defaultParser.parseAction("AGD", mower);
		assertEquals(3, mower.getActionQueueSize());
	}

	/***************************** Entire file *****************************/
	@Test(expected = ParserException.class)
	public void should_throw_exception_when_garden_is_not_header() throws Exception {
		ArrayList<String> fileLine = new ArrayList<String>();
		fileLine.add("5 5 N");
		fileLine.add("AGGD");
		fileLine.add("5 5");
		Parser parser = new Parser(fileLine);
		parser.parse();
	}

	@Test
	public void should_add_garden_when_only_garden_definition() throws Exception {
		ArrayList<String> fileLine = new ArrayList<String>();
		fileLine.add("5 5");
		Parser parser = new Parser(fileLine);
		Garden garden = parser.parse();
		assertNotNull(garden);
	}

	@Test(expected = ParserException.class)
	public void should_throw_exception_when_mower_definition_is_incomplete() throws Exception {
		ArrayList<String> fileLine = new ArrayList<String>();
		fileLine.add("5 5");
		fileLine.add("5 5 N");
		Parser parser = new Parser(fileLine);
		parser.parse();
	}

	@Test
	public void should_add_mower() throws Exception {
		ArrayList<String> fileLine = new ArrayList<String>();
		fileLine.add("5 5");
		fileLine.add("5 5 N");
		fileLine.add("");
		Parser parser = new Parser(fileLine);
		Garden garden = parser.parse();
		assertEquals(1, garden.getNumberOfMowers());
	}

	@Test
	public void should_add_mower_and_action() throws Exception {
		ArrayList<String> fileLine = new ArrayList<String>();
		fileLine.add("5 5");
		fileLine.add("5 5 N");
		fileLine.add("GDGDAA");
		Parser parser = new Parser(fileLine);
		Garden garden = parser.parse();
		assertEquals(1, garden.getNumberOfMowers());
	}
}
