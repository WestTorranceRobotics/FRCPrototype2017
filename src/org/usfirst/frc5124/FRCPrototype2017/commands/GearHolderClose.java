package org.usfirst.frc5124.FRCPrototype2017.commands;

import org.usfirst.frc5124.FRCPrototype2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearHolderClose extends Command {

    public GearHolderClose() {
        requires(Robot.gearHolder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearHolder.close();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
