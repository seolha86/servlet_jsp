package com.kseolha.jsp.dao;

import com.kseolha.jsp.domain.Board;
import com.kseolha.jsp.domain.Criteria;
import com.kseolha.jsp.domain.Member;
import com.kseolha.jsp.domain.Reply;
import com.kseolha.jsp.util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReplyDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public int insert(Reply reply) {
        conn = DBConn.getConnection();
        int result = 0;
        String sql = "insert into tbl_reply (content, writer, bno) values (?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reply.getContent());
            pstmt.setString(2, reply.getWriter());
            pstmt.setLong(3, reply.getBno());

            result = pstmt.executeUpdate();
            close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Reply selectOne(Long rno) {
        conn = DBConn.getConnection();

        Reply reply = null;
        String sql = "select * from tbl_reply where rno = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, rno);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int idx = 1;
                reply = new Reply(
                        rs.getLong(idx++),
                        rs.getString(idx++),
                        rs.getTimestamp(idx++),
                        rs.getString(idx++),
                        rs.getLong(idx++)
                );
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reply;
    }


    public List<Reply> selectList(Long bno) {
        conn = DBConn.getConnection();

        List<Reply> replies = new ArrayList<>();

        String sql = "";
        sql += "select * from tbl_reply tb where bno = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            int idx = 1;

            pstmt.setLong(idx++, bno);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                idx = 1;
                Reply reply = new Reply(
                        rs.getLong(idx++),
                        rs.getString(idx++),
                        rs.getDate(idx++),
                        rs.getString(idx++),
                        rs.getLong(idx++)
                );
                replies.add(reply);
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replies;
    }

    public int delete(Long rno) {
        int ret = 0;
        conn = DBConn.getConnection();
        String sql = "delete from tbl_reply where rno = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, rno);

            ret = pstmt.executeUpdate();
            close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    public void freeDelete(Long bno) {
        conn = DBConn.getConnection();
        String sql = "delete from tbl_reply where bno = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, bno);

            pstmt.executeUpdate();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdrawnMember(Member member) {
        conn = DBConn.getConnection();
        String sql = "update tbl_reply set writer = '탈퇴회원' where writer = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getId());

            pstmt.executeUpdate();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
