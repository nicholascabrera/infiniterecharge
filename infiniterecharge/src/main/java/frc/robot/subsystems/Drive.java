/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */
public class Drive extends SubsystemBase {

  Spark frontLeftSpark;
  Spark backLeftSpark;
  Spark frontRightSpark;
  Spark backRightSpark;
  
  DifferentialDrive differentialDrive;

  public Drive() {

    frontLeftSpark = new Spark(Constants.DRIVE_FRONT_LEFT_SPARK);
    backLeftSpark = new Spark(Constants.DRIVE_BACK_LEFT_SPARK);
    frontRightSpark = new Spark(Constants.DRIVE_FRONT_RIGHT_SPARK);
    backRightSpark = new Spark(Constants.DRIVE_BACK_RIGHT_SPARK);

    SpeedControllerGroup leftMotors = new SpeedControllerGroup(frontLeftSpark, backLeftSpark);
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(frontRightSpark, backRightSpark);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(double xAxis, double yAxis) {
      this.differentialDrive.arcadeDrive(xAxis, yAxis);
  }
}