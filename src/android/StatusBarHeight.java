package com.plugin.statusbarHeight;

import android.content.Context;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class StatusBarHeight extends CordovaPlugin {

    @Override
    public boolean execute(String action,JSONArray args,  CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            // String message = args.getString(0);
            this.coolMethod(callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(CallbackContext callbackContext) {

        Context context = this.cordova.getActivity().getApplicationContext();
        int height = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            height = context.getResources().getDimensionPixelSize(resourceId);
        }
        callbackContext.success(this.px2dip(height, context));
    }

    private String px2dip(int px, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return (px / density) + "";
    }
}
