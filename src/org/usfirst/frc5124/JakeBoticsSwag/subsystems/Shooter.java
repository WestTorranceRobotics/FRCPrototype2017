package org.usfirst.frc5124.JakeBoticsSwag.subsystems;

import org.usfirst.frc5124.JakeBoticsSwag.Robot;
import org.usfirst.frc5124.JakeBoticsSwag.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Shooter extends PIDSubsystem {

    CANTalon shooterMotor = RobotMap.shooter;
    
    public static final int shootingSpeed = 17700;
    
    
    public Shooter() {
    	super("Shooter", 0.000003, 0.000002, 0);
    	//super("Shooter", .00003, 0.0000055, 0);
    	setAbsoluteTolerance(50);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Shooter", "PIDSubsystem Controller", getPIDController());
    }
    
    public double getCurrent() {
    	return shooterMotor.getOutputCurrent();
    }
    
    public double getVoltage() {
    	return shooterMotor.getOutputVoltage();
    }
    
    public double getTime() {
    	return Robot.autoTimer.get();
    }
    
    public void setShooterSpeed(double power) {
    	shooterMotor.set(power);
    }
    
    public void stop() {
    	shooterMotor.set(0);
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

