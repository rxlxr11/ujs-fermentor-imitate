package com.rxlxr.fermentor.fuzzy;

import com.rxlxr.fermentor.entities.Data;
import lombok.AllArgsConstructor;
import net.sourceforge.jFuzzyLogic.FIS;

@AllArgsConstructor
public class FuzzyLogic extends Thread {
    private Data data;


    public void run() {
        // Load from 'FCL' file
        String fileName = "src/main/resources/fcl/fermentor.fcl";
        FIS fis = FIS.load(fileName, true);
        // Error while loading?
        if (fis == null) {
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }
        try {
            // Set inputs
            fis.setVariable("Temperature", data.getTemp());
            fis.setVariable("pH", data.getPH());
            fis.setVariable("Dissolved_Oxygen", data.getDO());
            fis.setVariable("Foam", data.getBubble());
            // Evaluate
            fis.evaluate();
            data.setHeatSet((float) fis.getVariable("Heating").getValue());
            data.setFrozeSet((float) fis.getVariable("Cooling").getValue());
            data.setAcidSet((float) fis.getVariable("Acid_Addition").getValue());
            data.setAlkaliSet((float) fis.getVariable("Alkali_Addition").getValue());
            data.setStirSet((float) fis.getVariable("Stirring").getValue());
            System.out.println(data.getHeatSet());
            System.out.println(data.getFrozeSet());
            System.out.println(data.getAcidSet());
            System.out.println(data.getAlkaliSet());
            System.out.println(data.getStirSet());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
