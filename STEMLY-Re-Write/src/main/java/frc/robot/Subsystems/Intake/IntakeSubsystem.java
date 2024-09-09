package frc.robot.Subsystems.Intake;

import org.littletonrobotics.junction.Logger;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants.kIntake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    IntakeIO io = new IntakeIOSim();
    IntakeIOInputsAutoLogged inputs = new IntakeIOInputsAutoLogged();  
    /*Create Intake Moter Object */
    // private final CANSparkMax intakeMoter = new CANSparkMax(kIntake.kIntakeCANID, MotorType.kBrushless);
   
    
    /* Set Voltage Command */
    public Command setVoltageCommand(double volts) {
        return runOnce(() -> io.setVoltage(volts));
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Intake", inputs);
    }
}