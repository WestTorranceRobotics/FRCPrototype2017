package org.usfirst.frc5124.FRCPrototype2017;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5124.FRCPrototype2017.subsytems.Drivetrain;
import org.usfirst.frc5124.FRCPrototype2017.subsytems.Shooter;
import org.usfirst.frc5124.FRCPrototype2017.commands.*;

public class Robot extends IterativeRobot  {

    Command autonomousCommand;
    
    public static Timer autoTimer;

    public static OI oi;
    public static Drivetrain drivetrain;
    public static Compressor compressor;
    public static Shooter shooter;
    UsbCamera camera;
    boolean yes = false;
    boolean press = false;
    
    public void robotInit() {
    	RobotMap.init();
    	autoTimer = new Timer();
        drivetrain = new Drivetrain();
        compressor = new Compressor();
        shooter = new Shooter();
        oi = new OI();
    }

    public void disabledInit(){
    	shooter.disable();
    	autoTimer.stop();
    	autoTimer.reset();
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        double power = Math.abs((oi.getOperator().getRawAxis(3) - 1)/-2);
        SmartDashboard.putNumber("pr", power);
    }

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
        shooter.enable();
        shooter.setSetpoint(shooter.getShootingSpeed());
        autoTimer.start();
    }

    public void autonomousPeriodic() {
    	SmartDashboard.putNumber("pr", RobotMap.shooter.get());
    	SmartDashboard.putNumber("Velocity", shooter.getEncoderVelocity());
        SmartDashboard.putNumber("Time", autoTimer.get());
        SmartDashboard.putNumber("Voltage", shooter.getVoltage());
        SmartDashboard.putNumber("Current", shooter.getCurrent());
        
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putNumber("Velocity", shooter.getEncoderVelocity());
        SmartDashboard.putNumber("Position", shooter.getEncoderPosition());
        
        if(oi.operator.getRawButton(1) && !press) {
        	yes = !yes;
        	press = true;
        } else if (!oi.operator.getRawButton(1)) {
        	press = false;
        }
        
        RobotMap.gearSolenoid.set(yes);
        
        double power = Math.abs((oi.getOperator().getRawAxis(3) - 1)/-2);
        if (power > .1) {
        	shooter.setShooterSpeed(power);
        	SmartDashboard.putNumber("pr", power);
        }
        else {
        	shooter.stop();
        	SmartDashboard.putNumber("pr", power);
        }
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
    
}