package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.generated.TunerConstants;

public class ArmIntake extends SubsystemBase{
    public TalonFX armIntake;

    public ArmIntake(){
        armIntake = new TalonFX(TunerConstants.kArmIntakeID, "CTRE Chain");

        armIntake.setNeutralMode(NeutralModeValue.Coast);
    }

    public void setSpeedArmIntake(double speed){
        armIntake.set(speed);
    }

    public void intaking(){
        setSpeedArmIntake(0.3);
    }

    public void outtaking(){
        setSpeedArmIntake(-0.3);
    }

    public void stop(){
        setSpeedArmIntake(0);
    }
}
