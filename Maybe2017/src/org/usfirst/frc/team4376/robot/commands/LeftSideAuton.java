package org.usfirst.frc.team4376.robot.commands;

import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LeftSideAuton extends Command {

	private Timer timer;

	public int iteration = 1;

	public LeftSideAuton() {
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

		// if(timer.get() <= 1){
		// Robot.chassis.driveForward();
		// }

		if (timer.get() > 0 && timer.get() <= 3.0) {
			if (Robot.gyro.getAngleZ() <= 2 && Robot.gyro.getAngleZ() >= -2) {
				Robot.chassis.driveMe(0, -.25, 0);
				// } else if (Robot.gyro.getAngleZ() <2){
				// Robot.chassis.driveMe(0, -.25, -.25);
				// } else {
				// Robot.chassis.driveMe(0, -.25, .25);
				// }
			} else if (Robot.gyro.getAngleZ() <= 30 && Robot.gyro.getAngleZ() > 2) {
				Robot.chassis.driveMe(0, -.25, -.25);
			} else if (Robot.gyro.getAngleZ() < 58 && Robot.gyro.getAngleZ() > 30) {
				Robot.chassis.driveMe(0, -.25, .25);
			} else if (Robot.gyro.getAngleZ() > 62) {
				Robot.chassis.driveMe(0, -.25, -.25);
			} else if (Robot.gyro.getAngleZ() < -2 && Robot.gyro.getAngleZ() >= -30) {
				Robot.chassis.driveMe(0, -.25, .25);
			} else if (Robot.gyro.getAngleZ() < -30 && Robot.gyro.getAngleZ() > -58) {
				Robot.chassis.driveMe(0, -.25, -.25);
			} else if (Robot.gyro.getAngleZ() < -62) {
				Robot.chassis.driveMe(0, -.25, .25);
			}
		}    else if(timer.get() > 3.0 && timer.get() <= 6.0){
			if(Robot.gyro.getAngleZ() < 59){
				Robot.chassis.driveMe(0, 0, .25);
			}
			else if (Robot.gyro.getAngleZ() > 61){
				Robot.chassis.driveMe(0, 0, -.25);
			}
		}	else if(timer.get() > 6.0 && timer.get() <= 7.5){
				if(Robot.gyro.getAngleZ() < 62 && Robot.gyro.getAngleZ() > 58){
						Robot.chassis.driveMe(0, -.25, 0);
				} else if(Robot.gyro.getAngleZ() < 58){
				Robot.chassis.driveMe(0, -0.25, .15);
			}	else if(Robot.gyro.getAngleZ() > 62){
				Robot.chassis.driveMe(0, -0.25, -.15);
			}
		}
		
		
		
		
		else if (timer.get() > 7.5 && timer.get() <= 12.0) {
			// int timer_int = (int)timer.get();
			double shake_direction = 1.0;
			if (iteration % 2 == 0){
				shake_direction *= -1.0;
			}
			Robot.chassis.driveMe(0, 0, .45*shake_direction);
//			if (iteration % 2 == 0) {
//				Robot.chassis.driveMe(0, -.25, .45); // rotate clockwise
//			} else {
//				Robot.chassis.driveMe(0, -.25, -.45); // rotate counter-clockwise
//			}
			iteration++;

		}
		// } else if (timer.get() >= 5.5 && timer.get() <= 7.5){
		// for (int i=0; i<10; i++){
		// Robot.chassis.driveMe(.2, 0, .25); //rotate clockwise
		// }
		// for (int i=0; i<10; i++){
		// Robot.chassis.driveMe(.2, 0, -.25); //rotate counter-clockwise
		// }
		// }
		//
		// } else {
		// double initialGyro = Robot.gyro.getAngle();
		// while(Robot.gyro.getAngle() < initialGyro + 45){
		// System.out.println("initialGyro " + initialGyro);
		// System.out.println("gyro getAngle " + Robot.gyro.getAngle());
		// Robot.chassis.driveMe(0, 0, 1.25); //rotate clockwise
		// }
		// }

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
