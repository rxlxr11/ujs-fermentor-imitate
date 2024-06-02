import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Test parsing an FCL file
 * @author pcingola@users.sourceforge.net
 */
public class TestTipper {
    public static void main(String[] args) throws Exception {
        // Load from 'FCL' file
        String fileName = "D:\\java\\IDEA\\Fermentor\\src\\main\\resources\\fcl\\example.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) {
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Show


        // Set inputs
        fis.setVariable("service", 7.5);
        fis.setVariable("food", 7.5);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart

        // Show output variable
        System.out.println("Output value:" + fis.getVariable("tip").getValue());
    }
}
