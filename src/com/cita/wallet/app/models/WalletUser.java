package com.cita.wallet.app.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 5/26/14.
 */
public class WalletUser implements Parcelable {


    private String student_id;
    private String student_name;
    private String student_middle_name;
    private String student_lastname;
    private String student_second_lastname;
    private String student_badge_id;
    private String student_email;

    public WalletUser() {
    }

    public WalletUser(String student_id, String student_name, String student_middle_name,
                      String student_lastname, String student_second_lastname,
                      String student_badge_id, String student_email) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_middle_name = student_middle_name;
        this.student_lastname = student_lastname;
        this.student_second_lastname = student_second_lastname;
        this.student_badge_id = student_badge_id;
        this.student_email = student_email;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_middle_name() {
        return student_middle_name;
    }

    public void setStudent_middle_name(String student_middle_name) {
        this.student_middle_name = student_middle_name;
    }

    public String getStudent_lastname() {
        return student_lastname;
    }

    public void setStudent_lastname(String student_lastname) {
        this.student_lastname = student_lastname;
    }

    public String getStudent_second_lastname() {
        return student_second_lastname;
    }

    public void setStudent_second_lastname(String student_second_lastname) {
        this.student_second_lastname = student_second_lastname;
    }

    public String getStudent_badge_id() {
        return student_badge_id;
    }

    public void setStudent_badge_id(String student_badge_id) {
        this.student_badge_id = student_badge_id;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }




    protected WalletUser(Parcel in) {
        student_id = in.readString();
        student_name = in.readString();
        student_middle_name = in.readString();
        student_lastname = in.readString();
        student_second_lastname = in.readString();
        student_badge_id = in.readString();
        student_email = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(student_id);
        dest.writeString(student_name);
        dest.writeString(student_middle_name);
        dest.writeString(student_lastname);
        dest.writeString(student_second_lastname);
        dest.writeString(student_badge_id);
        dest.writeString(student_email);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<WalletUser> CREATOR = new Parcelable.Creator<WalletUser>() {
        @Override
        public WalletUser createFromParcel(Parcel in) {
            return new WalletUser(in);
        }

        @Override
        public WalletUser[] newArray(int size) {
            return new WalletUser[size];
        }
    };
}