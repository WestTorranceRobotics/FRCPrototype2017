package org.usfirst.frc5124.FRCPrototype2017.commands;

import org.usfirst.frc5124.FRCPrototype2017.Robot;
import org.usfirst.frc5124.FRCPrototype2017.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class JoystickPuppetry extends Command {

    public JoystickPuppetry() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.drivetrainRobotDrive.tankDrive(Robot.oi.getLeft(), Robot.oi.getRight());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.drivetrain.stop(); this will make the drivetrain stutter
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.stop();
    }
}
