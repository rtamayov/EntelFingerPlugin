package pe.entel.cordova.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FourFingerActivity extends Activity {
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	@Override
    public void onBackPressed() {
		Intent i = new Intent();
        i.putExtra("base64String", "PRUEBA!!!!");
        setResult(Activity.RESULT_OK, i);
        finish();
    }


}
