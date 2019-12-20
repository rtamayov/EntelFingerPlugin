package bio.insolutions.veridium.entel.piloto.cordova.plugin;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.digitalpersona.uareu.Compression;
import com.digitalpersona.uareu.UareUException;
import com.digitalpersona.uareu.dpfj.CompressionImpl;
import com.veridiumid.sdk.BiometricResultsParser;
import com.veridiumid.sdk.IBiometricFormats;
import com.veridiumid.sdk.IBiometricResultsHandler;
import com.veridiumid.sdk.IVeridiumSDK;
import com.veridiumid.sdk.SDKInitializationException;
import com.veridiumid.sdk.VeridiumSDK;
import com.veridiumid.sdk.core.exception.LicenseException;
import com.veridiumid.sdk.defaultdata.VeridiumDataInitializer;
import com.veridiumid.sdk.fourf.FourFInterface;
import com.veridiumid.sdk.fourf.VeridiumFourFInitializer;
import com.veridiumid.sdk.fourfintegration.ExportConfig;
import com.veridiumid.sdk.support.help.ToastHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import android.content.res.Configuration;
import android.content.res.Resources;



public class FourFingerActivity extends Activity {

	public final String LOG_SEGUIMIENTO = "seguimientoLog";
    private String package_name;
	private Resources resources;
	
	public Button button_capture;

	private IVeridiumSDK mBiometricSDK;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(getResourceId("layout/activity_fourfinger"));
		
		preInitSDK();
		verificarPermisosAplicacion();
		
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
	
	 private void preInitSDK() {
        Context appContext = getApplicationContext();

        try {
            VeridiumSDK.init(appContext,
                    new VeridiumFourFInitializer(),
                    new VeridiumDataInitializer()
            );
        } catch (SDKInitializationException e) {
            e.printStackTrace();
        }
    }
	
	private static boolean tienePermisos(Context context, String... permisos) {
        if (context != null && permisos != null) {
            for (String permiso : permisos) {
                if (ActivityCompat.checkSelfPermission(context, permiso) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
	
    private void verificarPermisosAplicacion() {
        int TODOS_LOS_PERMISOS = 1;

        String[] PERMISOS = {
                Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.INTERNET, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // La versión de Android es igual o superior a Marshmallow (API 23), se solicitan los permisos necesarios.
            Log.d(LOG_SEGUIMIENTO, "Se solicitarán los persmisos necesarios");

            if (!tienePermisos(this, PERMISOS)) {
                ActivityCompat.requestPermissions(this, PERMISOS, TODOS_LOS_PERMISOS);
            } else {
                // En una oportunidad anterior se mostró la ventana de solicitud de permisos y fueron aceptados los solicitados.
                Log.d(LOG_SEGUIMIENTO, "Permisos ya aceptados anteriormente, cambiando de pantalla");
            }
        } else {
            // Por ser una versión anterior a Android Marshmallow (API 23), no es necesario solicitar permisos
            Log.d(LOG_SEGUIMIENTO, "No es necesario solicitar permisos por la versión de Android");
        }
    }



}
