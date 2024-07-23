package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Drivetrain {
    DcMotor motor1;
    DcMotor motor2;
    DcMotor motor3;
    DcMotor motor4;

    public IMU gyro;


    public Drivetrain(HardwareMap hardwareMap){
        motor1 = hardwareMap.get(DcMotor.class, "drivefl");
        motor2 = hardwareMap.get(DcMotor.class, "drivefr");
        motor3 = hardwareMap.get(DcMotor.class, "drivebl");
        motor4 = hardwareMap.get(DcMotor.class, "drivebr");
        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        motor4.setDirection(DcMotorSimple.Direction.REVERSE);


    }


   public void drive(double drive, double strafe, double turn, double slow){

        if (slow > 0.05){
            motor1.setPower((drive + strafe + turn) * -0.25);
            motor2.setPower((drive - strafe - turn) * -0.25);
            motor3.setPower((drive - strafe + turn) * -0.25);
            motor4.setPower((drive + strafe - turn) * -0.25);
        } else {
            motor1.setPower((drive + strafe + turn) * -0.75);
            motor2.setPower((drive - strafe - turn) * -0.75);
            motor3.setPower((drive - strafe + turn) * -0.75);
            motor4.setPower((drive + strafe - turn) * -0.75);
        }
    }

    public void driveHarrison(double drive, double strafe, double turn, double slow){

        if (slow > 0.05){
            motor1.setPower((drive + strafe + turn) * 0.25);
            motor2.setPower((drive - strafe - turn) * 0.25);
            motor3.setPower((drive - strafe + turn) * 0.25);
            motor4.setPower((drive + strafe - turn) * 0.25);
        } else {
            motor1.setPower((drive + strafe + turn) * 0.76);
            motor2.setPower((drive - strafe - turn) * 0.76);
            motor3.setPower((drive - strafe + turn) * 0.76);
            motor4.setPower((drive + strafe - turn) * 0.76);
        }
    }
}