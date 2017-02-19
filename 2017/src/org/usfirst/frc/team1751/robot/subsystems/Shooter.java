package org.usfirst.frc.team1751.robot.subsystems;

import org.usfirst.frc.team1751.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
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
	private Relay climberMotor_1;
	private Relay climberMotor_2;
	
	public Shooter()
	{
		conveyorMotor = new VictorSP(RobotMap.M_INTAKE);
		shooterMotor = new TalonSRX(RobotMap.M_SHOOTER);
		ballReleaseServo = new Servo(RobotMap.BALL_RELEASE_SERVO);
		climberMotor_1 = new Relay(RobotMap.M_CLIMBER_1);
		climberMotor_2 = new Relay(RobotMap.M_CLIMBER_2);
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
	public void setServo(double pos){
		ballReleaseServo.set(pos);
	}
	
	public void setClimber(Relay.Value val){
		climberMotor_1.set(val);
		climberMotor_2.set(val);
	}
	
	/*
	public double getServo(){
		return ballReleaseServo.get();
	}
	*/
	

 
}
