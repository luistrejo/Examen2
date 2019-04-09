package jairfranco.com.tec2.pfran.examen2;

import android.os.Parcel;
import android.os.Parcelable;

public class Restaurant implements Parcelable {

    private int imgId;
    private String sName;
    private String sDesc;
    private String sDir;
    private String sTel;
    private double dCalif;

    //Constructor vacio requerido por Firebase
    public Restaurant() {
    }

    public Restaurant(int imgId, String sName, String sDesc, String sDir, String sTel, double dCalif) {
        this.imgId = imgId;
        this.sName = sName;
        this.sDesc = sDesc;
        this.sDir = sDir;
        this.sTel = sTel;
        this.dCalif = dCalif;
    }

    public int getImgRest() {
        return imgId;
    }

    public void setImgRest(int imgId) {
        this.imgId = imgId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsDesc() {
        return sDesc;
    }

    public void setsDesc(String sDesc) {
        this.sDesc = sDesc;
    }

    public String getsTel() {
        return sTel;
    }

    public void setsTel(String sTel) {
        this.sTel = sTel;
    }

    public String getsDir() {
        return sDir;
    }

    public void setsDir(String sDir) {
        this.sDir = sDir;
    }
    public double getdCalif() {
        return dCalif;
    }

    public void setdCalif(double dCalif) {
        this.dCalif = dCalif;
    }
    protected Restaurant(Parcel in) {
        imgId = in.readInt();
        sName = in.readString();
        sDesc = in.readString();
        sDir = in.readString();
        sTel = in.readString();
        dCalif = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imgId);
        dest.writeString(sName);
        dest.writeString(sDesc);
        dest.writeString(sDir);
        dest.writeString(sTel);
        dest.writeDouble(dCalif);

    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };


}