package net.agten.heatersimulator.domain.algorithm;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class FuzzyController implements ControllerAlgorithm{
    public FIS fis;
    public FunctionBlock fb;
    /**
     * The maximum result returned by the PID algorithm.
     */
    public final static short MAX_RESULT = 255;
    /**
     * The initial target ADC value.
     */
    public final static short INITIAL_TARGET_ADC = 830;

    /**
     * The gain of the proportional component.
     */
    private final short pGain;
    /**pGain
     * The gain of the integral component.
     */
    private final short iGain;
    /**
     * The gain of the differential component.
     */
    private final short dGain;

    /**
     * Integer by which to divide the algorithm's output.
     */
    private final short outputDivisor;

    /**
     * The target ADC value.
     */
    private short targetAdc;

    /**
     * The current integral state.
     */
    private short iState = 0;
    /**
     * The last seen ADC value.
     */
    private short lastAdc = 1024;

    /**
     * Constructs a new PID algorithm instance, using the given algorithm
     * parameters. The initial target ADC value is set to 830.
     *
     * @param pGain         the gain for proportional component of the algorithm
     * @param iGain         the gain for integral component of the algorithm
     * @param dGain         the gain for derivative component of the algorithm
     * @param outputDivisor integer by which to divide the algorithm's output
     */

    public FuzzyController(short pGain, short iGain, short dGain, short outputDivisor) {
        if (outputDivisor == 0) {
            throw new IllegalArgumentException("outputDivisor cannot be 0");
        }
        this.pGain = pGain;
        this.iGain = iGain;
        this.dGain = dGain;
        this.outputDivisor = outputDivisor;
        this.targetAdc = INITIAL_TARGET_ADC;
    }

    @Override
    public short nextValue(short curAdc) {

        String filename = "C:\\Users\\heni\\Desktop\\Tema3_2\\iaisc-2020-ssatr-31211-Futo-Henrietta\\tema-4\\HeaterSimulator\\src\\fuzzy_controller.fcl";
        this.fis = FIS.load(filename, true);

        if (this.fis == null) {
            System.err.println("Can't load file: '" + filename + "'");
            System.exit(1);
        }

        // Get default function block
        this.fb = this.fis.getFunctionBlock(null);
        // Set inputs
        fb.setVariable("error", this.targetAdc-curAdc);

        // Evaluate
        fb.evaluate();

        // Show output variable's chart
        return (short)fb.getVariable("result").defuzzify();
    }

    @Override
    public void setTargetAdc(short targetAdc) {
        this.targetAdc=targetAdc;
    }

}