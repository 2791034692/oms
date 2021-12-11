package oms.ability;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import oms.content.Intent;
import oms.view.UIView;

public abstract class FragmentAbility extends Fragment {
    private Intent intent = null;
    private View view = null;
    private LayoutInflater inflater;
    private ViewGroup group;

    public FragmentAbility(){

    }
    public FragmentAbility(Intent intent){
        this.intent = intent;
    }

     protected abstract void onIntent(Intent intent);

     public void setContentView(int t){
         this.view = inflater.inflate(t, group, false);
     }

     public void setContentView(View view){
         this.view = view;
     }


     public abstract Object onBind();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Object object = onBind();
        this.inflater = inflater;
        this.group = container;
        if(this.view == null) {
            if (object instanceof Integer) {
                this.view = inflater.inflate((int) object, container, false);
            } else if (object instanceof View) {
                this.view = (View) object;
            } else if (object instanceof UIView) {
                this.view = ((UIView) object).getView();
            }
        }
        return this.view;
    }

    public boolean onKeyDown(int keyCode) {
        return false;
    }


    public final <T extends View> T g(int var1) {
        View var10000 = this.view;
        return var10000 != null ? var10000.findViewById(var1) : null;
    }

    @Override
    public final void onStart() {
        super.onStart();
        onIntent(intent);
    }

    public final UIAbility getAbility(){
         return (UIAbility) getActivity();
     }
     public final void goAbility(Intent intent){
         getAbility().startAbility(intent);
     }
     public void lan(int t){
         getAbility().lan(t);
     }
    public int dip2px(float dpValue) {
        float scale = getAbility().getResources().getDisplayMetrics().density;
        return  (int)(dpValue * scale + 0.5f);
    }
}
