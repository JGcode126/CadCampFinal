package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class OliverSamLift {
    Servo lift;

    Servo clawL;
    Servo clawR;
    public int dropperStep = 1;
    ElapsedTime timer = new ElapsedTime();
    public OliverSamLift(HardwareMap hardwareMap){
        lift = hardwareMap.get(Servo.class, "lift");
        clawL = hardwareMap.get(Servo.class, "clawL");
        clawR = hardwareMap.get(Servo.class, "clawR");

    }

    public void initPos(){
        lift.setPosition(1);
        clawL.setPosition(0);
        clawR.setPosition(1);
    }
    public void initClaw(){
        clawL.setPosition(0);
        clawR.setPosition(1);
    }


    public void outPos(){
        lift.setPosition(0.75);
    }

    public void dropPos(){
        lift.setPosition(0.66);
    }

    public void ring(){
        clawL.setPosition(0.4);
        clawR.setPosition(0.85);
    }



    public void dropper(boolean out, boolean ring, boolean claw, boolean retract) {
        switch (dropperStep) {
            case 1:
                initPos();
                if (ring) {
                    dropperStep = 2;
                    timer.reset();
                }

                break;
            case 2:
                ring();
                if (out) {
                    dropperStep = 3;
                }
                if (retract) {
                    dropperStep = 1;
                }
                break;


            case 3:
                outPos();
                if (claw){
                    dropperStep = 4;
                }

                break;

            case 4:
                initClaw();
                dropPos();
                if (retract) {
                    dropperStep = 1;
                }
                break;

        }

    }



}
