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
import org.usfirst.frc5124.FRCPrototype2017.subsytems.*;
import org.usfirst.frc5124.FRCPrototype2017.commands.*;

public class Robot extends IterativeRobot  {

    Command autonomousCommand;

    public static OI oi;
    public static Intake intake;
    public static Conveyor conveyor;
    public static GearHolder gearHolder;
    public static Drivetrain drivetrain;
    public static Compressor compressor;
    public static Shooter shooter;
    
    public void robotInit() {
    	RobotMap.init();
    	intake = new Intake();
    	conveyor = new Conveyor();
    	gearHolder = new GearHolder();
        drivetrain = new Drivetrain();
        compressor = new Compressor();
        shooter = new Shooter();
        
        autonomousCommand = new ShooterShootingSpeed();
        
        oi = new OI();
    }

    public void disabledInit(){
    	shooter.disable();
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        double power = Math.abs((oi.getOperator().getRawAxis(3) - 1)/-2);
        SmartDashboard.putNumber("pr", power);
    }

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
        
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putNumber("Velocity", shooter.getEncoderVelocity());
        SmartDashboard.putNumber("Position", shooter.getEncoderPosition());
       
         
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