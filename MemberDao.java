package com_kh_jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MemberDao {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    Scanner sc = new Scanner(System.in);

    public MemberVo memberSelect(String name) {
        String sql = "SELECT * FROM MEMBER";
        String reult = null;
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,2);
            rs = pstmt.executeQuery();


            if(rs.next()) {
                MemberVo vo = new MemberVo(
                        rs.getString("MEMBER_ID"),
                        rs.getString("MEMBER_NAME"),
                        rs.getString("MEMBER_PWD"),
                        rs.getString("MEMBER_EMAIL"),
                        rs.getString("MEMBER_PHONE"));
                vo.setDate(rs.getDate("MEMBER_DATE"));
                list.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return
    }


    public List<MemberVo> memberSelectAll() {
        String sql = "SELECT * FROM MEMBER";
        List<MemberVo> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();


            while(rs.next()) {
                MemberVo vo = new MemberVo(
                rs.getString("MEMBER_ID"),
                rs.getString("MEMBER_NAME"),
                rs.getString("MEMBER_PWD"),
                rs.getString("MEMBER_EMAIL"),
                rs.getString("MEMBER_PHONE"));
                vo.setDate(rs.getDate("MEMBER_DATE"));
                list.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void memberInsert() {
        System.out.println("정보를 입력 하세요.");
        System.out.print("아이디를 입력 하세요 : ");
        String id = sc.next();
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("비밀번호 : ");
        String pwd = sc.next();
        System.out.print("이메일 : ");
        String email = sc.next();
        System.out.print("핸드폰 번호 : ");
        String phone = sc.next();

        String sql = "INSERT INTO MEMBER(MEMBER_ID,MEMBER_NAME,MEMBER_PWD,MEMBER_EMAIL,MEMBER_PHONE,MEMBER_DATE) VALUES (?,?,?,?,?,SYSDATE)";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, pwd);
            pstmt.setString(4, email);
            pstmt.setString(5, phone);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }

    public void memberDelete() {
        System.out.print("삭제할 이름을 입력 하세요 : ");
        String name = sc.next();
        String sql = "DELETE FROM MEMBER WHERE MEMBER_NAME = ?";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(stmt);
        Common.close(conn);
    }
    public void memberUpdate() {
        System.out.print("변경할 회원의 이름을 입력 하세요 : ");
        String name = sc.next();
        System.out.print("이메일 : ");
        String email = sc.next();
        System.out.print("핸드폰번호 : " );
        String phone = sc.next();

        String sql = "UPDATE MEMBER SET MEMBER_EMAIL = ?, MEMBER_PHONE = ? WHERE MEMBER_NAME = ?";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, phone);
            pstmt.setString(3, name);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(stmt);
        Common.close(conn);
    }

    public void memberSelectRst(List<MemberVo> list) {
        for(MemberVo e : list) {
            System.out.print(e.getId() + " ");
            System.out.print(e.getName() + " ");
            System.out.print(e.getPwd() + " ");
            System.out.print(e.getEmail() + " ");
            System.out.print(e.getPhone() + " ");
            System.out.println();
        }
    }
}