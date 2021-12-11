package oms.ability;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import oms.content.Binder;


public class ServiceAbility extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return onIntent((oms.content.Intent) intent);
    }

    public Binder onIntent(oms.content.Intent intent){
        return null;
    }
    public int dip2px(float dpValue) {
        float scale = this.getResources().getDisplayMetrics().density;
        return  (int)(dpValue * scale + 0.5f);
    }

}
