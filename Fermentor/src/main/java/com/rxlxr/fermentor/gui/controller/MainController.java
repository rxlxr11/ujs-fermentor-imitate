package com.rxlxr.fermentor.gui.controller;

import com.rxlxr.fermentor.pubandsub.PubData;
import com.rxlxr.fermentor.fuzzy.FuzzyLogic;
import com.rxlxr.fermentor.gui.Dialog;
import com.rxlxr.fermentor.imitate.ImitateFermentor;
import com.rxlxr.fermentor.pubandsub.SubData;
import com.rxlxr.mqtt.PubAndSub;
import com.rxlxr.mqtt.entities.Product;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.rxlxr.fermentor.MainApp.*;

public class MainController {


    @FXML
    public String test;
    @FXML
    private Button openButton;

    @FXML
    private Button closeButton;

    @FXML
    private MenuItem subTopic;

    @FXML
    private MenuItem device;

    @FXML
    private MenuItem inform;

    @FXML
    private Label temp;

    @FXML
    private Label oxygen;

    @FXML
    private Label bubble;

    @FXML
    private Label systemState;

    @FXML
    private Label controlWay;

    @FXML
    private Label ph;

    @FXML
    private Label heatSet;

    @FXML
    private Label acidSet;

    @FXML
    private Label frozeSet;

    @FXML
    private Label stirSet;

    @FXML
    private Label alikaliSet;

    @FXML
    private DialogPane deviceDialog;

    @FXML
    private TextField deviceName;

    @FXML
    private TextField deviceSecret;

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;


    public void initialize(){




    }


    @FXML
    void confirmDevice(ActionEvent event) throws Exception{

        try {
            if ( pubAndSub == null){

                DeviceSecret = deviceSecret.getText();
                DeviceName = deviceName.getText();

                Product product_fermentor = new Product(DeviceName,DeviceSecret);
                pubAndSub = new PubAndSub(product_fermentor);

                pubAndSub.connect();

                Dialog.info("success");
                pubAndSub.listen();
                if (imitateFermentor.isShutdown() || imitateFermentor.isTerminated()) {
                    imitateFermentor = Executors.newSingleThreadScheduledExecutor();
                }
                pubData.scheduleAtFixedRate(new PubData(data), 0, 10, TimeUnit.SECONDS);


            }else if(!pubAndSub.client.isConnected() ){

                DeviceSecret = deviceSecret.getText();
                DeviceName = deviceName.getText();
                Product product_fermentor = new Product(DeviceName,DeviceSecret);
                pubAndSub = new PubAndSub(product_fermentor);
                pubAndSub.connect();
                Dialog.info("success");
                if (subData.isShutdown() || subData.isTerminated()) {
                    subData = Executors.newFixedThreadPool(4);
                }
                subData.submit(new SubData());
                if (imitateFermentor.isShutdown() || imitateFermentor.isTerminated()) {
                    imitateFermentor = Executors.newSingleThreadScheduledExecutor();
                }
                pubData.scheduleAtFixedRate(new PubData(data), 0, 10, TimeUnit.SECONDS);

            }else {
                Dialog.info("请先关机");
            }
            deviceDialog.setVisible(false);
        }catch (MqttException ex){

            System.out.println("reason " + ex.getReasonCode());
            System.out.println("msg " + ex.getMessage());
            System.out.println("loc " + ex.getLocalizedMessage());
            System.out.println("cause " + ex.getCause());
            System.out.println("excep " + ex);
            Dialog.error(ex);
        }

    }
    @FXML
    void cancel(ActionEvent event) throws Exception{

        deviceDialog.setVisible(false);

    }


    @FXML
    void deviceSet(ActionEvent event) {

            deviceDialog.setVisible(true);
    }

    @FXML
    void informView(ActionEvent event) {

    }

    @FXML
    void openDevice(ActionEvent event) throws Exception {

        try {

            temp.setText(String.valueOf(data.getTemp()));
            ph.setText(String.valueOf(data.getPH()));
            oxygen.setText(String.valueOf(data.getDO()));
            bubble.setText(String.valueOf(data.getBubble()));
            acidSet.setText(String.valueOf(data.getAcidSet()));
            stirSet.setText(String.valueOf(data.getStirSet()));
            alikaliSet.setText(String.valueOf(data.getAlkaliSet()));
            frozeSet.setText(String.valueOf(data.getFrozeSet()));
            heatSet.setText(String.valueOf(data.getHeatSet()));
            systemState.setText(String.valueOf(data.getSystemState()));
            controlWay.setText(String.valueOf(data.getControlWay()));

            // 监听temp属性的变化，并更新Label的文本内容
            data.tempProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    Platform.runLater(() -> temp.setText(newValue.toString()));
                }
            });

            data.pHProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    Platform.runLater(() -> ph.setText(newValue.toString()));
                }
            });

            data.bubbleProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    Platform.runLater(() -> bubble.setText(newValue.toString()));
                }
            });

            data.DOProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    Platform.runLater(() -> oxygen.setText(newValue.toString()));
                }
            });

            data.heatSetProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    Platform.runLater(() -> heatSet.setText(newValue.toString()));
                }
            });

            data.frozeSetProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    System.out.println(newValue);
                    Platform.runLater(() -> frozeSet.setText(newValue.toString()));
                }
            });

            data.acidSetProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    Platform.runLater(() -> acidSet.setText(newValue.toString()));
                }
            });

            data.alkaliSetProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    Platform.runLater(() -> alikaliSet.setText(newValue.toString()));
                }
            });

            data.stirSetProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    Platform.runLater(() -> stirSet.setText(newValue.toString()));
                }
            });

            data.systemStateProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (newValue.equals("关机")){
                        close();
                    }
                    Platform.runLater(() -> systemState.setText(newValue));
                }
            });

            data.controlWayProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (newValue.equals("远程控制")){
                        fuzzyLogic.shutdown();
                    }else {
                        fuzzyLogic.scheduleAtFixedRate(new FuzzyLogic(data), 0, 10, TimeUnit.SECONDS);
                    }
                    Platform.runLater(() -> controlWay.setText(newValue));
                }
            });



            if (imitateFermentor.isShutdown() || imitateFermentor.isTerminated()) {
                imitateFermentor = Executors.newSingleThreadScheduledExecutor();
            }
            if (fuzzyLogic.isShutdown() || fuzzyLogic.isTerminated()) {
                fuzzyLogic = Executors.newSingleThreadScheduledExecutor();
            }
            imitateFermentor.scheduleAtFixedRate(new ImitateFermentor(data), 0, 2, TimeUnit.SECONDS);;

            fuzzyLogic.scheduleAtFixedRate(new FuzzyLogic(data), 0, 10, TimeUnit.SECONDS);

            Dialog.info("success");
            data.setSystemState("开机");

        }catch (Exception ex){

            ex.printStackTrace();
            Dialog.error(ex);
        }

    }


    void close(){
        try {
            imitateFermentor.shutdownNow();
            fuzzyLogic.shutdownNow();
            pubData.shutdownNow();
            //subData.shutdownNow();
            //pubAndSub.disconnect();
            data.setSystemState("关机");

        } catch (Exception e) {
            System.out.println(e);;
        }
    }
    @FXML
    void closeDevice(ActionEvent event) {
        try {
            close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void subTopicSet(ActionEvent event) {
        Dialog.subDialog();
    }



}
