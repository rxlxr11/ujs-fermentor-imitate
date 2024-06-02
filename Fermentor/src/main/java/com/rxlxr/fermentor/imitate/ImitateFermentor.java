package com.rxlxr.fermentor.imitate;

import com.rxlxr.fermentor.entities.Data;
import lombok.AllArgsConstructor;

import java.util.Timer;
import java.util.TimerTask;

@AllArgsConstructor

public class ImitateFermentor implements Runnable {

    private Data d;


    public void run() {
        try {

            heatImitate();
            frozeImitate();
            stirImitate();
            acidImitate();
            alkaliImitate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void heatImitate() {
        if ((d.getTemp() + d.getHeatSet() / 100)>-10 &&(d.getTemp() + d.getHeatSet() / 100)<140)
            d.setTemp(d.getTemp() + d.getHeatSet() / 100);
    }

    public void frozeImitate() {
        if ((d.getTemp() - d.getFrozeSet() / 100)>-10 &&(d.getTemp() - d.getFrozeSet() / 100)<140)
            d.setTemp(d.getTemp() - d.getFrozeSet() / 100);


    }

    public void acidImitate() {
        if ((d.getPH() - d.getAcidSet() / 100)>0 &&(d.getPH() - d.getAcidSet() / 100)<14)
            d.setPH(d.getPH() - d.getAcidSet() / 100);

    }

    public void alkaliImitate() {
        if ((d.getPH() + d.getAlkaliSet() / 100)>0 &&(d.getPH() + d.getAlkaliSet() / 100)<14)
            d.setPH(d.getPH() + d.getAlkaliSet() / 100);
    }

    public void stirImitate() {


        if ((d.getBubble() - d.getStirSet() / 100) > 0 && (d.getBubble() - d.getStirSet() / 100) < 100) {
            d.setBubble(d.getBubble() - d.getStirSet() / 100);
        }
        if ((d.getDO() + d.getStirSet() / 100) > 0 && (d.getDO() + d.getStirSet() / 100) < 100) {
            d.setDO(d.getDO() + d.getStirSet() / 100);
        }

    }

}
