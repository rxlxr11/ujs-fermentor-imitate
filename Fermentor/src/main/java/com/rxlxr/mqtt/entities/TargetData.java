package com.rxlxr.mqtt.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class TargetData{

    private String TargetDevice;
    private  String  SourceDevice;

    private Data prop;
}
