package com.rxlxr.mqtt;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;

class CryptoUtil {
    private static String hmac(String plainText, String key, String algorithm, String format) throws Exception {
        if (plainText == null || key == null) {
            return null;
        }

        byte[] hmacResult = null;

        Mac mac = Mac.getInstance(algorithm);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        mac.init(secretKeySpec);
        hmacResult = mac.doFinal(plainText.getBytes());
        return String.format(format, new BigInteger(1, hmacResult));
    }


    public static String hmacSha256(String plainText, String key) throws Exception {
        return hmac(plainText,key,"HmacSHA256","%064x");
    }
}

public class MqttSign {
    private String username = "";

    private String password = "";

    private String clientid = "";

    public String getUsername() { return this.username;}

    public String getPassword() { return this.password;}

    public String getClientid() { return this.clientid;}

    public void calculate(String productKey, String deviceName, String deviceSecret) {
        if (productKey == null || deviceName == null || deviceSecret == null) {
            return;
        }

        try {

            this.username = deviceName + "&" + productKey;

//            String timestamp = Long.toString(System.currentTimeMillis());
            String plainPasswd = "clientId" + productKey + "." + deviceName + "deviceName" +
                    deviceName + "productKey" + productKey + "timestamp" + "2524608000000";
            this.password = CryptoUtil.hmacSha256(plainPasswd, deviceSecret);

            //MQTT ClientId
            this.clientid = productKey + "." + deviceName + "|" + "timestamp=" + "2524608000000" +
                    ",_v=paho-java-1.0.0,securemode=3,signmethod=hmacsha256|";
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
