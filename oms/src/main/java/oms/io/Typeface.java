package oms.io;

import android.content.Context;
import java.util.HashMap;
import oms.ability.ModAbility;


public class Typeface extends ModAbility {
    private static HashMap<String,Typeface> _typefaces = new HashMap<>();
    private String _path = null;
    private android.graphics.Typeface _typeface = null;
    private Context _context = null;
    public Typeface(String path){
        if(_typefaces == null){
            _typefaces = new HashMap<>();
        }
        _context = getContext();
        _typefaces.put(path,this);
        _path = path;
    }

    public android.graphics.Typeface getTypeface(){
        if(_typefaces.get(_path)._typeface == null){
            if(_path.startsWith("@")){
                 String path = _path.substring(1);
                _typefaces.get(_path)._typeface = android.graphics.Typeface.createFromAsset(this._context.getAssets(), path);
            }else{
               String path = new File(_path).getRealPath();
                _typefaces.get(_path)._typeface = android.graphics.Typeface.createFromFile(path);
            }
        }
        return _typefaces.get(_path)._typeface;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        _typefaces.put(_path,null);
        if(_typefaces.size() == 0){
             _typefaces = null;
        }
    }
}
