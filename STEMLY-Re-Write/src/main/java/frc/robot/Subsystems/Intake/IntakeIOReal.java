package frc.robot.Subsystems.Intake;



import frc.robot.Constants.kIntake;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.util.Units; 

public class IntakeIOReal implements IntakeIO{
    /*Create a new sparkmax and motor encoder object */
    CANSparkMax intakeMoter = new CANSparkMax(kIntake.kIntakeCANID, MotorType.kBrushless); 
    RelativeEncoder moterEncoder = intakeMoter.getEncoder(); 

    /*Periodicly get the inputs from the motor*/
    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        inputs.intakeAppliedVolts = intakeMoter.getAppliedOutput();
        inputs.intakeCurrentAmps = intakeMoter.getOutputCurrent();
        inputs.intakeVelocityRadPerSec = Units.rotationsPerMinuteToRadiansPerSecond(moterEncoder.getVelocity()); 
    }


    /*Set the motor voltage*/
    @Override
    public void setVoltage(double volts) {
        intakeMoter.setVoltage(volts);
    }
   
    

}
