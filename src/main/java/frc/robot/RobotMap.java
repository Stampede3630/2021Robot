package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;

public class RobotMap {
  public static final WPI_TalonSRX LEFT_FRONT = new WPI_TalonSRX(1);
  public static final WPI_TalonSRX LEFT_BACK = new WPI_TalonSRX(2);
  public static final WPI_TalonSRX RIGHT_FRONT = new WPI_TalonSRX(3);
  public static final WPI_TalonSRX RIGHT_BACK = new WPI_TalonSRX(4);

  public static final XboxController CONTROLLER = new XboxController(0);
}