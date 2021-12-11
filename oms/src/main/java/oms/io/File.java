package oms.io;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import oms.ability.ModAbility;

public class File extends ModAbility {
    public static final String UTF8 = "UTF-8";
    public static final String GBK = "GBK";
    public static final String UTF32 = "UTF-32";
    public static final String UTF16 = "UTF-16";
    private final String _realPath;
    private final String _path;
    private java.io.File file = null;
    private final String _suffix;



    public File(String path){
        this._realPath = getPath(path);
        this._path = path;
        if(!_path.startsWith("@")){
            this.file = new java.io.File(this._realPath);
        }
        this._suffix = getType();
    }
    public String read(){

        return null;
    }

    private String getType() {
        String fileName = getName();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return suffix;
        //return suffix;
    }

    public boolean delete(){
        if(_path.startsWith("@")||_path.startsWith("#")){
            return false;
        }
        try {
            Runtime.getRuntime().exec("rm -rf "+_realPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(this.file.exists()){
            return true;
        }else {
            return false;
        }
    }

    public InputStream getFile(){
        return null;
    }

    public boolean isFile(){
         if(file!=null){
             return file.isFile();
         }
         return false;
    }

    public boolean isDirectory(){
        if(file!=null){
            return file.isDirectory();
        }
        return false;
    }

    public boolean exists(){
        if(file!=null){
            return file.exists();
        }
        return false;
    }

    public String getName(){
      if(file!=null) {
          return file.getName();
      }
        return _path.substring(_path.lastIndexOf("/") + 1,_path.length());
    }

    public String getSuffix(){
        return _suffix;
    }

    public boolean mkdir(){
        if(file!=null){
            return file.mkdirs();
        }
        return false;
    }
    public String read(String code){
        String content = read();
        try {
            return new String(content.getBytes(),code);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void write(String text){

    }
    public void copy(File file){

    }

    public void copy(File file,onCopyCallback copyCallback){
         
    }

    public interface onCopyCallback{
          void on(int size,int progress);
    }

    public boolean rename(File file){
        if(_path.startsWith("@")||file._path.startsWith("@")){
            return false;
        }else{
            return this.file.renameTo(file.file);
        }
    }




    @Override
    public String toString() {
        return "File.object."+getPath().getBytes().toString();
    }

    private String getPath(String s){
        return d(getApplicationContext(),s);
    }
    public String getPath(){
        return _path;
    }
    public String getRealPath(){
         return _realPath;
    }

    private static String a = Environment.getExternalStorageDirectory().toString();
    private static String d(Context context, String str) {
        StringBuilder stringBuilder;
        if (str.startsWith("@")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("assets/");
            stringBuilder.append(str.substring(1));
            return stringBuilder.toString();
        }
        String str2 = "/";
        if (str.startsWith("%")) {
            str = str.substring(1);
            if (str.indexOf(92) != -1) {
                str = str.replace('\\', '/');
            }
            if (str.startsWith(str2)) {
                return str;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return String.format("%s/%s", new Object[]{context.getExternalFilesDir(""), str});
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append('/');
            stringBuilder.append(str);
            return stringBuilder.toString();
        } else if (str.startsWith("$")) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(context.getFilesDir().getPath() + "/");
            stringBuilder2.append(str.substring(1));
            return stringBuilder2.toString();
        } else if (str.startsWith(str2)) {
            return str;
        } else if(str.startsWith("#")){
            return str;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append('/');
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
    }
}