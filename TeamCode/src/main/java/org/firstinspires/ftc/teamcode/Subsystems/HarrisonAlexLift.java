package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import android.graphics.Path;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HarrisonAlexLift {

    DcMotor lift;

    Servo claw;
    double last_error = 0;
    double integral = 0;
    public DcMotorSimple.Direction direction;

    ElapsedTime timer = new ElapsedTime();

    public HarrisonAlexLift(HardwareMap hardwareMap) {
        lift = hardwareMap.get(DcMotor.class, "lift");
        claw = hardwareMap.get(Servo.class, "claw");

    }

    public void reset() {
        lift.setTargetPosition(0);
    }

    public double scorePos() {
        lift.setTargetPosition(100);
        return lift.getCurrentPosition();
    }

    public void update(){
        direction = lift.getDirection();
    }

    public void up(){
        lift.setPower(0.5);
    }
    public void down(){
        lift.setPower(-0.5);
    }
    public void stop(){
        lift.setPower(0);
    }

    public void clawOpen(){
        claw.setPosition(0.3);
    }

    public void clawRing(){
        claw.setPosition(0.35);
    }

    public void clawPixel(){
        claw.setPosition(0.5);
    }


}





