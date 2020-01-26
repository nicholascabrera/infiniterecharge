/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public Drive m_drive;
  public DriveCommand m_drivecommand;

  public Joystick m_drivecontrol;



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    this.m_drivecontrol = new Joystick(Constants.OI_DRIVE_CONTROL);
    this.m_drive = new Drive();
    this.m_drivecommand = new DriveCommand((() -> this.m_drivecontrol.getRawAxis(0)),
        (() -> this.m_drivecontrol.getRawAxis(1)), this.m_drive);
  }

  private void configureButtonBindings() {
  }

  public Command getTeleopCommand() {
    // An ExampleCommand will run in autonomous
    return this.m_drivecommand;
  }
}