package frc.robot.Subsystems.Feeder;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class FeederSubsystem extends SubsystemBase {
    FeederIO io = new FeederIOSim(); 
    FeederIOInputsAutoLogged inputs = new FeederIOInputsAutoLogged();     
    
    public Command setVoltageCommand(double volts) {
        return runOnce(() -> io.setVoltage(volts));
    }

    public Trigger sensorTrigger() {
        return new Trigger(() -> inputs.feederSensorTriggered).debounce(0);
    }
    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Feeder", inputs);
    }
}