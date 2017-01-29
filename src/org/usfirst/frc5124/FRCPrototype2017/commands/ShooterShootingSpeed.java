package org.usfirst.frc5124.FRCPrototype2017.commands;

import org.usfirst.frc5124.FRCPrototype2017.Robot;
import org.usfirst.frc5124.FRCPrototype2017.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterShootingSpeed extends Command {

    public ShooterShootingSpeed() {
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.shooter.setSetpoint(Robot.shooter.getShootingSpeed());
    	//Robot.shooter.enable();
    	RobotMap.shooterShooterMotor.setControlMode(2);
    	//RobotMap.shooterShooterMotor.setVoltageRampRate(Robot.shooter.getRampRate());
    	RobotMap.shooterShooterMotor.set(Robot.shooter.getShootingSpeed());
    	//RobotMap.shooterShooterMotor.clearIAccum();
    	RobotMap.shooterShooterMotor.enableControl();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	SmartDashboard.putNumber("pr", RobotMap.shooterShooterMotor.get());
    	SmartDashboard.putNumber("Velocity", Robot.shooter.getEncoderVelocity());
        SmartDashboard.putNumber("Voltage", Robot.shooter.getVoltage());
        SmartDashboard.putNumber("Current", Robot.shooter.getCurrent());
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.shooter.disable();
    	//Robot.shooter.setSetpoint(0);
    	RobotMap.shooterShooterMotor.enableBrakeMode(false);
    	RobotMap.shooterShooterMotor.setControlMode(0);
    	RobotMap.shooterShooterMotor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
