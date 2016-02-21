package com.delphes99.mowitnow.parser;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.delphes99.mowitnow.action.IMowerAction;
import com.delphes99.mowitnow.action.MowerActionFactory;
import com.delphes99.mowitnow.core.Direction;
import com.delphes99.mowitnow.core.Garden;
import com.delphes99.mowitnow.core.IMower;
import com.delphes99.mowitnow.core.Mower;
import com.delphes99.mowitnow.exception.GardenDimensionException;
import com.delphes99.mowitnow.exception.IllegalMowerActionException;
import com.delphes99.mowitnow.exception.InvalidDirectionException;
import com.delphes99.mowitnow.exception.MowerIllegalPositionException;
import com.delphes99.mowitnow.exception.ParserException;

public class Parser {
	// Garden, Ex : "5 5"
	private static final Pattern REGEX_GARDEN = Pattern.compile("^([0-9]+) ([0-9]+)$");
	// Mower, Ex : "1 2 N"
	private static final Pattern REGEX_MOWER = Pattern.compile("^([0-9]+) ([0-9]+) ([NESW])$");
	// Mower action, Ex : "AGDA"
	private static final Pattern REGEX_MOWER_ACTION = Pattern.compile("^([AGD]*)$");

	private List<String> fileLine;

	public Parser(List<String> fileLine) {
		this.fileLine = fileLine;
	}

	public Garden parse() throws ParserException {
		Garden garden = parseGarden(fileLine.remove(0));

		if (fileLine.size() % 2 != 0) {
			throw new ParserException("mower definition incomplete");
		}

		while (!fileLine.isEmpty()) {
			IMower mower = parseMower(fileLine.remove(0), garden);
			parseAction(fileLine.remove(0), mower);
		}

		return garden;
	}

	public Garden parseGarden(String input) throws ParserException {
		Matcher matcher = REGEX_GARDEN.matcher(input);
		if (matcher.find()) {
			int max_x = Integer.parseInt(matcher.group(1));
			int max_y = Integer.parseInt(matcher.group(2));

			try {
				return new Garden(max_x, max_y);
			} catch (GardenDimensionException e) {
				throw new ParserException("invalid garden dimension", e);
			}
		} else {
			throw new ParserException("invalid garden format");
		}
	}

	public IMower parseMower(String input, Garden garden) throws ParserException {
		Matcher matcher = REGEX_MOWER.matcher(input);
		if (matcher.find()) {
			int x = Integer.parseInt(matcher.group(1));
			int y = Integer.parseInt(matcher.group(2));
			Direction direction;
			try {
				direction = Direction.getDirectionById(matcher.group(3));
			} catch (InvalidDirectionException e) {
				// impossible : filter by regex
				throw new ParserException("invalid mower direction", e);
			}

			try {
				Mower mower = new Mower(garden, x, y, direction);
				garden.addMower(mower);
				return mower;
			} catch (MowerIllegalPositionException e) {
				throw new ParserException("invalid mower position", e);
			}
		} else {
			throw new ParserException("invalid mower format");
		}
	}

	public Queue<IMowerAction> parseAction(String input, IMower mower) throws ParserException {
		Queue<IMowerAction> queueAction = new LinkedList<IMowerAction>();
		Matcher matcher = REGEX_MOWER_ACTION.matcher(input);
		if (matcher.find()) {
			try {
				for (char actionKey : matcher.group(1).toCharArray()) {
					IMowerAction mowerAction = MowerActionFactory.getMowerAction(Character.toString(actionKey));
					mower.addAction(mowerAction);
					queueAction.add(mowerAction);
				}
			} catch (IllegalMowerActionException e) {
				// impossible : filter by regex
				throw new ParserException("invalid mower action", e);
			}
			return queueAction;
		} else {
			throw new ParserException("invalid mower action format");
		}
	}
}
