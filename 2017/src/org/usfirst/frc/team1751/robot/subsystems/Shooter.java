package org.usfirst.frc.team1751.robot.subsystems;

import org.usfirst.frc.team1751.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	
	private VictorSP conveyorMotor;
	private TalonSRX shooterMotor;
	private Servo ballReleaseServo;
	
	public Shooter()
	{
		conveyorMotor = new VictorSP(RobotMap.M_INTAKE);
		shooterMotor = new TalonSRX(RobotMap.M_SHOOTER);
		ballReleaseServo = new Servo(RobotMap.BALL_RELEASE_SERVO);
	}
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	
	
	public void setIntake(double speed){
		conveyorMotor.set(speed);
	}
	public void setShooter(double speed){
		shooterMotor.set(speed);
	}
	public void setServo(double angle){
		ballReleaseServo.setAngle(angle);
	}
	
	

 
}
