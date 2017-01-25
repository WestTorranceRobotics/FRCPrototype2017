package org.usfirst.frc5124.FRCPrototype2017.subsytems;

import org.usfirst.frc5124.FRCPrototype2017.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Conveyor extends Subsystem {

	VictorSP conveyorMotor = RobotMap.conveyorConveyorMotor;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void up() {
    	conveyorMotor.set(1);
    }
    
    public void down() {
    	conveyorMotor.set(-1);
    }
    
    public void stop() {
    	conveyorMotor.set(0);
    }
}

