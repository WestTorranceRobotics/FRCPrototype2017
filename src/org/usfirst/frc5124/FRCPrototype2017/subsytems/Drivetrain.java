package org.usfirst.frc5124.FRCPrototype2017.subsytems;

import org.usfirst.frc5124.FRCPrototype2017.RobotMap;
import org.usfirst.frc5124.FRCPrototype2017.commands.JoystickPuppetry;
import org.usfirst.frc5124.FRCPrototype2017.commands.*;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

    private final SpeedController left1 = RobotMap.drivetrainLeft1;
    private final SpeedController left2 = RobotMap.drivetrainLeft2;
    private final SpeedController right1 = RobotMap.drivetrainRight1;
    private final SpeedController right2 = RobotMap.drivetrainRight2;
    private final RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;

    public void initDefaultCommand() {
        setDefaultCommand(new JoystickPuppetry());
    }
    
    public void setLeft(double power) {
    	left1.set(power);
    	left2.set(power);
    }
    
    public void setRight(double power) {
    	right1.set(power);
    	right2.set(power);
    }
    
    public void stop() {
    	setLeft(0);
    	setRight(0);
    }
}