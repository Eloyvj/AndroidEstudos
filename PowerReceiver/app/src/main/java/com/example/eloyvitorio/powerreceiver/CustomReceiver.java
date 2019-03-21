package com.example.eloyvitorio.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID
            + ".ACTION_CUSTOM_BROADCAST";
    private String headsetOn = "";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();

        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected!";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = "Custom Broadcast Received";
                    break;
                case Intent.ACTION_HEADSET_PLUG:
                    if(headsetOn.equals("")){
                        toastMessage = "Headset pluged!";
                        headsetOn = "on";
                        break;
                    } else if (headsetOn.equals("on")) {
                        toastMessage = "Headset unpluged!";
                        headsetOn = "off";
                        break;
                    } else if (headsetOn.equals("off")){
                        toastMessage = "Headset pluged!";
                        headsetOn = "on";
                        break;
                    }
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
