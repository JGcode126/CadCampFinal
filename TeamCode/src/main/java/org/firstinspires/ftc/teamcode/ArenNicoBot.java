/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.ArenNicoLift;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.DuckSpinners;


@TeleOp(name="Aren and Nico Robot", group="Iterative OpMode")
public class ArenNicoBot extends OpMode
{
    Drivetrain dt;
    DuckSpinners duckSpinners;
    ArenNicoLift lift;
    public boolean BlueAlliance;

    @Override
    public void init() {
        dt = new Drivetrain(hardwareMap);
        duckSpinners = new DuckSpinners(hardwareMap);
        lift = new ArenNicoLift(hardwareMap);
    }


    @Override
    public void init_loop() {

        if(gamepad1.right_bumper) BlueAlliance = false;
        if(gamepad1.left_bumper) BlueAlliance = true;

        lift.clawOpen();

        telemetry.addData("Are you on blue alliance?", BlueAlliance);
        telemetry.update();
    }


    @Override
    public void start() {

    }

    @Override
    public void loop() {
        dt.drive(gamepad1.left_stick_y, -gamepad1.left_stick_x, gamepad1.right_stick_x, gamepad1.right_trigger);

        if (gamepad1.left_trigger > 0.05){
            if (BlueAlliance) {
                duckSpinners.spinBlue();
            }
            if (!BlueAlliance) {
                duckSpinners.spinRed();
            }

        } else {
            duckSpinners.stop();
        }

        if (gamepad1.dpad_up){
            lift.up();
        } else if (gamepad1.dpad_down){
            lift.down();
        } else {
            lift.stop();
        }

        if (gamepad1.y){
            lift.clawPixel();
        }

        if (gamepad1.b){
            lift.clawRing();
        }

        if (gamepad1.a){
            lift.clawOpen();
        }





    }


    @Override
    public void stop() {
    }

}
