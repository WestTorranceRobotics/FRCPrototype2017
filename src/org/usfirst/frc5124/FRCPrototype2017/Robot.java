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

import java.io.IOException;

import org.usfirst.frc5124.FRCPrototype2017.subsytems.Drivetrain;
import org.usfirst.frc5124.FRCPrototype2017.subsytems.FileMakr;
import org.usfirst.frc5124.FRCPrototype2017.subsytems.Shooter;
import org.usfirst.frc5124.FRCPrototype2017.commands.*;

public class Robot extends IterativeRobot  {

    Command autonomousCommand;
    //CameraServer camera;
    
    
    
    public static Timer autoTimer;

    public static FileMakr fileMakr;
    public static OI oi;
    public static Drivetrain drivetrain;
    public static Compressor compressor;
    public static Shooter shooter;
    UsbCamera camera;
    boolean yes = false;
    boolean press = false;
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotMap.init();
    	try {
			fileMakr = new FileMakr();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	autoTimer = new Timer();
        drivetrain = new Drivetrain();
        compressor = new Compressor();
        shooter = new Shooter();
        //camera = CameraServer.getInstance().startAutomaticCapture();
       // VisionThread visionThread = new VisionThread();
        oi = new OI();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	shooter.disable();
    	autoTimer.stop();
    	autoTimer.reset();
    	fileMakr.closePW();
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        double power = Math.abs((oi.getOperator().getRawAxis(3) - 1)/-2);
        SmartDashboard.putNumber("pr", power);
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        shooter.enable();
        shooter.setSetpoint(shooter.getShootingSpeed());
        autoTimer.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	SmartDashboard.putNumber("pr", RobotMap.shooter.get());
    	SmartDashboard.putNumber("Velocity", shooter.getEncoderVelocity());
        SmartDashboard.putNumber("Time", autoTimer.get());
        SmartDashboard.putNumber("Voltage", shooter.getVoltage());
        SmartDashboard.putNumber("Current", shooter.getCurrent());
        
        fileMakr.writeToFile(
        		autoTimer.get() + "," +
        		RobotMap.shooter.get() + "," +
        		shooter.getEncoderVelocity() + "," +
        		shooter.getVoltage() + "," + +
        		shooter.getCurrent() + ";"
        		);
        
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
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

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
}
