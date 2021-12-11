package oms.view;

import android.view.View;
import android.widget.TextView;
import oms.ability.UIAbility;
public class UIText extends UIView {
    public UIText(UIAbility ability){
         super(ability);
    }
    @Override
    public View newView() {
        return new androidx.appcompat.widget.AppCompatTextView(getContext()){

        };
    }


}
