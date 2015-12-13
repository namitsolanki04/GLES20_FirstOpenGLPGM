package com.example.namit.myapplication;

import android.opengl.GLSurfaceView;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


import static android.opengl.GLES20.*;

/**
 * Created by namit on 13-12-2015.
 */
public class FirstOpenGLProjectRenderer implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        glClearColor(1.0f,0.0f,0.0f,0.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        glViewport(0,0,width,height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {

        glClear(GL_COLOR_BUFFER_BIT);

      //  Log.e("namit","namit draw");

    }
}
