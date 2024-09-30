package frc.robot.Subsystems.Feeder;

import org.littletonrobotics.junction.AutoLog;

public interface FeederIO {
    @AutoLog
    public static class FeederIOInputs {
        public double feederVelocityRadPerSec = 0.0;
        public double feederAppliedVolts = 0.0;
        public double feederCurrentAmps = 0.0;
        public double feederTempCelsius = 0.0;

        public boolean feederSensorTriggered = false;
    }

    /* Updates the set of loggable inputs */
    public abstract void updateInputs(FeederIOInputs inputs);
    
    public abstract void setVoltage(double volts);

}
