// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.drivetrain;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;


import edu.wpi.first.wpilibj2.command.CommandBase;

public class drive extends CommandBase {
  private drivetrain drive;
  private DoubleSupplier throttle, steer;
  private BooleanSupplier slow;

  /** Creates a new drive. */
  public drive(drivetrain drive, DoubleSupplier throttle, DoubleSupplier steer, BooleanSupplier slow) {
    this.drive = drive;
    this.throttle = throttle;
    this.steer = steer;
    this.slow = slow;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (slow.getAsBoolean()){
      drive.manualDrive(throttle.getAsDouble(), steer.getAsDouble(), 0.2, 0.2, true);
    }
    else{
      drive.manualDrive(throttle.getAsDouble(), steer.getAsDouble(), 0.65, 0.4, true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
