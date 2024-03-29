package org.usfirst.frc.team1751.robot;

import org.usfirst.frc.team1751.robot.commands.Climb;
import org.usfirst.frc.team1751.robot.commands.IntakeIn;
import org.usfirst.frc.team1751.robot.commands.IntakeOut;
import org.usfirst.frc.team1751.robot.commands.ReleaseBalls;
import org.usfirst.frc.team1751.robot.commands.ShooterToggle;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//import edu.wpi.first.wpilibj.buttons.Button;

//import org.usfirst.frc.team1751.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	private Joystick driveStick;
	private Joystick opStick;
	private Button intakeIn;
	private Button intakeOut;
	private Button activateShooter;
	private Button releaseBalls;
	private Button climber;
	
	public OI(){
		driveStick = new Joystick(RobotMap.STICK_DRIVE);
		opStick = new Joystick(RobotMap.STICK_OP);
		intakeIn = new JoystickButton(driveStick, RobotMap.INTAKE_IN);
		intakeOut = new JoystickButton(driveStick, RobotMap.INTAKE_OUT);
		activateShooter = new JoystickButton(opStick, RobotMap.ACTIVATE_SHOOTER);
		releaseBalls = new JoystickButton(opStick, RobotMap.BALL_RELEASE);
		climber = new JoystickButton(opStick, RobotMap.CLIMBER);
		intakeIn.whileHeld(new IntakeIn());
		intakeOut.whileHeld(new IntakeOut());
		activateShooter.whileHeld(new ShooterToggle());
		releaseBalls.whileHeld(new ReleaseBalls());
		climber.whileHeld(new Climb());
		
		
		
	}
	public Joystick getDriveStick(){
		return driveStick;
	}
	public Joystick getOpStick(){
		return opStick;
	}
	
	
	
}


















