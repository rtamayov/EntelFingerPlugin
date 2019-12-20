package bio.insolutions.veridium.entel.piloto.cordova.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

import android.content.res.Configuration;
import android.content.res.Resources;

import com.veridiumid.sdk.IVeridiumSDK;

public class FourFingerActivity extends Activity {

    private String package_name;
	private Resources resources;
	
	public Button button_capture;

	private IVeridiumSDK mBiometricSDK;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(getResourceId("layout/activity_fourfinger"));
		
		
		button_capture = (Button) findViewById(getResourceId("id/btn_presioname"));
		button_capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("XXX","Hole a Todes!!");
            }
        });
    }
	
	@Override
    public void onBackPressed() {
		Intent i = new Intent();
        i.putExtra("base64String", "PRUEBA!!!!");
        setResult(Activity.RESULT_OK, i);
        finish();
    }
	
	private int getResourceId (String typeAndName)
    {
        if(package_name == null) package_name = getApplication().getPackageName();
        if(resources == null) resources = getApplication().getResources();
        return resources.getIdentifier(typeAndName, null, package_name);
    }



}
