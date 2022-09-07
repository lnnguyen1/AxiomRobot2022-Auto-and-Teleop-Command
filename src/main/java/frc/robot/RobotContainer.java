package frc.robot;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drivetrain;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.drive;

public class RobotContainer {
    private PS4Controller controller;
    private ParallelCommandGroup teleopCommand;
    private drivetrain driveTrain;

    public RobotContainer(){
        controller = new PS4Controller(0);
        //teleopCommand = new ParallelCommandGroup( new drive(driveTrain, ()-> -controller.getLeftY(), ()-> controller.getRightX(), ()-> controller.getRawButton(1)));
    }

    public Command getTeleopCommand() {
        return new drive(driveTrain, ()-> -controller.getLeftY(), ()-> controller.getRightX(), ()-> controller.getRawButton(1));
      }
}
