package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.User;
import com.util.DbConnection;

public class UserInterfaceDAOImp implements UserInterfaceDAO {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String q = null;
	Connection con = null;

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		try {
			con = DbConnection.createC();
			q = "insert into user(uname,upassword)values(?,?)";
			pstmt = con.prepareStatement(q);
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getUpassword());
			if (pstmt.executeUpdate() != 0) {
				System.out.println("user inserted succesfully");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User viewUserById(int id) {
		try {
			con = DbConnection.createC();
			q = "select * from user  where uid='" + id + "'";
			pstmt = con.prepareStatement(q);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				User u = new User();
				u.setUid(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setUpassword(rs.getString(3));
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		try {
			con = DbConnection.createC();
			q = "update user set uname=?,upassword=? where uid='" + user.getUid() + "'";
			pstmt = con.prepareStatement(q);
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getUpassword());
			if (pstmt.executeUpdate() != 0) {
				System.out.println("user updated");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		try {
			con = DbConnection.createC();
			q = "delete from user where uid='" + id + "'";
			pstmt = con.prepareStatement(q);
			if (pstmt.executeUpdate() != 0) {
				System.out.println("user deleted");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean loginUser(User user) {
		try {
			String name = user.getUname();
			String password = user.getUpassword();
			con = DbConnection.createC();
			q = "select * from user";
			pstmt = con.prepareStatement(q);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if ((rs.getString(2).equals(name)) && (rs.getString(3).equals(password))) {
					System.out.println("correct name password");
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}