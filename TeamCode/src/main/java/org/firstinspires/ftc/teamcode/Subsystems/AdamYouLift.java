package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class AdamYouLift {

    Servo lift;

    Servo clawL;
    Servo clawR;
    public int dropperStep = 1;
    ElapsedTime timer = new ElapsedTime();
    public AdamYouLift(HardwareMap hardwareMap){
        lift = hardwareMap.get(Servo.class, "lift");
        clawL = hardwareMap.get(Servo.class, "clawL");
        clawR = hardwareMap.get(Servo.class, "clawR");


    }

    public void initPos(){
        lift.setPosition(0);
        clawL.setPosition(0.5);
        clawR.setPosition(0.5);
    }
    public void initClaw(){
        clawL.setPosition(0.5);
        clawR.setPosition(0.5);
    }


    public void outPos(){
        lift.setPosition(0.365);
    }

    public void ring(){
        clawL.setPosition(0.4);
        clawR.setPosition(0.65);
    }

    public void pixel(){
        clawL.setPosition(0.26);
        clawR.setPosition(0.79);
    }

    public void dropper(boolean out, boolean pixel, boolean ring, boolean retract) {
        switch (dropperStep) {
            case 1:
                initPos();
                if (pixel) {
                    dropperStep = 2;
                    timer.reset();
                }
                if (ring) {
                    dropperStep = 3;
                }

                break;
            case 2:
                pixel();
                if (out) {
                    dropperStep = 4;
                }
                if (retract) {
                    dropperStep = 1;
                }
                break;
            case 3:
                ring();
                if (out) {
                    dropperStep = 4;
                }
                if (retract) {
                    dropperStep = 1;
                }

                break;

            case 4:
                outPos();
                if (retract){
                    timer.reset();
                    while(0.7 > timer.seconds()){
                        initClaw();
                        if( 0.7 < timer.seconds()){
                            dropperStep = 1;
                            return;
                        }

                    }
                }

                break;

        }

        }


   }