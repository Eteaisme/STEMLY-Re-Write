package frc.robot.Subsystems.Intake;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class IntakeSubsystem extends SubsystemBase {
    /*Creates a new intake sim object */
    IntakeIO io = new IntakeIOSim();
    IntakeIOInputsAutoLogged inputs = new IntakeIOInputsAutoLogged();  
    
    /*Sets the voltage to the sim moter */
    public Command setVoltageCommand(double volts) {
        return runOnce(() -> io.setVoltage(volts));
    }
    /*Returns sensor status */
    public Trigger sensorTrigger() {
        return new Trigger(() -> inputs.intakeSensorTriggered).debounce(0);
    }
    /*Perodicly updates the simulation */
    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Intake", inputs);
    }
}