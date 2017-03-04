package org.usfirst.frc.team4376.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
//import org.team4376.robot.Constants

public class MultiCameraServer {

    CameraServer cameraServer;
    UsbCamera frontCam;
    UsbCamera backCam;
    boolean frontEnabled = true;

	public MultiCameraServer(int width, int height, int fps){
        cameraServer = CameraServer.getInstance();
        frontCam = cameraServer.startAutomaticCapture("Front", RobotMap.CAMERA_ONE);
        frontCam.setResolution(width, height);
        frontCam.setFPS(fps);
        backCam = cameraServer.startAutomaticCapture("Back", RobotMap.CAMERA_TWO);
        backCam.setResolution(width, height);
        backCam.setFPS(fps);
	}

    public UsbCamera getCurrentCamera() {
        if (frontEnabled){
            return frontCam;
        } else {
            return backCam;
        }
    }

    
    public void switchCamera(){
        if (frontEnabled){
            switchToBackCamera();
        } else {
            switchToFrontCamera();
        }
    }

    public void switchToBackCamera() {
        frontEnabled = false;
        cameraServer.getServer().setSource(backCam);
    }

    public void switchToFrontCamera() {
      frontEnabled = true;
      cameraServer.getServer().setSource(frontCam);
    }
}