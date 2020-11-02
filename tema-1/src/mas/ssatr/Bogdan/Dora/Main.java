package mas.ssatr.Bogdan.Dora;

import mas.ssatr.Bogdan.Dora.simulator.Simulator;
import mas.ssatr.Bogdan.Dora.utils.JsonLoader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int steps = 15;
        JsonLoader jsonLoader = new JsonLoader();
        if (jsonLoader.loadJson("src/mas/ssatr/Bogdan/Dora/files/reteapetri.json")) {
            System.out.println("JSON successfully loaded!");

            try {
                FileWriter fileWriter = new FileWriter("src/mas/ssatr/Bogdan/Dora/files/simulationresults.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                Simulator simulator = new Simulator();
                simulator.setSteps(steps);
                simulator.simulatePetriNet(printWriter);
                printWriter.close();
            } catch (IOException var6) {
                var6.printStackTrace();
            }
        } else {
            System.out.println("JSON couldn't be loaded!");
        }

    }
}