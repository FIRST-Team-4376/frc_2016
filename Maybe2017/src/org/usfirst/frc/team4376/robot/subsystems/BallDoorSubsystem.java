package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
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
    
    ballDoorServo = new Servo(RobotMap.ballDoorServo);

  }
  
  public void ballDoorOpen(){
    
    ballDoorServo.set(1);
  }
  
  public void ballDoorClose(){
    
    ballDoorServo.set(-.5);
  }
  
  public void ballDoorRest(){
    
    ballDoorServo.set(0);
  }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

