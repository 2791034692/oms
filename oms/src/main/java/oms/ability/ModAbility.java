package oms.ability;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import oms.thread.UIThread;

public abstract class ModAbility extends Activity implements Ability {

    static Context baseContext;

    public Context getContext(){
        return baseContext;
    }

    public ModAbility(){

    }

    public int dip2px(float dpValue) {
      float scale = baseContext.getResources().getDisplayMetrics().density;
      return  (int)(dpValue * scale + 0.5f);
    }



    public void onUiThread(UIThread thread){
        runOnUiThread(thread);
    }
    @Override
    public final AssetManager getAssets() {
        return null;
    }
    @Override @Deprecated
    public final Context getBaseContext() {
        return null;
    }
    @Nullable
    @Override
    public final ActionBar getActionBar() {
        return null;
    }
    @Override @Deprecated
    public Window getWindow() { return null; }
    @Override @Deprecated
    public final void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
    }
    @Override @Deprecated
    public final boolean onTouchEvent(MotionEvent event) {
        return false;
    }
    @Override @Deprecated
    protected final void onStart() { }
    @Override @Deprecated
    protected final void onPause() { }
    @Override @Deprecated
    protected final void onRestart() { }
    @Override @Deprecated
    public final void onBackPressed() {
    }
    @Override @Deprecated
    public final void setContentView(int layoutResID) {
    }
    @Override @Deprecated
    public final void setContentView(View view) {
    }
    @Override @Deprecated
    public final void setContentView(View view, ViewGroup.LayoutParams params) {
    }
    @Deprecated
    public final  <T extends View> T findViewById(int id) {
        return null;
    }
    @Override @Deprecated
    protected final void onCreate(Bundle bundle) {}
    @Override @Deprecated
    public final void  onWindowFocusChanged(boolean hasFocus) {}
    @Override @Deprecated
    protected final void onDestroy(){}
    @Override @Deprecated
    protected final void onStop() {}
    @Override @Deprecated
    protected final void onResume() {}
    @Override @Deprecated
    protected final void onPostCreate(@Nullable Bundle savedInstanceState) {}
    @Override @Deprecated
    protected final void onNewIntent(Intent intent) { }
    @Override @Deprecated
    public final boolean onKeyDown(int keyCode, KeyEvent event) { return false; }
    @Override @Deprecated
    protected final void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { }
    @Override @Deprecated
    public final void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) { }
}
