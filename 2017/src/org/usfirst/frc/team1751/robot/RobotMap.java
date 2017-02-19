package org.usfirst.frc.team1751.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int D_LEFT_1 = 0;
	public static final int D_LEFT_2 = 1;
	public static final int D_RIGHT_1 = 2;
	public static final int D_RIGHT_2 = 3;
	public static final int M_SHOOTER = 4;
	public static final int M_INTAKE = 5;
	
	public static final int STICK_DRIVE = 0;
	public static final int STICK_OP = 1;
	
	//BUTTONS
	public static final int INTAKE_IN = 3;
	public static final int INTAKE_OUT = 2;
	public static final int ACTIVATE_SHOOTER = 1;

	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;D_
	// public static int rangefinderModule = 1;
}
