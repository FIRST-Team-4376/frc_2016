package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4376.robot.RobotMap;


/**
 *
 */
public class BallDoorSubsystem extends Subsystem {
  
  Servo ballDoorServo;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
  
  public BallDoorSubsystem() {
    
    ballDoorServo = new Servo(1);

  }
  
  public void ballDoorOpen(){
    
    ballDoorServo.setAngle(75);
  }
  
  public void ballDoorClose(){
    
    ballDoorServo.setAngle(25);
  }
  
  public void ballDoorRest(){
    
    ballDoorServo.set(0);
  }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

