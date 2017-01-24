package org.usfirst.frc5124.FRCPrototype2017;

import org.usfirst.frc5124.FRCPrototype2017.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
    
    public Joystick driver;
    public Joystick operator;

    public OI() {

    	driver = new Joystick(0);
        operator = new Joystick(1);
        
        //SmartDashboard buttons here
    }

    public Joystick getDriver() {
        return driver;
    }

    public Joystick getOperator() {
        return operator;
    }
    
	public double getLeft() {
	    if(Math.abs(driver.getRawAxis(1)) > 0.07) {
	    	return driver.getRawAxis(1);
	    } else {
	    	return 0;
	    }
	}
    	
    public double getRight() {	
       	if(Math.abs(driver.getRawAxis(5)) > 0.07) {
       		return driver.getRawAxis(5);
       	} else {
       		return 0;
        }	
    }
}