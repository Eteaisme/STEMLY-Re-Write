package frc.robot.Subsystems.Arm;

<<<<<<< HEAD
import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.geometry.Rotation2d;

public interface ArmIO {
    @AutoLog
    public static class ArmIOInputs {
        public Rotation2d armPosition = new Rotation2d();
        public Rotation2d armAbsolutePosition = new Rotation2d();

        public double armVelocityRadPerSec = 0.0;
        public double armAppliedVolts = 0.0;
    }

    public abstract void updateInputs(ArmIOInputs inputs);

    public abstract void setVoltage(double volts);

    public abstract void setSetpoint(double angle);
    
}


=======
public interface ArmIO {
    
}
>>>>>>> 9d4c50d235e39dba01b96e7b871028d045bd2e69
