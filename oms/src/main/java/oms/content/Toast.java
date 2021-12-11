package oms.content;

import android.view.View;

import oms.ability.ModAbility;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

public class Toast extends ModAbility {
     private android.widget.Toast toast1,toast = null;
     public static final int LONG_TIME = LENGTH_LONG;
     public static final int SHORT_TIME = LENGTH_SHORT;
     public Toast(){
          this.toast = android.widget.Toast.makeText(getContext(),null, LENGTH_SHORT);
          this.toast1 = android.widget.Toast.makeText(getContext(),null, LENGTH_LONG);
     }
     public void show(Object object){
          if(object instanceof CharSequence){
               toast.setText((CharSequence)object);
               toast.show();
               return;
          }
          toast.setText(object.toString());
          toast.show();
     }


     public void show(int t,Object object){
          if(t == LONG_TIME){
               if(object instanceof CharSequence){
                    toast1.setText((CharSequence)object);
                    toast1.show();
                    return;
               }
               toast1.setText(object.toString());
               toast1.show();
          }else if(t == SHORT_TIME){
               if(object instanceof CharSequence){
                    toast.setText((CharSequence)object);
                    toast.show();
                    return;
               }
               toast.setText(object.toString());
               toast.show();
          }

     }



}
