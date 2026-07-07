package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="My First Autonomous")
public class MyFirstAutonomous extends LinearOpMode{
    // 1. Declare all 4 motors just like TeleOp
    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;

    //FUNCTIONS:
    public void driveForward(double power, long time) {
        frontLeft.setPower(power);
        backLeft.setPower(power);
        frontRight.setPower(power);
        backRight.setPower(power);

        sleep(time);

        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

    // Custom function to strafe right (use negative power to strafe left)
    public void strafeRight(double power, long time) {
        frontLeft.setPower(power);
        backLeft.setPower(-power);
        frontRight.setPower(-power);
        backRight.setPower(power);

        sleep(time);

        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }
    @Override
    public void runOpMode() {

        // 2. Map the hardware
        frontLeft = hardwareMap.get(DcMotor.class, "front_left_motor");
        backLeft = hardwareMap.get(DcMotor.class, "back_left_motor");
        frontRight = hardwareMap.get(DcMotor.class, "front_right_motor");
        backRight = hardwareMap.get(DcMotor.class, "back_right_motor");

        // Reverse left side motors
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the driver to press the PLAY button
        waitForStart();

        // 3. STEP-BY-STEP ROBOT INSTRUCTIONS GO HERE:
        /*
        // Step A: Drive forward at half speed
        frontLeft.setPower(0.5);
        backLeft.setPower(0.5);
        frontRight.setPower(0.5);
        backRight.setPower(0.5);

        // Step B: Keep driving for 2000 milliseconds (2 seconds)
        sleep(2000);

        // Step C: Stop all motors
        frontLeft.setPower(0.0);
        backLeft.setPower(0.0);
        frontRight.setPower(0.0);
        backRight.setPower(0.0); */

        driveForward(0.5, 1000);

        strafeRight(0.5, 1000);
    }
}
