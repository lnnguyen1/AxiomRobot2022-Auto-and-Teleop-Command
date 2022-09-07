package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class drivetrain extends SubsystemBase{
    private WPI_TalonFX leftMotor1, leftMotor2, rightMotor1, rightMotor2;
    private DifferentialDrive robotDrive;

    public drivetrain(){
        leftMotor1 = new WPI_TalonFX(0);
        leftMotor2 = new WPI_TalonFX(1);
        rightMotor1 = new WPI_TalonFX(2);
        rightMotor2 = new WPI_TalonFX(3);

        robotDrive = new DifferentialDrive(leftMotor1, rightMotor1);
    }

    public void manualDrive(double throttle, double steer, double maxSpeed, double maxturnSpeed, boolean squareInputs){
        if (squareInputs){
            throttle = Math.copySign(throttle * throttle, throttle);
            steer = Math.copySign(steer * steer, steer);
        }

        robotDrive.arcadeDrive(maxSpeed * throttle, maxturnSpeed * steer, false);
    }

    public void autonomousDrive(double speed, double turnSpeed){
        robotDrive.arcadeDrive(speed, turnSpeed, false);
    }

    public void autonomousTank( double leftSpeed, double rightSpeed){
        robotDrive.tankDrive(leftSpeed, rightSpeed);
    }

}
