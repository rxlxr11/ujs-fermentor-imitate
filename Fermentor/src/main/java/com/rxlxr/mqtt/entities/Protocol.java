package com.rxlxr.mqtt.entities;

import com.rxlxr.mqtt.entities.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Protocol {

    private String method;
    private String id;
    private Object params;
    private String version;

}
