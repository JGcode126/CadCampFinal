package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;



public class DuckSpinners {

    CRServo spinner;

    public DuckSpinners(HardwareMap hardwareMap){
        spinner = hardwareMap.get(CRServo.class, "duckspinner");
    }


    public void spinBlue(){
        spinner.setPower(-1);
    }

    public void spinRed(){
        spinner.setPower(1);
    }

    public void stop(){
        spinner.setPower(0);
    }
}