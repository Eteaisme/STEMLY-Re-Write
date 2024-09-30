package frc.robot.Subsystems.Arm;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsytem extends SubsystemBase{
    private final ArmIO io = new ArmIOSim();
    private final ArmIOInputsAutoLogged inputs = new ArmIOInputsAutoLogged();    

    public Command setArmAngle(double angle) {
        return runOnce(()-> io.setSetpoint(angle));
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Arm", inputs);
    }
}
