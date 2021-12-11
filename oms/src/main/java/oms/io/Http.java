package oms.io;
import oms.ability.ModAbility;

public class Http<T> extends ModAbility {
    private String cookie;
    private T callback;


    public void get(String url,boolean value,CallBack<T> callBack){
         
    }
    public <T extends Object> T get(String url,boolean value){
        this.get(url,false,null);
        return (T)callback;
    }
    //直接get，不需要cookie，与回调参数
    public <T extends Object> T get(String url){
        this.get(url,false);
        return (T)callback;
    }
    public void post(){

    }
    public interface CallBack<T>{
        void onFailed(Json json);
        void onSuccess(T callback);
    }
}
