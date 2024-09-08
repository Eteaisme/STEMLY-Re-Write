package frc.robot.Subsystems.Intake;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import com.revrobotics.CANSparkMax;
import com.revrobotics.REVPhysicsSim;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import frc.robot.Constants.kIntake;

public class IntakeIOSim implements IntakeIO {
    private double intakeAppliedVolts = 0.0; 
    DCMotorSim intakeMotorSim = new DCMotorSim(DCMotor.getNEO(1), 4, 0.001); 

    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        intakeMotorSim.update(0.020);
    }


    @Override
    public void setVoltage(double volts) {
        intakeAppliedVolts = volts; 
        intakeMotorSim.setInputVoltage(intakeAppliedVolts);
        

    }
    
}
