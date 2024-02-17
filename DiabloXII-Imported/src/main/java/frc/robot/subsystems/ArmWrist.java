package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.generated.TunerConstants;

public class ArmWrist extends SubsystemBase{
    public TalonFX armWrist;


    public ArmWrist(){
        armWrist = new TalonFX(TunerConstants.kArmWristID, "CTRE Chain");
        armWrist.setNeutralMode(NeutralModeValue.Brake);
        var talonFXConfigs = new TalonFXConfiguration();
        var slot0Configs = talonFXConfigs.Slot0;
        slot0Configs.kS = 0.25;
        slot0Configs.kV = 0.12;
        slot0Configs.kA = 0.01;
        slot0Configs.kP = 4.8;
        slot0Configs.kI = 0;
        slot0Configs.kD = 0.1;

        var motionMagicConfigs = talonFXConfigs.MotionMagic;
        motionMagicConfigs.MotionMagicCruiseVelocity = 80;
        motionMagicConfigs.MotionMagicAcceleration = 160;
        motionMagicConfigs.MotionMagicJerk = 1600;

        armWrist.getConfigurator().apply(talonFXConfigs);
    }

    public void doMagic(int voltage, double position){
        final MotionMagicVoltage m_request = new MotionMagicVoltage(voltage);
        armWrist.setControl(m_request.withPosition(position));
    }
    
    public void doMagic(int voltage, int position){
        final MotionMagicVoltage m_request = new MotionMagicVoltage(voltage);
        armWrist.setControl(m_request.withPosition(position));
    } 

    public void setSpeedArmWrist(double speed){
        armWrist.set(speed);
    }

    public void pos1(){
        doMagic(0, 0.29);
    }

    public void pos2(){
        doMagic(0, -24.01);
    }

    public void pos3(){
        doMagic(0, -41.23);
    }

    public void stop(){
        setSpeedArmWrist(0);
    }
}
