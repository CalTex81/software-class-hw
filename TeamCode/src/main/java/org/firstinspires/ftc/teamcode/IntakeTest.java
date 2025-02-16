package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.intake.Spinner;
@TeleOp
public class IntakeTest extends LinearOpMode {

    Spinner spinner;

    @Override
    public void runOpMode() throws InterruptedException {
        spinner = new Spinner(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            controls();
            spinner.loop();
        }
    }

    public void controls() {
        if (gamepad1.a) {
//            spinner.setState(Spinner.State.FORWARD);

            if (spinner.getState() == Spinner.State.IDLE) {
                spinner.setState(Spinner.State.FORWARD);

            }
            else if (spinner.getState() == Spinner.State.FORWARD) {
                spinner.setState((Spinner.State.REVERSE));

            }
            else if (spinner.getState() == Spinner.State.REVERSE) {
                spinner.setState(Spinner.State.IDLE);
            }
        }
    }
}
