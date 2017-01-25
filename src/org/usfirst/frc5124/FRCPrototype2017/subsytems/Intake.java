package org.usfirst.frc5124.FRCPrototype2017.subsytems;

import org.usfirst.frc5124.FRCPrototype2017.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    VictorSP intakeMotor = RobotMap.intakeIntakeMotor;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void intake() {
    	intakeMotor.set(1);
    }
    
    public void exhaust() {
    	intakeMotor.set(-1);
    }
    
    public void stop() {
    	intakeMotor.set(0);
    }
}

