package com.delphes99.mowitnow;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GardenTest.class, DirectionTest.class, MowerPositionTest.class, MowerTest.class, MowerActionTest.class,
		MowerProgrammTest.class, GardenProgrammTest.class, ParserTest.class, FinalExample.class })
public class AllTest {

}
