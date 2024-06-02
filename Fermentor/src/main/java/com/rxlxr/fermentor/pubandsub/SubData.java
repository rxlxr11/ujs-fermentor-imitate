package com.rxlxr.fermentor.pubandsub;

import com.rxlxr.mqtt.entities.Data;
import com.rxlxr.mqtt.entities.TargetData;

import static com.rxlxr.fermentor.MainApp.DeviceName;
import static com.rxlxr.fermentor.MainApp.pubAndSub;

public class SubData extends Thread{
    public void run() {

        pubAndSub.listen();


    }
}
