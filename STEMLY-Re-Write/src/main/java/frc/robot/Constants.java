package frc.robot;

import edu.wpi.first.math.util.Units;

public class Constants {
   /*Drivetrain constants */
   public static final class kDrivetrain {

   }
   /*Arm Constants */
   public static final class kArm{
      public static final double ARM_LENGTH = Units.inchesToMeters(20);
      public static final double ARM_MASS = Units.lbsToKilograms(16.5);
   }
   /*Feeder Constants*/
   public static final class kFeeder{
      public static final int kFeederCANID = 1; 
   }

   /*Intake constants */
   public static final class kIntake {
      public static final int kIntakeCANID = 0; 
   }

}
