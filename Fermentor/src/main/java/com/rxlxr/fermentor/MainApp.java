package com.rxlxr.fermentor;

import com.rxlxr.fermentor.entities.Data;
import com.rxlxr.fermentor.gui.controller.MainController;

import com.rxlxr.fermentor.pubandsub.SubData;
import com.rxlxr.mqtt.PubAndSub;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class MainApp extends Application {


    public static PubAndSub pubAndSub ;
    public static Data data;
    public static String DeviceName ;
    public static String DeviceSecret ;
    public static ScheduledExecutorService imitateFermentor = Executors.newSingleThreadScheduledExecutor();
    public static ScheduledExecutorService fuzzyLogic = Executors.newSingleThreadScheduledExecutor();
    public static ScheduledExecutorService pubData = Executors.newSingleThreadScheduledExecutor();
    public static ExecutorService subData = Executors.newFixedThreadPool(4);
    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage){
        try {
            data = new Data();
            data.setSystemState("关机");
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainPane.fxml"));
            Scene scene = new Scene(root, 550, 400);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle("发酵罐仿真软件");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
