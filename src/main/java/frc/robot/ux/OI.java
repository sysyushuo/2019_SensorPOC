/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.ux;

import frc.robot.RobotMap;
import frc.robot.commands.chassis.DriveWithControllers;
import frc.robot.util.BeakXboxController;

/**
 * This class interfaces with the Driver/Operator Station 
 * 	Lead Student:
 */
public class OI {
    private BeakXboxController _driverController;
    private BeakXboxController _operatorController;
    
    //=====================================================================================
	// Define Singleton Pattern
	//=====================================================================================
	private static OI _instance = new OI();
	
	public static OI getInstance() {
		return _instance;
	}
	
	// private constructor for singleton pattern
	private OI() 
	{	
		// =========== Driver ======================================
		_driverController = new BeakXboxController(RobotMap.DRIVER_GAMEPAD_USB_PORT);
        //==========================================================

		// Driver Controller -> Command Mapping
		_driverController.leftStick.whileActive(new DriveWithControllers(_driverController.leftStick, _driverController.rightStick));
		_driverController.rightStick.whileActive(new DriveWithControllers(_driverController.leftStick, _driverController.rightStick));
 
		_driverController.leftStick.whenReleased(new DriveWithControllers(_driverController.leftStick, _driverController.rightStick));
		_driverController.rightStick.whenReleased(new DriveWithControllers(_driverController.leftStick, _driverController.rightStick));

        // =========== Operator ======================================
		_operatorController = new BeakXboxController(RobotMap.OPERATOR_GAMEPAD_USB_PORT);
		//==========================================================
    }
}
