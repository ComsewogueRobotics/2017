package org.usfirst.frc.team1751.robot.commands;

import org.usfirst.frc.team1751.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReleaseBalls extends Command {

    public ReleaseBalls() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    public ReleaseBalls(double timer){
    	setTimeout(timer);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.setServo(0);
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
    	Robot.shooter.setServo(90);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
