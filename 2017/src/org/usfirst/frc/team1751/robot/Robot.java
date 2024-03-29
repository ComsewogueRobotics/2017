
package org.usfirst.frc.team1751.robot;

import org.usfirst.frc.team1751.robot.commands.Auto_pos1_BLUE;
import org.usfirst.frc.team1751.robot.commands.Auto_pos1_RED;
import org.usfirst.frc.team1751.robot.commands.Auto_pos2;
import org.usfirst.frc.team1751.robot.commands.Auto_pos3;
import org.usfirst.frc.team1751.robot.commands.ShedTest;
import org.usfirst.frc.team1751.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1751.robot.subsystems.Shooter;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Shooter shooter = new Shooter();
	public static final DriveTrain drivetrain = new DriveTrain();
	public static OI oi;

	private Command autonomousCommand;
	private SendableChooser<Command> chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		chooser = new SendableChooser<Command>();
		chooser.addDefault("Shed Test", new ShedTest());
		chooser.addObject("Auto Position 1 (RED ALLIANCE)", new Auto_pos1_RED());
		chooser.addObject("Auto Position 1 (BLUE ALLIANCE)", new Auto_pos1_BLUE());
		chooser.addObject("Auto Position 2", new Auto_pos2());
		chooser.addObject("Auto Position 3", new Auto_pos3());
		CameraServer server = CameraServer.getInstance();
		UsbCamera shooterCam = server.startAutomaticCapture();
		shooterCam.setFPS(10);
		shooterCam.setResolution(640, 480);
		UsbCamera driveCam = server.startAutomaticCapture();
		driveCam.setFPS(10);
		driveCam.setResolution(640,480);
		drivetrain.calGyro();
		SmartDashboard.putNumber("Gyro",Robot.drivetrain.getAngle());
		SmartDashboard.putData("Choose ", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		drivetrain.resetGyro();
		autonomousCommand = chooser.getSelected();
		//autonomousCommand = new AutonomousCommand();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
