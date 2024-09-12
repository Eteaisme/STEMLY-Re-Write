package frc.robot.Subsystems.Feeder;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;

public class FeederIOSim implements FeederIO{

    private double feederAppliedVolts = 0.0; 
    DCMotorSim feederMoterSim = new DCMotorSim(DCMotor.getNEO(1), 5, 0.001); 


    @Override
    public void updateInputs(FeederIOInputs inputs) {
        
        feederMoterSim.update(0.020);

        inputs.feederAppliedVolts = feederAppliedVolts;
        inputs.feederVelocityRadPerSec  = feederMoterSim.getAngularVelocityRadPerSec(); 
        inputs.feederCurrentAmps = feederMoterSim.getCurrentDrawAmps(); 
    }


    @Override
    public void setVoltage(double volts) {
        feederAppliedVolts = volts; 
        feederMoterSim.setInputVoltage(feederAppliedVolts);
    }
}
