package org.usfirst.frc.team1751.robot.subsystems;

import org.usfirst.frc.team1751.robot.RobotMap;
import org.usfirst.frc.team1751.robot.commands.Drive;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	private Spark left_W1, left_W2, right_W1, right_W2;
	private RobotDrive robotdrive;
	private ADXRS450_Gyro gyro;
	//private ADIS16448_IMU nav;
	
	public DriveTrain(){
		gyro = new ADXRS450_Gyro();
		//nav = new ADIS16448_IMU();
		left_W1 = new Spark(RobotMap.D_LEFT_1);
		left_W2 = new Spark(RobotMap.D_LEFT_2);
		right_W1 = new Spark(RobotMap.D_RIGHT_1);
		right_W2 = new Spark(RobotMap.D_RIGHT_2);
		
		robotdrive = new RobotDrive(left_W1,left_W2,right_W1,right_W2);
		robotdrive.setSafetyEnabled(false);
			

	}
	
	public double getAngle(){
		return gyro.getAngle() % 360;
		//return nav.getAngle() % 360;
	}
	public void resetGyro(){
		gyro.reset();
		//nav.reset();
	}
	public void calGyro(){
		gyro.calibrate();
		//nav.calibrate();
		System.out.println("Calibration complete.");
	}
	public void arcadeDrive(double move, double turn, double throttle){
		robotdrive.arcadeDrive(move, turn, true);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());
		
	}
	
	
}
	

