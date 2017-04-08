package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class VisionSubsystem extends Subsystem {

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public int screenWidth = 320;
  public int centerOfScreen = screenWidth / 2;
  public int desiredAlignmentX = centerOfScreen - 12;
  public int xPosOfTarget = -1;
  private int lastFrameNumber = -1;
  public int marginOfError = 20;
  private boolean acquiredTarget = false;

  public VisionSubsystem() {

  }

  
  public void checkForCameraUpdateStrafeAngle(double angle) {
	    int frameNumber = getFrameNumber();
	    if (frameNumber != lastFrameNumber) {
//	      acquiredTarget = true;
	      lastFrameNumber = frameNumber;
	      xPosOfTarget = SmartDashboard.getInt("overallCenterX", desiredAlignmentX);
	      onCameraUpdate();
	      //driveTowardsTarget();
	      strafeTowardsTargetAtAngle(angle);
	    } else {
        Robot.chassis.driveAtAngle(angle, -.15);
//	    	if (acquiredTarget){
//	    		Robot.chassis.driveMe(0, -.15, 0);
//	    	}
//	    	else {
//	    		Robot.chassis.driveMe(0, -.25, 0);
//	    	}
//	    	if(acquiredTarget()){
//	            Robot.chassis.driveMe(0, -.15, 0);
//	    	} else {
//	            Robot.chassis.driveMe(0, -.10, 0);    		
//	    	}

	    }

	  }
	  
  
  public void checkForCameraUpdate() {
    int frameNumber = getFrameNumber();
    if (frameNumber != lastFrameNumber) {
//      acquiredTarget = true;
      lastFrameNumber = frameNumber;
      xPosOfTarget = SmartDashboard.getInt("overallCenterX", desiredAlignmentX);
      onCameraUpdate();
      driveTowardsTarget();
    } else {
    	Robot.chassis.driveMe(0, -.15, 0);
//    	if (acquiredTarget){
//    		Robot.chassis.driveMe(0, -.15, 0);
//    	}
//    	else {
//    		Robot.chassis.driveMe(0, -.25, 0);
//    	}
//    	if(acquiredTarget()){
//            Robot.chassis.driveMe(0, -.15, 0);
//    	} else {
//            Robot.chassis.driveMe(0, -.10, 0);    		
//    	}

    }

  }
  
  public void checkForCameraUpdate(double rotationSpeed) {
	    int frameNumber = getFrameNumber();
	    if (frameNumber != lastFrameNumber) {
//	      acquiredTarget = true;
	      lastFrameNumber = frameNumber;
	      xPosOfTarget = SmartDashboard.getInt("overallCenterX", desiredAlignmentX);
	      onCameraUpdate();
	      driveTowardsTarget(rotationSpeed);
	    } else {
	    	Robot.chassis.driveMe(0, -.15, 0);
//	    	if (acquiredTarget){
//	    		Robot.chassis.driveMe(0, -.15, 0);
//	    	}
//	    	else {
//	    		Robot.chassis.driveMe(0, -.25, 0);
//	    	}
//	    	if(acquiredTarget()){
//	            Robot.chassis.driveMe(0, -.15, 0);
//	    	} else {
//	            Robot.chassis.driveMe(0, -.10, 0);    		
//	    	}

	    }

	  }

  public int getFrameNumber(){
	  return SmartDashboard.getInt("frameNumber", lastFrameNumber);
  }
  
  public void driveTowardsTarget(double rotationSpeed){
	  for(int i = 0; i < 15; i++){
		    if (onTarget()) {
		      Robot.chassis.driveMe(0, -.15, 0);
		    } else if (leftOfTarget()) {
		      Robot.chassis.driveMe(0, -.15, rotationSpeed); // rotate
//		      Robot.chassis.driveMe(.5, -.15, 0); //strafe
//		      Robot.chassis.driveMe(.5, -.15, .5); //both WARNING REALLY CRAPPY
		    } else {
		      Robot.chassis.driveMe(0, -0.15, rotationSpeed * -1.0); //rotate
//		      Robot.chassis.driveMe(-.5, -.15, 0); //strafe
//		      Robot.chassis.driveMe(-.5, -.15, -.5); //both WARNING REALLY CRAPPY
		    }
		  }
	  
  }

  
  public void strafeTowardsTargetAtAngle(double angle){
	  double rotationSpeed = .05 + Math.abs(targetOffsetFromDesired());
	  for(int i = 0; i < 15; i++){
	    if (onTarget()) {
	      Robot.chassis.driveAtAngle(angle, -.15);
	    } else if (leftOfTarget()) {
	      //Robot.chassis.driveMe(0, -.15, rotationSpeed); // rotate
	      Robot.chassis.driveMe(rotationSpeed, -.15, 0); // strafe
//	      Robot.chassis.driveMe(.5, -.15, 0); //strafe
//	      Robot.chassis.driveMe(.5, -.15, .5); //both WARNING REALLY CRAPPY
	    } else {
	      //Robot.chassis.driveMe(0, -0.15, rotationSpeed * -1.0); //rotate
	      Robot.chassis.driveMe(rotationSpeed * -1.0, -0.15, 0); //strafe
//	      Robot.chassis.driveMe(-.5, -.15, 0); //strafe
//	      Robot.chassis.driveMe(-.5, -.15, -.5); //both WARNING REALLY CRAPPY
	    }
	  }
  }
  
  public void driveTowardsTarget(){
	  double rotationSpeed = .05 + Math.abs(targetOffsetFromDesired());
	  for(int i = 0; i < 15; i++){
	    if (onTarget()) {
	      Robot.chassis.driveMe(0, -.15, 0);
	    } else if (leftOfTarget()) {
	      //Robot.chassis.driveMe(0, -.15, rotationSpeed); // rotate
	      Robot.chassis.driveMe(rotationSpeed, -.15, 0); // strafe
//	      Robot.chassis.driveMe(.5, -.15, 0); //strafe
//	      Robot.chassis.driveMe(.5, -.15, .5); //both WARNING REALLY CRAPPY
	    } else {
	      //Robot.chassis.driveMe(0, -0.15, rotationSpeed * -1.0); //rotate
	      Robot.chassis.driveMe(rotationSpeed * -1.0, -0.15, 0); //strafe
//	      Robot.chassis.driveMe(-.5, -.15, 0); //strafe
//	      Robot.chassis.driveMe(-.5, -.15, -.5); //both WARNING REALLY CRAPPY
	    }
	  }
  }
  
  public boolean acquiredTarget() {
	  return lastFrameNumber != -1;
  }
  
  public void onCameraUpdate() {
	  System.out.println("camera update!");
	  
  }

  public void lineUpGear() {
	System.out.println(SmartDashboard.getDouble("frameNumber"));
    checkForCameraUpdate();
  }

  public int targetOffsetFromDesired() {
    return xPosOfTarget - desiredAlignmentX;
  }

  public boolean onTarget() {
    return (Math.abs(targetOffsetFromDesired()) <= marginOfError);
  }

  public boolean leftOfTarget() {
    return targetOffsetFromDesired() > marginOfError;
  }

  public void stopLineUpGear() {
    return;
  }

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
