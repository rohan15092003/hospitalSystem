package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.Hospital;
import com.util.DbConnection;

public class HospitalInterfaceDAOImpl implements HospitalInterfaceDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Hospital hos = new Hospital();
	String q = null;

	public boolean insertPatient(Hospital hospital) {
		try {
			con = DbConnection.createC();
			q="insert into patient_list(name,email,address,contact)values(?,?,?,?)";
			pstmt=con.prepareStatement(q);
			pstmt.setString(1,hospital.getName());

			pstmt.setString(2,hospital.getEmail());
			pstmt.setString(3,hospital.getAddress());
			pstmt.setString(4,hospital.getContact());
			 if(pstmt.executeUpdate()!=0) {
				 System.out.println("patient added succesfully");
			   return true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Hospital> viewAllPatient() {
		try {
			ArrayList<Hospital> al=new ArrayList<Hospital>();
			con = DbConnection.createC();
			q="select * from patient_list";
			pstmt=con.prepareStatement(q);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				hos=new Hospital();
				hos.setId(rs.getInt(1));
				hos.setName(rs.getString(2));
				hos.setEmail(rs.getString(3));
				hos.setAddress(rs.getString(4));
				hos.setContact(rs.getString(5));
				al.add(hos);
			}return al;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Hospital viewPatientById(int id) {
		try {
			con = DbConnection.createC();
			q="select * from patient_list where id='"+id+"'";
			pstmt=con.prepareStatement(q);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				hos=new Hospital();
				hos.setId(rs.getInt(1));
				hos.setName(rs.getString(2));
				hos.setEmail(rs.getString(3));
				hos.setAddress(rs.getString(4));
				hos.setContact(rs.getString(5));
			}return hos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updatePatient(Hospital hospital) {
		try {
			con = DbConnection.createC();
			q="update patient_list set name=?,email=?,address=?,contact=? where id='"+hospital.getId()+"'";
			pstmt=con.prepareStatement(q);
			pstmt.setString(1,hospital.getName());
			pstmt.setString(2,hospital.getEmail());
			pstmt.setString(3, hospital.getAddress());
			pstmt.setString(4, hospital.getContact());
			 if(pstmt.executeUpdate()!=0) {
				 System.out.println("patient added succesfully");
			   return true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletePatientById(int id) {
		try {
			con = DbConnection.createC();
			q="delete from patient_list where id='"+id+"'";
			pstmt=con.prepareStatement(q);
			if(pstmt.executeUpdate()!=0){
				System.out.println("data deleted succesfully");
			return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
