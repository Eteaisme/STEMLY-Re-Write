package frc.robot.Subsystems.Intake;



import frc.robot.Constants.kIntake;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DigitalInput; 

public class IntakeIOReal implements IntakeIO{
    /*Create a new sparkmax and motor encoder object */
    private final CANSparkMax intakeMoter = new CANSparkMax(kIntake.kIntakeCANID, MotorType.kBrushless); 
    private final RelativeEncoder moterEncoder = intakeMoter.getEncoder(); 
    private final DigitalInput intakeSensor = new DigitalInput(kIntake.kIntakeSensorID);
    /*Periodicly get the inputs from the motor*/
    @Override
    public void updateInputs(IntakeIOInputs inputs) {
        inputs.intakeAppliedVolts = intakeMoter.getAppliedOutput();
        inputs.intakeCurrentAmps = intakeMoter.getOutputCurrent();
        inputs.intakeVelocityRadPerSec = Units.rotationsPerMinuteToRadiansPerSecond(moterEncoder.getVelocity());
    
        inputs.intakeSensorTriggered = intakeSensor.get();
    }


    /*Set the motor voltage*/
    @Override
    public void setVoltage(double volts) {
        intakeMoter.setVoltage(volts);
    }
   
    

}
