package com.cita.wallet.app.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by admin on 5/26/14.
 */
public class WalletStatement implements Parcelable {

    private int statement_id;
    private String statement_student;
    private String statement_date;
    private double statement_tuition;
    private double statement_interests;
    private double statement_insurance;
    private double statement_diverse_services;

    public WalletStatement() {
    }

   

    public double getStatement_interests() {
		return statement_interests;
	}



	public void setStatement_interests(double statement_interests) {
		this.statement_interests = statement_interests;
	}



	public WalletStatement(int statement_id, String statement_student,
			String statement_date, double statement_tuition,
			double statement_interests, double statement_insurance,
			double statement_diverse_services) {
		super();
		this.statement_id = statement_id;
		this.statement_student = statement_student;
		this.statement_date = statement_date;
		this.statement_tuition = statement_tuition;
		this.statement_interests = statement_interests;
		this.statement_insurance = statement_insurance;
		this.statement_diverse_services = statement_diverse_services;
	}



	public int getStatement_id() {
        return statement_id;
    }

    public void setStatement_id(int statement_id) {
        this.statement_id = statement_id;
    }

    public String getStatement_student() {
        return statement_student;
    }

    public void setStatement_student(String statement_student) {
        this.statement_student = statement_student;
    }

    public String getStatement_date() {
        return statement_date;
    }

    public void setStatement_date(String statement_date) {
        this.statement_date = statement_date;
    }

    public double getStatement_tuition() {
        return statement_tuition;
    }

    public void setStatement_tuition(double statement_tuition) {
        this.statement_tuition = statement_tuition;
    }

    public double getStatement_insurance() {
        return statement_insurance;
    }

    public void setStatement_insurance(double statement_insurance) {
        this.statement_insurance = statement_insurance;
    }

    public double getStatement_diverse_services() {
        return statement_diverse_services;
    }

    public void setStatement_diverse_services(double statement_diverse_services) {
        this.statement_diverse_services = statement_diverse_services;
    }   

    @Override
   	public String toString() {
   		return "WalletStatement [statement_id=" + statement_id
   				+ ", statement_student=" + statement_student
   				+ ", statement_date=" + statement_date + ", statement_tuition="
   				+ statement_tuition + ", statement_interests="
   				+ statement_interests + ", statement_insurance="
   				+ statement_insurance + ", statement_diverse_services="
   				+ statement_diverse_services + "]";
   	}
    
    protected WalletStatement(Parcel in) {
        statement_id = in.readInt();
        statement_student = in.readString();
        statement_date = in.readString();
        statement_tuition = in.readDouble();
        statement_interests = in.readDouble();
        statement_insurance = in.readDouble();
        statement_diverse_services = in.readDouble();
    }

   



	@Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(statement_id);
        dest.writeString(statement_student);
        dest.writeString(statement_date);
        dest.writeDouble(statement_tuition);
        dest.writeDouble(statement_interests);
        dest.writeDouble(statement_insurance);
        dest.writeDouble(statement_diverse_services);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<WalletStatement> CREATOR = new Parcelable.Creator<WalletStatement>() {
        @Override
        public WalletStatement createFromParcel(Parcel in) {
            return new WalletStatement(in);
        }

        @Override
        public WalletStatement[] newArray(int size) {
            return new WalletStatement[size];
        }
    };

    @SuppressWarnings("serial")
    public static class List extends ArrayList<WalletStatement> {
    }
}