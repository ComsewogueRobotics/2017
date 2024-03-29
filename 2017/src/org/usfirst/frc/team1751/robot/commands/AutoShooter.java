package org.usfirst.frc.team1751.robot.commands;

import org.usfirst.frc.team1751.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoShooter extends Command {
	
	private double speed;

    public AutoShooter(double timeout, double s) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	setTimeout(timeout);
    	speed = s;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.setShooter(speed);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.setShooter(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
