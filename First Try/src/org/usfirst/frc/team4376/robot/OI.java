package org.usfirst.frc.team4376.robot;

import java.awt.Button;

import org.usfirst.frc.team4376.robot.RobotMap;

import org.usfirst.frc.team4376.robot.commands.LiftUpCommand;
import org.usfirst.frc.team4376.robot.commands.PitTapeExtendCommand;
import org.usfirst.frc.team4376.robot.commands.LauncherCommand;
import org.usfirst.frc.team4376.robot.commands.GetBallCommand;
import org.usfirst.frc.team4376.robot.commands.StopLauncherCommand;
import org.usfirst.frc.team4376.robot.commands.PushBallCommand;
import org.usfirst.frc.team4376.robot.commands.RetractPusherCommand;
import org.usfirst.frc.team4376.robot.commands.PortcullisLifterOutCommand;
import org.usfirst.frc.team4376.robot.commands.PortcullisLifterInCommand;
import org.usfirst.frc.team4376.robot.commands.TapeExtendCommand;
import org.usfirst.frc.team4376.robot.commands.TapeLockCommand;
import org.usfirst.frc.team4376.robot.commands.TapeStopCommand;
import org.usfirst.frc.team4376.robot.commands.TapeUnlockCommand;
import org.usfirst.frc.team4376.robot.commands.TapeRetractCommand;
import org.usfirst.frc.team4376.robot.commands.PitTapeRetractCommand;
import org.usfirst.frc.team4376.robot.commands.PortcullisUpCommand;
import org.usfirst.frc.team4376.robot.commands.PowerDownCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
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
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public Joystick leftDriveStick;
	public Joystick rightDriveStick;
	// public Button liftUp;
	// public Button liftDown;
	public Joystick buttonStick;
	JoystickButton launchButton = new JoystickButton(buttonStick, 6);
	JoystickButton getBallButton = new JoystickButton(buttonStick, 5);
	JoystickButton portcullisOut = new JoystickButton(buttonStick, 3);
	JoystickButton portcullisIn = new JoystickButton(buttonStick, 2);
	JoystickButton pushBall = new JoystickButton(buttonStick, 8);
	JoystickButton retractPusher = new JoystickButton(buttonStick, 7);
	JoystickButton portcullisUp = new JoystickButton(buttonStick, 10);
  JoystickButton powerDown = new JoystickButton(buttonStick, 9);


  JoystickButton tapeExtend = new JoystickButton(leftDriveStick, RobotMap.BUTTON_EXTEND_TAPE);
  JoystickButton tapeRetract = new JoystickButton(leftDriveStick, RobotMap.BUTTON_RETRACT_TAPE);
  JoystickButton tapeLock = new JoystickButton(leftDriveStick, RobotMap.BUTTON_LOCK_TAPE);
  JoystickButton tapeUnlock = new JoystickButton(leftDriveStick, RobotMap.BUTTON_UNLOCK_TAPE);
  JoystickButton tapeUnlock2 = new JoystickButton(leftDriveStick, 2);
  JoystickButton pitTapeRetract = new JoystickButton(leftDriveStick, 8);
  JoystickButton pitTapeExtend = new JoystickButton(leftDriveStick, 9);
	
	public OI() {
		
		buttonStick = new Joystick(RobotMap.BUTTON_JOYSTICK);
		leftDriveStick = new Joystick(RobotMap.LEFT_DRIVE_JOYSTICK);
		rightDriveStick = new Joystick(RobotMap.RIGHT_DRIVE_JOYSTICK);
		
		portcullisUp.whenPressed(new PortcullisUpCommand());
		portcullisUp.whenReleased(new LiftUpCommand());
		
		powerDown.whenPressed(new PowerDownCommand());
		powerDown.whenReleased(new LiftUpCommand());
		
		
		launchButton.whenPressed(new LauncherCommand());
		launchButton.whenReleased(new StopLauncherCommand());
		getBallButton.whenPressed(new GetBallCommand());
		getBallButton.whenReleased(new StopLauncherCommand());
		
		pushBall.whenPressed(new PushBallCommand());
		retractPusher.whenPressed(new RetractPusherCommand());
		
		portcullisOut.whenPressed(new PortcullisLifterOutCommand());
		portcullisIn.whenPressed(new PortcullisLifterInCommand());
		
		

		tapeExtend.whenPressed(new TapeExtendCommand());
		tapeExtend.whenReleased(new TapeStopCommand());
		tapeRetract.whenPressed(new TapeRetractCommand());
		tapeRetract.whenReleased(new TapeStopCommand());
		tapeLock.whenReleased(new TapeLockCommand());
		tapeUnlock.whenReleased(new TapeUnlockCommand());
		tapeUnlock2.whenReleased(new TapeUnlockCommand());
		pitTapeRetract.whenPressed(new PitTapeRetractCommand());
		pitTapeRetract.whenReleased(new TapeStopCommand());
		pitTapeExtend.whenPressed(new PitTapeExtendCommand());
		pitTapeExtend.whenReleased(new TapeStopCommand());
		
	}
}

