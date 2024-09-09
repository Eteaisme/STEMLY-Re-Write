package frc.robot.Subsystems.Intake;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;

public class IntakeIOSim implements IntakeIO {

    private double intakeAppliedVolts = 0.0; 
    DCMotorSim intakeMotorSim = new DCMotorSim(DCMotor.getNEO(1), 4, 0.001); 


    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        
        intakeMotorSim.update(0.020);

        inputs.intakeAppliedVolts = intakeAppliedVolts;
        inputs.intakeVelocityRadPerSec = intakeMotorSim.getAngularVelocityRadPerSec(); 
        inputs.intakeCurrentAmps = intakeMotorSim.getCurrentDrawAmps(); 
    }


    @Override
    public void setVoltage(double volts) {
        intakeAppliedVolts = volts; 
        intakeMotorSim.setInputVoltage(intakeAppliedVolts);
    }
}
