package mas.ssatr.Bogdan.Dora.capsules;

import mas.ssatr.Bogdan.Dora.ports.EndPort;
import mas.ssatr.Bogdan.Dora.ports.Port2;
import mas.ssatr.Bogdan.Dora.statemachine.StateMachineB;

public class CapsB extends Capsule {

    EndPort endPort = new EndPort();
    Port2 port2 = new Port2();
    StateMachineB stateMachineB = new StateMachineB();
}