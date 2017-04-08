package org.usfirst.frc.team4376.robot.commands;

import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RightSideAutonVision extends Command {

  private Timer timer;

  public int iteration = 1;
  public boolean turnInPlaceComplete = false;

  public RightSideAutonVision() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.chassis);
  }

  // Called just before this Command runs the first time
  protected void initialize() {
    timer = new Timer();

    Robot.gyro.reset();
    timer.reset();
    timer.start();

  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {

    if (timer.get() > 0 && timer.get() <= 1.25) {
      turnInPlaceComplete = false;
      Robot.chassis.driveAtAngle(0.0, -0.40);
    } else if (timer.get() > 1.25 && timer.get() <= 5.5) {

      
      if (turnInPlaceComplete) {
        System.out.println("final thing");
//        Robot.chassis.driveAtAngle(60.0, -0.25);
        Robot.vision.checkForCameraUpdate();

      } else {
        Robot.chassis.driveAtAngle(-60.0, 0.0, .15);
        if (Robot.gyro.getAngleZ() >= -59 && Robot.gyro.getAngleZ() <= -61){
          turnInPlaceComplete = true;
        }
      }
    } else if (timer.get() > 5.5 && timer.get() <= 13.5) {
      //Robot.vision.checkForCameraUpdate(.15);
    	Robot.vision.checkForCameraUpdateStrafeAngle(-60.0);
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  protected void end() {

    Robot.chassis.stopMe();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
  }
}
