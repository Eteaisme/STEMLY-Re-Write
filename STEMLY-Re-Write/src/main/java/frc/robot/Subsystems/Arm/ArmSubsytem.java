package frc.robot.Subsystems.Arm;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsytem extends SubsystemBase{
    private final ArmIO io = new ArmIOSim();
    private final ArmIOInputsAutoLogged inputs = new ArmIOInputsAutoLogged();    


    @Override
    public void periodic() {
        io.updateInputs(inputs);
    }
}
