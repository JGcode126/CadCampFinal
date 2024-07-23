package org.firstinspires.ftc.teamcode.Subsystems;



import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class AnnieAlexDropper {
    Servo dropper;

    public AnnieAlexDropper(HardwareMap hardwareMap){
        dropper = hardwareMap.get(Servo.class,"dropper");
    }
    public void down(){
        dropper.setPosition(0.1);
    }
    public void up(){
        dropper.setPosition(0.7);
    }
    public void kinda(){
        dropper.setPosition(0.3);
    }
}
