package com.microsoft.darksage.enabler;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class MyAccessibilityService extends AccessibilityService {
    public MyAccessibilityService() {
    }

    private String getEventType(AccessibilityEvent event) {

        switch (event.getEventType()) {


            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:

                return "TYPE_WINDOW_STATE_CHANGED";



        }

        return "default";

    }

    private String getEventText(AccessibilityEvent event) {

        StringBuilder sb = new StringBuilder();

        for (CharSequence s : event.getText()) {

            sb.append(s);

        }

        return sb.toString();

    }
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
//        Log.e("In accessibility", "Captured Event");

        if(getEventType(event) != "default") {
            Log.e("In accessibility", String.format(

                    "onAccessibilityEvent: [type] %s [class] %s [package] %s [time] %s [text] %s",

                    getEventType(event), event.getClassName(), event.getPackageName(),

                    event.getEventTime(), getEventText(event)));
        }
    }


    @Override
    public void onInterrupt() {
        Log.v("In accessibility", "Interupted");
    }

    @Override

    protected void onServiceConnected() {

        super.onServiceConnected();

        Log.e("In accessibility", "onServiceConnected");

        AccessibilityServiceInfo info = new AccessibilityServiceInfo();

        info.flags = AccessibilityServiceInfo.DEFAULT;

        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;

        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;

        setServiceInfo(info);

    }
}
