package org.usfirst.frc5124.FRCPrototype2017;

import org.usfirst.frc5124.FRCPrototype2017.commands.*;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
    
    public Joystick driver;
    public Joystick operator;

    public OI() {

    	//joysticks
    	driver = new Joystick(0);
        operator = new Joystick(1);
        
        //joystick button initializations (need to be renamed at a later date)
        JoystickButton intakeButton = new JoystickButton(driver, 2);
        JoystickButton exhaustButton = new JoystickButton(driver, 3);
        JoystickButton conveyUpButton = new JoystickButton(operator, 2);
        JoystickButton conveyDownButton = new JoystickButton(operator, 3);
        JoystickButton shootButton = new JoystickButton(operator, 1);
        JoystickButton gearOpenButton = new JoystickButton(operator, 4);
        JoystickButton gearCloseButton = new JoystickButton(operator, 5);
        
        //setting commands to buttons
        intakeButton.whileHeld(new IntakeIntakeBalls());
        exhaustButton.whileHeld(new IntakeExhaustBalls());
        conveyUpButton.whileHeld(new ConveyorConveyBallsUp());
        conveyDownButton.whileHeld(new ConveyorConveyBallsDown());
        shootButton.whileHeld(new ShooterShootingSpeed());
        gearOpenButton.whenPressed(new GearHolderOpen());
        gearCloseButton.whenPressed(new GearHolderClose());
        
        //SmartDashboard buttons for testing commands (prototype only)
        
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
    
    public void vibrateDriver() {
    	driver.setRumble(GenericHID.RumbleType.kLeftRumble, 0.5);
   		driver.setRumble(GenericHID.RumbleType.kRightRumble, 1);
    }
    	     
    public void stopVibrate() {
    	driver.setRumble(GenericHID.RumbleType.kLeftRumble, 0);
    	driver.setRumble(GenericHID.RumbleType.kRightRumble, 0);
    }
}