package oms.hook.content;

import android.app.Application;
import oms.hook.HookFramework;

public class HookApplication extends Application {
    private HookFramework hookFramework;
    public HookApplication(){

    }
    public final void bindAbility(String node,HookAbility ability){
        
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
    //要求给予行动通行证
    public boolean requestAction(String action){
        return false;
    }
    //强制结束插件

    Object getNodeService(String string){
        return hookFramework.getNodeService(this,string);
    }
    void setHook(HookFramework hookFramework){
       this.hookFramework = hookFramework;
    }

    public HookFramework getHookFramework() {
        return hookFramework;
    }
}
