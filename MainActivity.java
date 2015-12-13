package com.example.namit.myapplication;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView glSurfacView;
    private boolean renderSet=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfacView = new GLSurfaceView(this);

        ///// check device supports OpenGL 2.0 :O
        final ActivityManager activityManager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);

        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();

        final boolean supportEs2 = configurationInfo.reqGlEsVersion >= 0x20000;

        if(supportEs2==true)
        {
            Log.e("namit", "OpenGLES 2.0 support krta hai device ..Yahoo !!!!");

            glSurfacView.setEGLContextClientVersion(2);

            glSurfacView.setRenderer(new FirstOpenGLProjectRenderer());
            renderSet=true;

        }
        else
        {
            Toast.makeText(this,"This device does not support OpenGLEs 2.0. ",Toast.LENGTH_LONG);
        }


        //setContentView(R.layout.activity_main);
        setContentView(glSurfacView);
      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
     //   setSupportActionBar(toolbar);

     ///   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
     //   fab.setOnClickListener(new View.OnClickListener() {
          //  @Override
        //    public void onClick(View view) {
          //      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
              //          .setAction("Action", null).show();
          //  }
      //  });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onPause()
    {
        super.onPause();
        if(renderSet)
        {
            glSurfacView.onPause();
        }
    }

    protected void onResume()
    {
        super.onResume();
        if(renderSet)
        {
            glSurfacView.onResume();
        }
    }
}
