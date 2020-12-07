package mas.ssatr.Bogdan.Dora.capsules;

import mas.ssatr.Bogdan.Dora.ports.EndPort;
import mas.ssatr.Bogdan.Dora.ports.Port1;
import mas.ssatr.Bogdan.Dora.statemachine.StateMachineA;

public class CapsA extends Capsule{

    EndPort endPort = new EndPort();
    Port1 port1 = new Port1();
    StateMachineA stateMachineA = new StateMachineA();
}