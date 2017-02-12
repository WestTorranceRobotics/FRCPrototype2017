package org.usfirst.frc5124.FRCPrototype2017.subsytems;

import org.usfirst.frc5124.FRCPrototype2017.Robot;
import org.usfirst.frc5124.FRCPrototype2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Shooter extends PIDSubsystem {

    CANTalon shooterMotor = RobotMap.shooterShooterMotor;
    CANTalon shooterMotor2 = RobotMap.shooterShooterMotor2;
    CANTalon shooterMotor3 = RobotMap.shooterShooterMotor3;
    
    public static final int shootingSpeed = 10000;
    public static final double ramprate = 8;
    
    
    public Shooter() {
    	super("Shooter", 0.00001, 0.0000001, 0);//revs up good, needs to be more responsive to balls
    	//super("Shooter", .00003, 0.0000055, 0); //old values, obsolete, kept for paranoia value
    	setAbsoluteTolerance(50);
    	getPIDController().setOutputRange(0, .8);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Shooter", "PIDSubsystem Controller", getPIDController());
        
    }
    
    public double getCurrent() {
    	return shooterMotor.getOutputCurrent();
    }
    
    public double getRampRate() {
    	return ramprate;
    }
    
    public double getVoltage() {
    	return shooterMotor.getOutputVoltage();
    }
    
    public void setShooterSpeed(double power) {
    	shooterMotor.set(power);
    	shooterMotor2.set(power);
    	shooterMotor3.set(power);
    }
    
    public void stop() {
    	shooterMotor.set(0);
    	shooterMotor3.set(0);
    	shooterMotor2.set(0);
    }
    
    public int getShootingSpeed() {
    	return shootingSpeed;
    }
    
    public int getEncoderVelocity() {
    	return shooterMotor.getEncVelocity();
    } 
    
    public int getEncoderPosition() {
    	return shooterMotor.getEncPosition();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	protected double returnPIDInput() {
		return getEncoderVelocity();
	}

	@Override
	protected void usePIDOutput(double output) {
		setShooterSpeed(output);
	}
	
}
