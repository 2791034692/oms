package oms.view;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import oms.ability.UIAbility;

public abstract class UIView {
    public static final int GONE = View.GONE;
    public static final int VISIBLE = View.VISIBLE;
    public static final int INVISIBLE = View.INVISIBLE;
    public static final int LEFT = Gravity.LEFT;
    public static final int RIGHT = Gravity.RIGHT;
    public static final int TOP = Gravity.TOP;
    public static final int BOTTOM = Gravity.BOTTOM;
    public static final int CENTER = Gravity.CENTER;
    public static final int CENTER_HORIZONTAL = Gravity.CENTER_HORIZONTAL;
    public static final int CENTER_VERTICAL = Gravity.CENTER_VERTICAL;
    public static final int MATCH_PARENT = -1;
    public static final int WRAP_CONTENT = -2;
    private static final int BELOW = RelativeLayout.BELOW;
    private static final int ABOVE = RelativeLayout.ABOVE;
    private static final int LEFT_OF = RelativeLayout.LEFT_OF;
    private static final int RIGHT_OF = RelativeLayout.RIGHT_OF;
    private static final int ALIGN_TOP = RelativeLayout.ALIGN_TOP;
    private static final int ALIGN_BOTTOM = RelativeLayout.ALIGN_BOTTOM;
    private static final int ALIGN_LEFT = RelativeLayout.ALIGN_LEFT;
    private static final int ALIGN_RIGHT = RelativeLayout.ALIGN_RIGHT;
    private static final int ALIGN_PARENT_BOTTOM = RelativeLayout.ALIGN_PARENT_BOTTOM;
    private static final int ALIGN_PARENT_TOP = RelativeLayout.ALIGN_PARENT_TOP;
    private static final int ALIGN_PARENT_LEFT = RelativeLayout.ALIGN_PARENT_LEFT;
    private static final int ALIGN_PARENT_RIGHT = RelativeLayout.ALIGN_PARENT_RIGHT;
    private ViewGroup.MarginLayoutParams marginParams = null;


