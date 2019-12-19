package bio.insolutions.veridium.entel.piloto.cordova.plugin;
// The native Toast API
import android.widget.Toast;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.Context;

import bio.insolutions.veridium.entel.piloto.cordova.plugin.FourFingerActivity;

public class EntelFinger extends CordovaPlugin {

  private CallbackContext scanCallbackContext;
  
  @Override
  public boolean execute(String action, JSONArray args,
    final CallbackContext callbackContext) {
      // Verify that the user sent a 'show' action
      if (!action.equals("getwsq")) {
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;
      }
	  scanCallbackContext = callbackContext;
	  
      try {
        JSONObject options = args.getJSONObject(0);
      } catch (JSONException e) {
        callbackContext.error("Error encountered: " + e.getMessage());
        return false;
      }


		Context appCtx = cordova.getActivity().getApplicationContext();
		Intent getwsqIntent = new Intent(appCtx, FourFingerActivity.class);
		cordova.startActivityForResult(this, getwsqIntent, 0);


					
      return true;
  }
  
  
   @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data)
    {
		if(data!=null){
            String resultado = (String) data.getExtras().get("base64String");
			scanCallbackContext.success(resultado);
        }else{
  
        }


    }
}