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
  public int cameraFieldOfViewAngle = 120;
  public int screenWidth = 320;
  public int centerOfScreen = screenWidth / 2;
  public int desiredAlignmentX = centerOfScreen - 30;
  public int xPosOfTarget = -1;
  private int lastFrameNumber = -1;

  public VisionSubsystem() {

  }

  public void checkForCameraUpdate() {
    int frameNumber = SmartDashboard.getInt("frameNumber", lastFrameNumber);
    if (frameNumber != lastFrameNumber) {
      lastFrameNumber = frameNumber;
      xPosOfTarget = SmartDashboard.getInt("overallCenterX", desiredAlignmentX);
//      onCameraUpdate();
      driveTowardsTarget();
    }
  }

  public double targetOffsetAngleFromDesired(){
	  return targetOffsetFromDesired() * (cameraFieldOfViewAngle / screenWidth);
  }

  public void driveTowardsTarget(){
	  for(int i = 0; i < 10; i++){
	    if (onTarget()) {
	      Robot.chassis.driveMe(0, -.5, 0);
	    } else if (leftOfTarget()) {
	      Robot.chassis.driveMe(0, -.5, .5);
	    } else {
	      Robot.chassis.driveMe(0, -0.5, -.5);
	    }
	  }
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
    return (Math.abs(targetOffsetFromDesired()) <= 10);
  }

  public boolean leftOfTarget() {
    return targetOffsetFromDesired() > 10;
  }

  public void stopLineUpGear() {
    return;
  }

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
