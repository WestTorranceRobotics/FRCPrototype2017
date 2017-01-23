package org.usfirst.frc5124.JakeBoticsSwag.subsystems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FileMakr extends Subsystem  {

	File file = new File("\\media\\sda1\\text\\i1.txt");
    FileWriter fw;
    PrintWriter pw;
    
    public FileMakr() throws IOException {
    	fw = new FileWriter(file);
    	pw = new PrintWriter(fw);
    }
    
    public void writeToFile(String s) {
    	pw.print(s);
    }
    
    public void closePW() {
    	pw.close();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

