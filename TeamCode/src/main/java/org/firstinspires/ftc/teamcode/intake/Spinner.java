package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Spinner {
    DcMotorEx motor;

    State state = State.IDLE;
    boolean firstRun = true;

    public Spinner(HardwareMap hardwareMap) {
            motor = hardwareMap.get(DcMotorEx.class, "intkSpinner");

        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setState(State state) {
        if(this.state != state) {
            this.state = state;
            firstRun = true;

        }
    }

    public State getState() {
        return state;
    }

    public void loop() {
        switch (state) {
            case IDLE: {
                if (firstRun) {
                    motor.setPower(0);
                }
            }
            break;
            case FORWARD: {
                if (firstRun) {
                    motor.setPower(1);
                }
            }
            break;
            case REVERSE: {
                if (firstRun) {
                    motor.setPower(-1);
                }
            }
            break;
        }
    }

    public enum State {
        IDLE,
        FORWARD,
        REVERSE
    }
}
