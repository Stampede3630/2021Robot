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
    // Making speed negative to have the light be in front
    // (it's more fun drive with the battery weight in the back)
    double speed = -RobotMap.CONTROLLER.getY(Hand.kLeft);
    double rotation = RobotMap.CONTROLLER.getX(Hand.kRight);
    
    // Compensating for not going straight
    // Not doing anything if robot is stationary
    // It is steering to the right and that's why
    // it is a negative value (turning to the left)
    // -0.18 just turned out to be a good value (trial and error)
    rotation += -0.18 * speed;

    // Using square values for better sensitivity in low values
    DRIVE.arcadeDrive(speed, rotation, true);
  }
}
