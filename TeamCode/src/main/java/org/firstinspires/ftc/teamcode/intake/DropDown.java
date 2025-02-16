package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class DropDown {

    Servo intkArm;
    State myState = State.IDLE;
    public DropDown (HardwareMap hardwareMap) {

        intkArm = hardwareMap.get(Servo.class, "intkArm");

    }

    public void setState (State newState) {
        if (this.myState != newState) {
            if (newState == State.IDLE) {
                intkArm.setPosition(0.13);
            } else if (newState == State.DROPPED) {
                intkArm.setPosition(0.33);
            }
        }

    }

    public State getMyState() {
        return myState;
    }
    public enum State {
        IDLE,
        DROPPED
    }

}
