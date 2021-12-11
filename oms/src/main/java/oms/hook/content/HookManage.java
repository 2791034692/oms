package oms.hook.content;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import dalvik.system.DexClassLoader;
import oms.hook.io.Intent;
import oms.hook.node.HookCarrier;


public abstract class HookManage {
    private HashMap<String,DexClassLoader> classLoaderHashMap = new HashMap<>();
    private HashMap<String,HookAbility> abilityHashMap = new HashMap<>();
    private Context context;
    public HookManage(Context context) throws IOException {
        if(!getClass().getName().contains("oms.hook")||!getClass().getName().equals("oms.hook")){
            throw new IOException("Hook环境创建失败！");
        }
    }
    protected DexClassLoader buildDexClassLoader(String name){
        if(classLoaderHashMap.get(name) == null){
            DexClassLoader DexClassLoader = new DexClassLoader(name,context.getFilesDir().getPath()+"/模组/数据/"+name+"/dex/",null,ClassLoader.getSystemClassLoader());
            classLoaderHashMap.put(name,DexClassLoader);
            return DexClassLoader;
        }
        return classLoaderHashMap.get(name);
    }
    protected HookAbility buildHookAbility(String string,String ability) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(abilityHashMap.get("ability") == null){
            DexClassLoader classLoader = buildDexClassLoader(string);
            HookAbility ability1 = (HookAbility)classLoader.loadClass(ability).newInstance();
            abilityHashMap.put(ability,ability1);
            return ability1;
        }
        return abilityHashMap.get("ability");
    }

    protected HookAbility onStartHookAbility(String name, String ability, HookCarrier context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        HookAbility ability1 = buildHookAbility(name,ability);
        ability1.onStart(context);
        return ability1;
    }

    protected HookAbility onCreateHookAbility(String name, String ability, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
         HookAbility ability1 = buildHookAbility(name,ability);
         ability1.onIntent(intent);
         return ability1;
    }
    protected HookAbility onDestroyHookAbility(String name,String ability) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        HookAbility ability1 = buildHookAbility(name,ability);
        ability1.onDestroy();
        return ability1;
    }
    protected HookAbility onStopHookAbility(String name,String ability) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        HookAbility ability1 = buildHookAbility(name,ability);
        ability1.onStop();
        return ability1;
    }
    protected HookAbility onResumeHookAbility(String name,String ability) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        HookAbility ability1 = buildHookAbility(name,ability);
        ability1.onResume();
        return ability1;
    }
    protected void onCreateHookAbility(HookAbility ability,Intent intent) {
        ability.onIntent(intent);
    }
    protected void onDestroyHookAbility(HookAbility ability)  {
        ability.onDestroy();
    }
    protected void onStopHookAbility(HookAbility ability)  {
        ability.onStop();
    }
    protected void onResumeHookAbility(HookAbility ability)  {
        ability.onResume();
    }

    public Resources getResources(String apk){
        Resources resources = getHookResources(apk);
        if(resources == null){
            try {
                AssetManager assetManager = AssetManager.class.newInstance();
                Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);//反射调用方法addAssetPath(String path)
                //第二个参数是apk的路径：Environment.getExternalStorageDirectory().getPath()+File.separator+"plugin"+File.separator+"apkplugin.apk"
                //将未安装的Apk文件的添加进AssetManager中，第二个参数为apk文件的路径带apk名
                addAssetPath.invoke(assetManager, apk);
               Constructor constructor = getClass().getClassLoader().loadClass("android.content.res.Resources").getConstructor();
               constructor.setAccessible(true);
               return (Resources)constructor.newInstance();
            }catch (Exception exception){
                exception.printStackTrace();
            }
            return null;
        }
        return resources;
    }

    private Resources getHookResources(String apkPath) {
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);//反射调用方法addAssetPath(String path)
            //第二个参数是apk的路径：Environment.getExternalStorageDirectory().getPath()+File.separator+"plugin"+File.separator+"apkplugin.apk"
            //将未安装的Apk文件的添加进AssetManager中，第二个参数为apk文件的路径带apk名
            addAssetPath.invoke(assetManager, apkPath);
            Resources superRes = this.context.getResources();
            Resources mResources = new Resources(assetManager, superRes.getDisplayMetrics(), superRes.getConfiguration());
            return mResources;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
