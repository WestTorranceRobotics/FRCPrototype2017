package org.usfirst.frc5124.FRCPrototype2017;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class RobotMap {
    public static SpeedController drivetrainLeft1;
    public static SpeedController drivetrainLeft2;
    public static SpeedController drivetrainRight1;
    public static SpeedController drivetrainRight2;
    public static RobotDrive drivetrainRobotDrive;
    public static Compressor compressor;
    public static Solenoid gearHolderGearSolenoid;
    public static CANTalon shooterShooterMotor;
    public static VictorSP intakeIntakeMotor;
    public static VictorSP conveyorConveyorMotor;
    public static VictorSP rightTest;

    public static void init() {
    	
    	//compressor = new Compressor(0);
    	
    	rightTest = new VictorSP(5);
    	LiveWindow.addActuator("test right", "test", rightTest);
    	
    	gearHolderGearSolenoid = new Solenoid(0, 0);
    	LiveWindow.addActuator("Gear Holder", "Gear Solenoid", gearHolderGearSolenoid);
    	
    	intakeIntakeMotor = new VictorSP(4);
    	LiveWindow.addActuator("Intake", "Intake Motor", intakeIntakeMotor);
    	
    	//conveyorConveyorMotor = new VictorSP(5); 
    	//LiveWindow.addActuator("Conveyor", "Conveyor Motor", conveyorConveyorMotor);
    	
    	shooterShooterMotor = new CANTalon(2);//shooter cantalon has can id of 2
    	shooterShooterMotor.enableBrakeMode(false);
    	shooterShooterMotor.setProfile(0);
    	shooterShooterMotor.setP(0.00001);
    	shooterShooterMotor.setI(0.00007);
    	shooterShooterMotor.setD(0);
    	shooterShooterMotor.setF(0);
        shooterShooterMotor.setControlMode(2);
        shooterShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        
        drivetrainLeft1 = new Talon(0);
        LiveWindow.addActuator("Drivetrain", "Left 1", (Talon) drivetrainLeft1);
        
        drivetrainLeft2 = new Talon(1);
        LiveWindow.addActuator("Drivetrain", "Left 2", (Talon) drivetrainLeft2);
        
        drivetrainRight1 = new Talon(2);
        LiveWindow.addActuator("Drivetrain", "Right 1", (Talon) drivetrainRight1);
        
        drivetrainRight2 = new Talon(3);
        LiveWindow.addActuator("Drivetrain", "Right 2", (Talon) drivetrainRight2);
        
        drivetrainRobotDrive = new RobotDrive(drivetrainLeft1, drivetrainLeft2,
              drivetrainRight1, drivetrainRight2);
      
        drivetrainRobotDrive.setSafetyEnabled(true);
        drivetrainRobotDrive.setExpiration(0.1);
        drivetrainRobotDrive.setSensitivity(0.2);
        drivetrainRobotDrive.setMaxOutput(.25);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
       
    }
}