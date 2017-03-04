package org.usfirst.frc.team4376.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4376.robot.commands.ExampleCommand;
import org.usfirst.frc.team4376.robot.commands.RampUpCommand;
import org.usfirst.frc.team4376.robot.commands.RampDownCommand;
import org.usfirst.frc.team4376.robot.commands.RampAtRestCommand;
import org.usfirst.frc.team4376.robot.commands.BallDoorOpenCommand;
import org.usfirst.frc.team4376.robot.commands.BallDoorRestCommand;
import org.usfirst.frc.team4376.robot.commands.BallDoorCloseCommand;
import org.usfirst.frc.team4376.robot.commands.LiftBotCommand;
import org.usfirst.frc.team4376.robot.commands.LowerBotCommand;
import org.usfirst.frc.team4376.robot.commands.RestBotCommand;
import org.usfirst.frc.team4376.robot.commands.PickUpBallsCommand;
import org.usfirst.frc.team4376.robot.commands.PutDownBallsCommand;
import org.usfirst.frc.team4376.robot.commands.StopBallsCommand;
import org.usfirst.frc.team4376.robot.commands.LineUpGearCommand;
import org.usfirst.frc.team4376.robot.commands.LineUpGearStopCommand;
import org.usfirst.frc.team4376.robot.commands.ChangeCameraCommand;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public Joystick driveStick;
	public Button rampUp;
	public Button rampDown;
	public Button ballDoorOpen;
	public Button ballDoorClose;
	public Button lineUpGear;
	public Button putDownBalls;
	public Button pickUpBalls;
	public Button changeCamera;
	
	public OI(){
		
		driveStick = new Joystick(RobotMap.driveStick);
		
//		JoystickButton rampUp = new JoystickButton(driveStick, 10);
		JoystickButton rampDown = new JoystickButton(driveStick, 9);

		JoystickButton changeCamera = new JoystickButton(driveStick, 1);
		
		JoystickButton ballDoorOpen = new JoystickButton(driveStick, 3);
		JoystickButton ballDoorClose = new JoystickButton(driveStick, 4);
		
		JoystickButton liftBot = new JoystickButton(driveStick, 7);
		JoystickButton lowerBot = new JoystickButton(driveStick, 8);

//		JoystickButton pickUpBalls = new JoystickButton(driveStick, 11);
//		JoystickButton putDownBalls = new JoystickButton(driveStick, 12);
		JoystickButton lineUpGear = new JoystickButton(driveStick, 6);
		
		lineUpGear.whenPressed(new LineUpGearCommand());
		lineUpGear.whenReleased(new LineUpGearStopCommand());

		ballDoorOpen.whenPressed(new BallDoorOpenCommand());
		ballDoorClose.whenPressed(new BallDoorCloseCommand());
		//ballDoorOpen.whenReleased(new BallDoorRestCommand());
		//ballDoorClose.whenReleased(new BallDoorRestCommand());
		
//		rampUp.whenPressed(new RampUpCommand());
//		rampUp.whenReleased(new RampAtRestCommand());
		
//		changeCamera.whenPressed(new ChangeCameraCommand());
		
		rampDown.whenPressed(new RampDownCommand());
		rampDown.whenReleased(new RampAtRestCommand());
		
		liftBot.whenPressed(new LiftBotCommand());
		liftBot.whenReleased(new RestBotCommand());
		
		lowerBot.whenPressed(new LowerBotCommand());
		lowerBot.whenReleased(new RestBotCommand());
		
//		putDownBalls.whenPressed(new PutDownBallsCommand());
//		putDownBalls.whenReleased(new StopBallsCommand());
//		pickUpBalls.whenPressed(new PickUpBallsCommand());
//		pickUpBalls.whenReleased(new StopBallsCommand());
		
		// Ball pick-up attempt to toggle:
		
		//boolean toggle = true;
		//boolean pickUp = false;
		//if (toggle && pickUpBalls.get() == true) {
			//toggle = false;
			//if (pickUp){
				//pickUp = false;
				//new PickUpBallsCommand();
			//}	else{
			//pickUp = true;
			//	new StopBallsCommand();
	//	} }
		//	else if(pickUpBalls.get() == false) {
			//	toggle = true;
		//	}
	}
	
}

