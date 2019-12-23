package bio.insolutions.veridium.entel.piloto.cordova.plugin.ui;

import android.graphics.RectF;
import android.widget.FrameLayout;

import com.veridiumid.sdk.core.biometrics.engine.IBiometricsEngine;
import com.veridiumid.sdk.imaging.CameraLayoutDecorator;
import com.veridiumid.sdk.imaging.CameraSamplingPolicy;
import com.veridiumid.sdk.imaging.model.ImageHolder;
import com.veridiumid.sdk.support.BaseImagingBiometricsActivity;

import java.util.List;

public class DefaultFourFBiometricsActivity extends BaseImagingBiometricsActivity {
    @Override
    protected FrameLayout getCameraLayout() {
        return null;
    }

    @Override
    protected List<CameraLayoutDecorator> createCameraLayoutDecorators() {
        return null;
    }

    @Override
    protected CameraSamplingPolicy getCameraPolicy() {
        return null;
    }

    @Override
    protected void configureBiometricEngine(IBiometricsEngine<ImageHolder, RectF[]> iBiometricsEngine) {

    }

    @Override
    public boolean isAutoStartEnabled() {
        return false;
    }


}
