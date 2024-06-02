package com.rxlxr.mqtt.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Receive {
    private String TargetDevice;
    private  String  SourceDevice;
    private String Set;
    private Object prop;


}
