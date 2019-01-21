/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.I2C.Port;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
	// Drivers Station Gamepad USB Ports
	public static final int DRIVER_GAMEPAD_USB_PORT = 0;
	public static final int OPERATOR_GAMEPAD_USB_PORT = 1;
	public static final int ENGINEERING_GAMEPAD_USB_PORT = 2;
	public static final int ENGINEERING_GAMEPAD_B_USB_PORT = 3;
	
	// PCM Can Bus Address
	public static final int PCM_CAN_ADDR = 0;	
	
	// Motor Controller Can Bus Address
	//public static final int LEFT_DRIVE_MASTER_CAN_ADDR = 1;
	
	// DIO Ports
	//public static final int CARRIAGE_LIMIT_SWITCH_DIO_PORT = 0;
	
	// Analog Ports
	//public static final int STORED_PRESSURE_SENSOR_AIO_PORT = 0;	
	
	// NavX (on Roborio)
	public static final Port NAVX_PORT = Port.kOnboard;
	
	// PWM Ports on RoboRIO
	//public static final int CLIMBER_SERVO_PWM_ADDRESS = 0;
	
	// PCM Ports
	//public static final int CARRIAGE_SQUEEZE_PCM_PORT = 0;
}