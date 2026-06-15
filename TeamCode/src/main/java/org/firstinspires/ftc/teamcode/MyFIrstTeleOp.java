package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp(name="My First TeleOp")
public class MyFIrstTeleOp extends LinearOpMode{
    private DcMotor leftDrive;

@Override
public void runOpMode() {

    leftDrive = hardwareMap.get(DcMotor.class, "left_motor");

    waitForStart();

    while (opModeIsActive()) {
        leftDrive.setPower(-gamepad1.left_stick_y);
    }
}
}