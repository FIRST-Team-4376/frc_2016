package org.usfirst.frc.team4376.robot;

import java.awt.Button;

import org.usfirst.frc.team4376.robot.commands.InvertCommand;
import org.usfirst.frc.team4376.robot.commands.UnInvertCommand;
import org.usfirst.frc.team4376.robot.commands.LiftUpCommand;
import org.usfirst.frc.team4376.robot.commands.LiftDownCommand;
import org.usfirst.frc.team4376.robot.commands.StopLiftUpCommand;
import org.usfirst.frc.team4376.robot.commands.LauncherCommand;
import org.usfirst.frc.team4376.robot.commands.GetBallCommand;
import org.usfirst.frc.team4376.robot.commands.StopLauncherCommand;
import org.usfirst.frc.team4376.robot.commands.PushBallCommand;
import org.usfirst.frc.team4376.robot.commands.RetractPusherCommand;
import org.usfirst.frc.team4376.robot.commands.PortcullisLifterOutCommand;
import org.usfirst.frc.team4376.robot.commands.PortcullisLifterInCommand;
import org.usfirst.frc.team4376.robot.commands.TapeExtendCommand;
import org.usfirst.frc.team4376.robot.commands.TapeStopCommand;
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
	public Button liftUp;
	public Button liftDown;
	public Joystick buttonStick;
	public Button launchButton;
	public Button getBallButton;
	public Button portcullisOut;
	public Button portcullisIn;
	public Button tapeExtend;
	public Button tapeRetract;
	public Button pitTapeRetract;
	public Button pushBall;
	public Button retractPusher;
	public Button portcullisUp;
	public Button powerDown;
	
	public OI() {
		
		buttonStick = new Joystick(RobotMap.BUTTON_JOYSTICK);
		leftDriveStick = new Joystick(RobotMap.LEFT_DRIVE_JOYSTICK);
		rightDriveStick = new Joystick(RobotMap.RIGHT_DRIVE_JOYSTICK);
		
		JoystickButton portcullisUp = new JoystickButton(buttonStick, 10);
		portcullisUp.whenPressed(new PortcullisUpCommand());
		portcullisUp.whenReleased(new LiftUpCommand());
		
		JoystickButton powerDown = new JoystickButton(buttonStick, 9);
		powerDown.whenPressed(new PowerDownCommand());
		powerDown.whenReleased(new LiftUpCommand());
		
		JoystickButton launchButton = new JoystickButton(buttonStick, 6);
		JoystickButton getBallButton = new JoystickButton(buttonStick, 5);
		
		launchButton.whenPressed(new LauncherCommand());
		launchButton.whenReleased(new StopLauncherCommand());
		getBallButton.whenPressed(new GetBallCommand());
		getBallButton.whenReleased(new StopLauncherCommand());
		
		JoystickButton pushBall = new JoystickButton(buttonStick, 8);
		JoystickButton retractPusher = new JoystickButton(buttonStick, 7);
		pushBall.whenPressed(new PushBallCommand());
		retractPusher.whenPressed(new RetractPusherCommand());
		
		JoystickButton portcullisOut = new JoystickButton(buttonStick, 3);
		JoystickButton portcullisIn = new JoystickButton(buttonStick, 2);
		portcullisOut.whenPressed(new PortcullisLifterOutCommand());
		portcullisIn.whenPressed(new PortcullisLifterInCommand());
		
		
		JoystickButton tapeExtend = new JoystickButton(leftDriveStick, 3);
		JoystickButton tapeRetract = new JoystickButton(leftDriveStick, 2);
		JoystickButton pitTapeRetract = new JoystickButton(leftDriveStick, 9);
		tapeExtend.whenPressed(new TapeExtendCommand());
		tapeExtend.whenReleased(new TapeStopCommand());
		tapeRetract.whenPressed(new TapeRetractCommand());
		tapeRetract.whenReleased(new TapeStopCommand());
		pitTapeRetract.whenPressed(new PitTapeRetractCommand());
		pitTapeRetract.whenReleased(new TapeStopCommand());
		
	}
}

