package frc.robot.Subsystems.Intake;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    IntakeIO io = new IntakeIOSim();
    IntakeIOInputsAutoLogged inputs = new IntakeIOInputsAutoLogged();  
    

    public Command setVoltageCommand(double volts) {
        return runOnce(() -> io.setVoltage(volts));
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Intake", inputs);
    }
}