    private int ID = 0;
    public int dip2px(float dpValue) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return  (int)(dpValue * scale + 0.5f);
    }
    View view;
    UIAbility ability;
    int width;
    int height;
    UIGroup group  = null;
    public UIView(UIAbility ability) {
        this.ability = ability;
        this.view = newView();
        ID = View.generateViewId();
        this.view.setId(ID);
    }
    void setGroup(UIGroup group) {
        this.group = group;
    }
    public void setPadding(int left,int top,int right,int bottom){
        getView().setPadding(dip2px(left),dip2px(top),dip2px(right),dip2px(bottom));
    }
    public void setPaddingLeft(int left){
        getView().setPadding(dip2px(left),getView().getPaddingTop(),getView().getPaddingRight(),getView().getPaddingBottom());
    }
    public void setPaddingTop(int top){
        getView().setPadding(getView().getPaddingLeft(),dip2px(top),getView().getPaddingRight(),getView().getPaddingBottom());
    }
    public void setPaddingRight(int right){
        getView().setPadding(getView().getPaddingLeft(),getView().getPaddingTop(),dip2px(right),getView().getPaddingBottom());
    }
    public void setPaddingBottom(int bottom){
        getView().setPadding(getView().getPaddingLeft(),getView().getPaddingTop(),getView().getPaddingRight(),dip2px(bottom));
    }

    public void setMargins(int margins){
       if(group!=null){
           if(marginParams == null){
               ViewGroup.LayoutParams params = view.getLayoutParams();
               ViewGroup.MarginLayoutParams marginParams = null;
               //获取view的margin设置参数
               if (params instanceof ViewGroup.MarginLayoutParams) {
                   marginParams = (ViewGroup.MarginLayoutParams) params;
               } else {
                   //不存在时创建一个新的参数
                   //基于View本身原有的布局参数对象
                   marginParams = new ViewGroup.MarginLayoutParams(params);
               }
           }
           marginParams.leftMargin = dip2px(margins);
           marginParams.topMargin = dip2px(margins);
           marginParams.bottomMargin = dip2px(margins);
           marginParams.rightMargin = dip2px(margins);
           getView().setLayoutParams(marginParams);
       }
    }

    public void setMarginTop(int top){
        if(group!=null){
            if(marginParams == null){
                ViewGroup.LayoutParams params = view.getLayoutParams();
                ViewGroup.MarginLayoutParams marginParams = null;
                //获取view的margin设置参数
                if (params instanceof ViewGroup.MarginLayoutParams) {
                    marginParams = (ViewGroup.MarginLayoutParams) params;
                } else {
                    //不存在时创建一个新的参数
                    //基于View本身原有的布局参数对象
                    marginParams = new ViewGroup.MarginLayoutParams(params);
                }
            }
            marginParams.topMargin = dip2px(top);
            getView().setLayoutParams(marginParams);
        }
    }

    public  void setMarginLeft(int t){
        if(group!=null){
            if(marginParams == null){
                ViewGroup.LayoutParams params = view.getLayoutParams();
                ViewGroup.MarginLayoutParams marginParams = null;
                //获取view的margin设置参数
                if (params instanceof ViewGroup.MarginLayoutParams) {
                    marginParams = (ViewGroup.MarginLayoutParams) params;
                } else {
                    //不存在时创建一个新的参数
                    //基于View本身原有的布局参数对象
                    marginParams = new ViewGroup.MarginLayoutParams(params);
                }
            }
            marginParams.leftMargin = dip2px(t);
            getView().setLayoutParams(marginParams);
        }
    }

    public  void setMarginRight(int t){
        if(group!=null){
            if(marginParams == null){
                ViewGroup.LayoutParams params = view.getLayoutParams();
                ViewGroup.MarginLayoutParams marginParams = null;
                //获取view的margin设置参数
                if (params instanceof ViewGroup.MarginLayoutParams) {
                    marginParams = (ViewGroup.MarginLayoutParams) params;
                } else {
                    //不存在时创建一个新的参数
                    //基于View本身原有的布局参数对象
                    marginParams = new ViewGroup.MarginLayoutParams(params);
                }
            }
            marginParams.rightMargin = dip2px(t);
            getView().setLayoutParams(marginParams);
        }
    }

    public  void setMarginBottom(int t){
        if(group!=null){
            if(marginParams == null){
                ViewGroup.LayoutParams params = view.getLayoutParams();
                ViewGroup.MarginLayoutParams marginParams = null;
                //获取view的margin设置参数
                if (params instanceof ViewGroup.MarginLayoutParams) {
                    marginParams = (ViewGroup.MarginLayoutParams) params;
                } else {
                    //不存在时创建一个新的参数
                    //基于View本身原有的布局参数对象
                    marginParams = new ViewGroup.MarginLayoutParams(params);
                }
            }
            marginParams.bottomMargin = dip2px(t);
            getView().setLayoutParams(marginParams);
        }
    }

    public void setVisibility(int t){
         getView().setVisibility(t);
    }
    public final int getId() {
        return ID;
    }
    public void setBelow(UIView view){
         if(group instanceof UIRelative){
             int id = view.getId();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams.addRule(BELOW,id);
            getView().setLayoutParams(layoutParams);
         }
    }
    public void setLeftOf(UIView view){
        if(group instanceof UIRelative){
            int id = view.getId();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams.addRule(LEFT_OF,id);
            getView().setLayoutParams(layoutParams);
        }
    }
    public void setRightOf(UIView view){
        if(group instanceof UIRelative){
            int id = view.getId();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams.addRule(RIGHT_OF,id);
            getView().setLayoutParams(layoutParams);
        }
    }
    public void setAlignTop(UIView view){
        if(group instanceof UIRelative){
            int id = view.getId();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams.addRule(ALIGN_TOP,id);
            getView().setLayoutParams(layoutParams);
        }
    }

    public void setAlignBottom(UIView view){
        if(group instanceof UIRelative){
            int id = view.getId();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams.addRule(ALIGN_TOP,id);
            getView().setLayoutParams(layoutParams);
        }
    }



    public void setAbove(UIView view){
        if(group instanceof UIRelative){
            int id = view.getId();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams.addRule(ABOVE,id);
            getView().setLayoutParams(layoutParams);
        }
    }




    public void setElevation(int t){
        getView().setElevation(dip2px(t));
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public abstract View newView();
    protected Context getContext(){
        return ability;
    }
    public View getView(){
        return view;
    }
    int width(){
        return 0;
    }
}
