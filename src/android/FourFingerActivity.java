package bio.insolutions.veridium.entel.piloto.cordova.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.content.res.Configuration;
import android.content.res.Resources;

public class FourFingerActivity extends Activity {

    private String package_name;
	private Resources resources;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(getResourceId("layout/activity_fourfinger"));
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
