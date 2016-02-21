package com.delphes99.mowitnow;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GardenTest.class, DirectionTest.class, MowerPositionTest.class, MowerTest.class,
		MowerActionTest.class })
public class AllTest {

}
