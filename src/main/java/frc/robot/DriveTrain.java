package frc.robot;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import com.kauailabs.navx.frc;

public class DriveTrain {
  DriveTrain instance = new DriveTrain();

  private static final SpeedControllerGroup MOTORS_LEFT = new SpeedControllerGroup(RobotMap.LEFT_BACK,
      RobotMap.LEFT_FRONT);
  private static final SpeedControllerGroup MOTORS_RIGHT = new SpeedControllerGroup(RobotMap.RIGHT_BACK,
      RobotMap.RIGHT_FRONT);

  private static final DifferentialDrive DRIVE = new DifferentialDrive(MOTORS_LEFT, MOTORS_RIGHT);

  public static void arcadeDrive() {
    double speed = -RobotMap.CONTROLLER.getY(Hand.kLeft);
    double rotation = RobotMap.CONTROLLER.getX(Hand.kRight);

    System.out.println(rotation);

    // Using square values for better sensitivity in low values
    DRIVE.arcadeDrive(speed, rotation, true);
  }
}
