package org.usfirst.frc5124.FRCPrototype2017.subsytems;

import org.usfirst.frc5124.FRCPrototype2017.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearHolder extends Subsystem {

    Solenoid gearSolenoid = RobotMap.gearHolderGearSolenoid;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void open() {
    	gearSolenoid.set(true);
    }
    
    public void close () {
    	gearSolenoid.set(false);
    }
}

