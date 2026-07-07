package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp(name="My First TeleOp")
public class MyFIrstTeleOp extends LinearOpMode{

    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;
    private DcMotor intake;

    private DcMotor platformMotor;

@Override
public void runOpMode() {

    frontLeft  = hardwareMap.get(DcMotor.class, "front_left_motor");
    backLeft   = hardwareMap.get(DcMotor.class, "back_left_motor");
    frontRight = hardwareMap.get(DcMotor.class, "front_right_motor");
    backRight  = hardwareMap.get(DcMotor.class, "back_right_motor");
    intake = hardwareMap.get(DcMotor.class, "intake_motor");
    platformMotor = hardwareMap.get(DcMotor.class, "platform_motor");

    frontLeft.setDirection(DcMotor.Direction.REVERSE);
    backLeft.setDirection(DcMotor.Direction.REVERSE);

    waitForStart();

    while (opModeIsActive()) {

        double y = -gamepad1.left_stick_y; // Forward/back
        double x = -gamepad1.left_stick_x;  // Strafing (sideways)
        double rx = -gamepad1.right_stick_x; // Turning

        // 2. Run the Mecanum Mix formula to combine the vectors
        frontLeft.setPower(y + x + rx);
        backLeft.setPower(y - x + rx);
        frontRight.setPower(y - x - rx);
        backRight.setPower(y + x - rx);

        //intake logic
        if (gamepad1.right_bumper) {
            intake.setPower(1.0);  // Spin inward at full speed
        } else if (gamepad1.left_bumper) {
            intake.setPower(-1.0); // Spin outward at full speed
        } else {
            intake.setPower(0.0);  // Stop spinning when no buttons are pressed
        }

        // Platform Control Logic
        if (gamepad1.dpad_up) {
            platformMotor.setPower(0.5);  // Move forward at half speed
        } else if (gamepad1.dpad_down) {
            platformMotor.setPower(-0.5); // Move backward at half speed
        } else {
            platformMotor.setPower(0.0);  // Stop when no buttons are pressed
        }
    }
}
}