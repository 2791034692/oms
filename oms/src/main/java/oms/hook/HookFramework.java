package oms.hook;

import android.content.Context;
import java.io.IOException;
import oms.hook.content.HookApplication;
import oms.hook.content.HookManage;

public final class HookFramework extends HookManage {
    private static HookFramework hookFramework = null;
    Context context;
    HookFramework(Context context) throws IOException {
        super(context);
        this.context = context;
        hookFramework = this;
    }
    public static HookFramework getInstance(Context context) {
        if(hookFramework == null){
            try {
                hookFramework = new HookFramework(context);
            } catch (IOException e) {
                e.printStackTrace();
                System.gc();
                System.exit(0);
            }
        }
        return hookFramework;
    }
    public Object getNodeService(HookApplication application,String string){
        return null;
    }

    //当插件的注册表有action时
    public void install(Context context,String path){
        if(context == null){

        }else{

        }
    }
    //当插件的注册表没有action时，在1.2.6版本过期
    @Deprecated
    public void install(String path){
       this.install(null,path);
    }
    public void uninstall(String name){

    }







}
