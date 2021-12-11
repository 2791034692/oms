package oms.view;

import android.view.View;
import android.view.ViewGroup;

import oms.ability.UIAbility;

public class UIList extends UIGroup {

    public UIList(UIAbility ability) {
        super(ability);
    }

    @Override
    public View newView() {
        return null;
    }

    @Override
    public ViewGroup getView() {
        return super.getView();
    }
}
