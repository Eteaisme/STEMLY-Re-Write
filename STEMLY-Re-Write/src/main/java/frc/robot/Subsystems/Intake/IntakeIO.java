package frc.robot.Subsystems.Intake;

import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO {
    @AutoLog
    public static class IntakeIOInputs {
        public double intakeVelocityRadPerSec = 0.0;
        public double intakeAppliedVolts = 0.0;
        public double intakeCurrentAmps = 0.0;
        public double intakeTempCelsius = 0.0;
    }

    /* Updates the set of loggable inputs */
    public abstract void updateInputs(IntakeIOInputs inputs);
    
    public abstract void setVoltage(double volts);

}
