package frc.robot.Subsystems.Arm;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import frc.robot.Constants.kArm;

public class ArmIOSim implements ArmIO{

    private final SingleJointedArmSim armSim = new SingleJointedArmSim(
        //Gearing
        DCMotor.getNeo550(2),
        //Gear Ratio
        (20*(74/22)),
        //Inertia 
        SingleJointedArmSim.estimateMOI(Units.inchesToMeters(kArm.ARM_LENGTH), kArm.ARM_MASS),
        kArm.ARM_LENGTH,
        Units.degreesToRadians(120),
        Units.degreesToRadians(200),
        false,
        0);



    @Override
    public void updateInputs(ArmIOInputs inputs) {
        armSim.update(0.02);

        inputs.armPosition = Rotation2d.fromRadians(armSim.getAngleRads()); 
    }

    @Override
    public void setVoltage(double volts) {
    }

    @Override
    public void setSetpoint(double angle) {
    }
    
}
