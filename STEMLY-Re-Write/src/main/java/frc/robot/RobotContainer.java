// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.Feeder.FeederSubsystem;
import frc.robot.Subsystems.Intake.IntakeSubsystem;

public class RobotContainer {
  /* CONTROLLERS */
  CommandXboxController controller = new CommandXboxController(0);

  

  /* SUBSYTEMS */
  IntakeSubsystem intakeSubsystem = new IntakeSubsystem(); 
  FeederSubsystem feederSubsystem = new FeederSubsystem(); 


  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    controller.a().onTrue(intakeSubsystem.setVoltageCommand(5));
    controller.a().onFalse(intakeSubsystem.setVoltageCommand(0));

    controller.b().onTrue(feederSubsystem.setVoltageCommand(5));
    controller.b().onFalse(feederSubsystem.setVoltageCommand(0));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}