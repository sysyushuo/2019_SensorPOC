/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.sensors;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.interfaces.IDistanceSensor;
import frc.robot.sensors.revSrc.DistanceUnit;
import frc.robot.sensors.revSrc.VL53L0X;
import frc.robot.util.LogDataBE;
import frc.robot.RobotMap;
import frc.robot.util.GeneralUtilities;
/**
 * This class exposes the onboard Distance Sensor Lead Student:
 */
public class DistanceRev2mSensor implements IDistanceSensor{

	private VL53L0X _distanceSensor;
	private double _distanceToTargetInInches;
	private boolean _didTimeoutOccur;
	

    //=====================================================================================
	// Define Singleton Pattern
	//=====================================================================================
	private static DistanceRev2mSensor _instance = new DistanceRev2mSensor();
	
	public static DistanceRev2mSensor getInstance() {
		return _instance;
	}

	// private constructor for singleton pattern
	private DistanceRev2mSensor() {	
		_distanceSensor = new VL53L0X(RobotMap.I2C_SENSOR_PORT, 0x29);
		boolean isSensorPresent = _distanceSensor.doInitialize();

		SmartDashboard.putBoolean("VL53LOX:isSensorPresent", isSensorPresent);

		Thread t = new Thread(() -> {
			while (!Thread.interrupted()) {
				long startTime = System.nanoTime();
				_distanceToTargetInInches = _distanceSensor.getDistance(DistanceUnit.INCH);
				_didTimeoutOccur = _distanceSensor.didTimeoutOccur();
				long estimatedTime = System.nanoTime() - startTime;
				SmartDashboard.putNumber("VL53LOX:measuringTIME(milli)", estimatedTime/1000000);
			}
		});
		t.start();
		
	}

	public void updateDashboard(){
		SmartDashboard.putNumber("VL53LOX:DistanceInInches", get_distanceToTargetInInches());
		SmartDashboard.putBoolean("VL53LOX:didTimeoutOccur", _didTimeoutOccur);
		
	}
	
  	public void updateLogData(LogDataBE logData) {
	}

	@Override
	public double get_distanceToTargetInInches() {
		return GeneralUtilities.roundDouble(_distanceToTargetInInches, 2);
	}

}