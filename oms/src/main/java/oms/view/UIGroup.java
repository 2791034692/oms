package oms.view;

import android.view.ViewGroup;
import oms.ability.UIAbility;

public abstract class UIGroup extends UIView {
     
     ViewGroup.LayoutParams layoutParams;
     public UIGroup(UIAbility ability) {
          super(ability);
     }
     public void putUIView(UIView uiView){
          uiView.setGroup(this);
          getView().addView(uiView.getView());
     }
     @Override
     public ViewGroup getView() {
          return (ViewGroup) super.getView();
     }
}
