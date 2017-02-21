package org.usfirst.frc.team1751.robot.commands;

import org.usfirst.frc.team1751.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveAutonomous extends Command {
	
	private double speed;

    public DriveAutonomous (double timeout,double s) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	setTimeout(timeout);
    	speed = s;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.drivetrain.resetGyro();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
    	SmartDashboard.putNumber("Gyro", Robot.drivetrain.getAngle());
    	Robot.drivetrain.arcadeDrive(speed, (.1*(Robot.drivetrain.getAngle())), 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.arcadeDrive(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
