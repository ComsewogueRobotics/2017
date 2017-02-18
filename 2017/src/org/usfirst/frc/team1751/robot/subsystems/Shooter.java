package org.usfirst.frc.team1751.robot.subsystems;

import org.usfirst.frc.team1751.robot.Robot;
import org.usfirst.frc.team1751.robot.RobotMap;

//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	
	private VictorSP conveyorMotor;
	//private VictorSP shooterMotor;
	private TalonSRX shooterMotor;
	//private double shooter_speed;
	
	public Shooter()
	{
		conveyorMotor = new VictorSP(RobotMap.M_INTAKE);
		shooterMotor = new TalonSRX(RobotMap.M_SHOOTER);
		//shooter_speed = ((Robot.oi.getOpStick().getZ()) + 1) / 2;
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
	/*
	public void setSpeed(double speed){
		shooter_speed = speed;
	}
	public double getSpeed(){
		return shooter_speed;
	}
	*/
	

 
}
