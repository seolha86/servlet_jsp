package com.kseolha.jsp.dao;

import com.kseolha.jsp.domain.Member;
import com.kseolha.jsp.util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public int insert(Member vo) {
        conn = DBConn.getConnection();
        int result = 0;
        String sql = "insert into tbl_member(id, pw, name) values(?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPw());
            pstmt.setString(3, vo.getName());

            result = pstmt.executeUpdate();
            close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public void update(Member member) {
        conn = DBConn.getConnection();
        String sql = "update tbl_member set pw = ? where id = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getPw());
            pstmt.setString(2, member.getId());

            pstmt.executeUpdate();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Member member) {
        conn = DBConn.getConnection();
        String sql = "delete from tbl_member where id = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getId());

            pstmt.executeUpdate();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int idCheck(String id) {
        conn = DBConn.getConnection();
        String sql = "select * from tbl_member where id = ?";
        int chk = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();
            if (rs.next() || id.equals("")) {
                chk = 0;
            } else {
                chk = 1;
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chk;
    }

    public Member selectOne(String id) {
        conn = DBConn.getConnection();
        Member vo = null;

        String sql = "select * from tbl_member where id = ?;";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int idx = 1;
                vo = new Member(
                        rs.getString(idx++),
                        rs.getString(idx++),
                        rs.getString(idx++),
                        rs.getDate(idx)
                );
            }
            close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vo;
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
