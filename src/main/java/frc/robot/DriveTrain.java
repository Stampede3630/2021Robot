package frc.robot;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain {
  private static final SpeedControllerGroup MOTORS_LEFT = new SpeedControllerGroup(RobotMap.LEFT_BACK,
      RobotMap.LEFT_FRONT);
  private static final SpeedControllerGroup MOTORS_RIGHT = new SpeedControllerGroup(RobotMap.RIGHT_BACK,
      RobotMap.RIGHT_FRONT);

  private static final DifferentialDrive DIFFERENTIAL_DRIVE = new DifferentialDrive(MOTORS_LEFT, MOTORS_RIGHT);

  public static void drive() {
    double speed = RobotMap.CONTROLLER.getY(Hand.kLeft);
    double rotation = RobotMap.CONTROLLER.getX(Hand.kRight);

    if (Math.abs(speed) < 0.1)
      speed = 0;
    if (Math.abs(rotation) < 0.1)
      rotation = 0;

    // Using square values for better sensitivity in low values
    DIFFERENTIAL_DRIVE.arcadeDrive(speed, rotation, true);
  }
}
