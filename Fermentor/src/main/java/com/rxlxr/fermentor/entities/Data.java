package com.rxlxr.fermentor.entities;


import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
@NoArgsConstructor
public class Data {
    private FloatProperty temp = new SimpleFloatProperty(30.0f);
    private FloatProperty DO = new SimpleFloatProperty(50.0f);
    private FloatProperty pH = new SimpleFloatProperty(7.0f);
    private FloatProperty bubble = new SimpleFloatProperty(50.0f);
    private StringProperty controlWay = new SimpleStringProperty("本地控制");
    private StringProperty systemState = new SimpleStringProperty("开机");
    private FloatProperty heatSet = new SimpleFloatProperty(0);
    private FloatProperty acidSet = new SimpleFloatProperty(0);
    private FloatProperty frozeSet = new SimpleFloatProperty(0);
    private FloatProperty stirSet = new SimpleFloatProperty(0);
    private FloatProperty alkaliSet = new SimpleFloatProperty(0);


    // Getter 和 Setter 方法
    public float getTemp() {
        return temp.get();
    }

    public void setTemp(float value) {
        temp.set(value);
    }

    public FloatProperty tempProperty() {
        return temp;
    }

    public float getDO() {
        return DO.get();
    }

    public void setDO(float value) {
        DO.set(value);
    }

    public FloatProperty DOProperty() {
        return DO;
    }

    public float getPH() {
        return pH.get();
    }

    public void setPH(float value) {
        pH.set(value);
    }

    public FloatProperty pHProperty() {
        return pH;
    }

    public float getBubble() {
        return bubble.get();
    }

    public void setBubble(float value) {
        bubble.set(value);
    }

    public FloatProperty bubbleProperty() {
        return bubble;
    }



    public FloatProperty alkaliSetProperty() {
        return alkaliSet;
    }

    public float getAlkaliSet() {
        return alkaliSet.get();
    }

    public void setAlkaliSet(float value) {
        alkaliSet.set(value);
    }

    public float getHeatSet() {
        return heatSet.get();
    }

    public void setHeatSet(float value) {
        heatSet.set(value);
    }

    public FloatProperty heatSetProperty() {
        return heatSet;
    }

    public float getFrozeSet() {
        return frozeSet.get();
    }

    public void setFrozeSet(float value) {
        frozeSet.set(value);
    }

    public FloatProperty frozeSetProperty() {
        return frozeSet;
    }

    public float getStirSet() {
        return stirSet.get();
    }

    public void setStirSet(float value) {
        stirSet.set(value);
    }

    public FloatProperty stirSetProperty() {
        return stirSet;
    }

    public float getAcidSet() {
        return acidSet.get();
    }

    public void setAcidSet(float value) {
        acidSet.set(value);
    }

    public FloatProperty acidSetProperty() {
        return acidSet;
    }
    public String getControlWay() {
        return controlWay.get();
    }

    public void setControlWay(String value) {
        controlWay.set(value);
    }

    public StringProperty controlWayProperty() {
        return controlWay;
    }


    public String getSystemState() {
        return systemState.get();
    }

    public void setSystemState(String value) {
        systemState.set(value);
    }

    public StringProperty systemStateProperty() {
        return systemState;
    }

}


