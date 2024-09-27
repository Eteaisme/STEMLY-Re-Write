package frc.robot.Subsystems.Feeder;

import frc.robot.Constants.kFeeder;
import frc.robot.Constants.kIntake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.util.Units;

public class FeederIOReal implements FeederIO {
    CANSparkMax feeederMoter = new CANSparkMax(kIntake.kIntakeCANID, MotorType.kBrushless);
    RelativeEncoder moterEncoder = feeederMoter.getEncoder(); 
    @Override
    public void updateInputs(FeederIOInputs inputs) {
        inputs.feederVelocityRadPerSec = Units.rotationsPerMinuteToRadiansPerSecond(moterEncoder.getVelocity());
        inputs.feederAppliedVolts = feeederMoter.getAppliedOutput();
        inputs.feederCurrentAmps = feeederMoter.getOutputCurrent();
    }

    @Override
    public void setVoltage(double volts) {
        feeederMoter.setVoltage(volts);
    }
}