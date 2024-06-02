package com.rxlxr.mqtt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rxlxr.mqtt.entities.Data;
import com.rxlxr.mqtt.entities.Protocol;
import com.rxlxr.mqtt.entities.Receive;
import com.rxlxr.utils.AllToFloat;
import lombok.AllArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import static com.rxlxr.fermentor.MainApp.data;


@AllArgsConstructor
public class MessageArrive extends Thread{


    private String s;
    private MqttMessage mqttMessage;
    private Protocol protocol;
    public  void run() {
        System.out.println("Sub message");
        System.out.println("Topic : " + s);
        System.out.println(new String(mqttMessage.getPayload())); //打印输出消息payLoad
        String payLoad = new String(mqttMessage.getPayload());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Receive myData = objectMapper.readValue(payLoad, Receive.class);
            System.out.println(myData.getSet());
            switch (myData.getSet()){
                case "controlWay": data.setControlWay((String) myData.getProp());break;
                case "systemState": data.setSystemState((String) myData.getProp());break;
                case "heatSet":data.setHeatSet( AllToFloat.convertToFloat(myData.getProp()).floatValue());break;
                case "frozeSet":data.setFrozeSet( AllToFloat.convertToFloat(myData.getProp()).floatValue());break;
                case "stirSet":data.setStirSet( AllToFloat.convertToFloat(myData.getProp()).floatValue());break;
                case "acidSet":data.setAcidSet( AllToFloat.convertToFloat(myData.getProp()).floatValue());break;
                case "alkaliSet":data.setAlkaliSet(AllToFloat.convertToFloat(myData.getProp()).floatValue());break;
            }
            //data.setHeatSet();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
