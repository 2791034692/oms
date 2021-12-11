package oms.hook.node;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

public class HookCarrier extends Activity implements HookNode {
    private Resources resources;
    private Context context;
    private ApplicationInfo applicationInfo;
    private PackageManager packageManager;
    public HookCarrier(ContextThemeWrapper context, PackageManager packageManager){
         this.context = context;
         this.packageManager = packageManager;
    }
    @Override
    public Resources.Theme getTheme() {
        return context.getTheme();
    }
    @Override
    public Resources getResources() {
        return resources;
    }
    @Override
    public Object getSystemService(@NonNull String name) {
        return context.getSystemService(name);
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return ((Activity)context).findViewById(id);
    }

    @Override
    public Window getWindow() {
        return ((Activity)context).getWindow();
    }

    @Override
    public final AssetManager getAssets() {
        return resources.getAssets();
    }

    @Override
    public ClassLoader getClassLoader() {
        return context.getClassLoader();
    }

    @NonNull
    @Override
    public String getLocalClassName() {
        return ((Activity)context).getLocalClassName();
    }


    @Nullable
    @Override
    public final ComponentName getCallingActivity() {
        return ((Activity)context).getCallingActivity();
    }

    @Nullable
    @Override
    public final File getExternalFilesDir(@Nullable String type) {
        return context.getExternalFilesDir(type);
    }

    @Override
    public PackageManager getPackageManager() {
        return packageManager;
    }


    @Override
    public  final  Context getBaseContext() {
        return ((Activity)context).getBaseContext();
    }



    @Override
    public final File getFilesDir() {
        return context.getFilesDir();
    }

    @Nullable
    @Override
    public Display getDisplay() {
        return context.getDisplay();
    }

    @Override
    public Context getApplicationContext() {
        return context.getApplicationContext();
    }


    @Override
    public Object get(String string) {
        return null;
    }

    @Override
    public void set() {

    }
}
