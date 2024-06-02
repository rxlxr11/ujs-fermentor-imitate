package com.rxlxr.fermentor.pubandsub;

import com.rxlxr.mqtt.PubAndSub;
import com.rxlxr.mqtt.entities.Data;
import com.rxlxr.mqtt.entities.TargetData;
import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static com.rxlxr.fermentor.MainApp.DeviceName;
import static com.rxlxr.fermentor.MainApp.pubAndSub;

@AllArgsConstructor
public class PubData extends Thread{


    private com.rxlxr.fermentor.entities.Data rawData;

    public void run() {


            try {

                com.rxlxr.mqtt.entities.Data newData = new Data();
                newData.setPh(rawData.getPH());
                newData.setTemp(rawData.getTemp());
                newData.setOxygen(rawData.getDO());
                newData.setBubble(rawData.getBubble());
                newData.setAcidSet(rawData.getAcidSet());
                newData.setAlkaliSet(rawData.getAlkaliSet());
                newData.setControlWay(rawData.getControlWay());
                newData.setFrozeSet(rawData.getFrozeSet());
                newData.setStirSet(rawData.getStirSet());
                newData.setSystemState(rawData.getSystemState());
                newData.setHeatSet(rawData.getHeatSet());
                String topic = "/sys/h63zZgUId8q/"+ DeviceName+ "/thing/event/property/post";
                String dataTopic = "/h63zZgUId8q/"+ DeviceName + "/user/prop";

                TargetData d = new TargetData("remote01",DeviceName,newData);

                pubAndSub.publish(topic, newData);
                pubAndSub.publish(dataTopic, d);



            } catch (Exception e) {
                System.out.println(e);
            }




    }
}
