package oms.hook.content;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.Window;
import androidx.annotation.NonNull;
import oms.hook.io.Intent;
import oms.hook.node.HookCarrier;


public class HookAbility extends Activity {
     private HookApplication hookApplication;
     private HookCarrier context;
     public final Object getNodeService(String string){
          return getNodeService(getHookApplication(),string);
     }
     public HookApplication getHookApplication(){
          return null;
     }

     void onStart(HookCarrier context) {
          this.context = context;
     }

     private final Object getNodeService(HookApplication hookApplication, String string){
          return hookApplication.getNodeService(string);
     }
     public void onIntent(Intent intent) {

     }
     protected void onStop() {
          super.onStop();
     }
     public final LayoutInflater getLayoutInflater(){
          return LayoutInflater.from(context);
     }

     protected void onResume() {
          super.onResume();
     }
     void setHookApplication(HookApplication application){
          this.hookApplication = application;
     }
     public final HookAbility isHookAbility(Object object){
          if(object == null){
               return null;
          }else if(object instanceof HookAbility){
               return (HookAbility)object;
          }
          return null;
     }
     protected void onDestroy() {
          super.onDestroy();
     }

     public final Context getContext() {
          return context;
     }

     @Override
     public ClassLoader getClassLoader() {
          return context.getClassLoader();
     }

     @Override
     public Object getSystemService(@NonNull String name) {
          return context.getSystemService(name);
     }

     @Override
     public Resources.Theme getTheme() {
          return context.getTheme();
     }

     @Override
     public AssetManager getAssets() {
          return context.getAssets();
     }

     @Override
     public final Context getApplicationContext() {
          return context.getApplicationContext();
     }

     @Override
     public Window getWindow() {
          return ((Activity)context).getWindow();
     }
}
