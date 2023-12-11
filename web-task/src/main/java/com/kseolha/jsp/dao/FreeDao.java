package com.kseolha.jsp.dao;

import com.kseolha.jsp.domain.Board;
import com.kseolha.jsp.domain.Criteria;
import com.kseolha.jsp.domain.Member;
import com.kseolha.jsp.util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FreeDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public int insert(Board board) {
        conn = DBConn.getConnection();
        int result = 0;
        String sql = "insert into tbl_board(title, content, writer, category) values (?, ?, ?, 1)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, board.getTitle());;
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getWriter());

            result = pstmt.executeUpdate();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void update(Board board) {
        conn = DBConn.getConnection();
        String sql = "update tbl_board set title = ?, content = ?, updatedate = now() where bno = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setLong(3, board.getBno());

            pstmt.executeUpdate();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdrawnMember(Member member) {
        conn = DBConn.getConnection();
        String sql = "update tbl_board set writer = '탈퇴회원' where writer = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getId());

            pstmt.executeUpdate();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void increaseHitCount(Long bno) {
        conn = DBConn.getConnection();
        String sql = "update tbl_board set hitcount = hitcount + 1 where bno = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, bno);

            pstmt.executeUpdate();
            close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Long bno) {
        conn = DBConn.getConnection();
        String sql = "delete from tbl_board where bno = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, bno);

            pstmt.executeUpdate();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Board selectOne(Long bno) {
        conn = DBConn.getConnection();

        Board board = null;
        String sql= "select tb.*, lag(bno) over (order by bno) as prevBno, lead(bno) over (order by bno) as nextBno from tbl_board tb where category = 1 order by bno limit 1 offset " + (long) ((getIdx(bno)) - 1);

        try {
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int idx = 1;
                board = new Board(
                        rs.getLong(idx++),
                        rs.getString(idx++),
                        rs.getString(idx++),
                        rs.getString(idx++),
                        rs.getDate(idx++),
                        rs.getString(idx++),
                        rs.getInt(idx++),
                        rs.getInt(idx++),
                        rs.getLong(idx++),
                        rs.getLong(idx++)
                );
            }
            close();
        } catch (Exception e) {
        }
        return board;
    }

    public int getIdx(Long bno) {
        conn = DBConn.getConnection();
        int bnoIdx = 0;
        String sql = "select count(*) idx from tbl_board where bno <= (select bno from tbl_board where bno = ?) and category = 1";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, bno);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int idx = 1;
                bnoIdx = rs.getInt(idx++);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bnoIdx;
    }

    public List<Board> selectList(Criteria cri) {
        conn = DBConn.getConnection();

        List<Board> boards = new ArrayList<>();

        String sql = "";
        sql += "select tb.*, lag(bno) over (order by bno) as prev_bno, lead(bno) over (order by bno) as next_bno from tbl_board tb where category = 1";
        sql += getSearchSQLBy(cri);
        sql += " order by bno desc limit ? offset ?";

        try {
            pstmt = conn.prepareStatement(sql);

            int idx = 1;

            pstmt.setInt(idx++, cri.getAmount());
            pstmt.setInt(idx++, (cri.getPageNum() - 1) * cri.getAmount());

            rs = pstmt.executeQuery();
            while (rs.next()) {
                idx = 1;
                Board board = new Board(
                        rs.getLong(idx++),
                        rs.getString(idx++),
                        rs.getString(idx++),
                        rs.getString(idx++),
                        rs.getDate(idx++),
                        rs.getString(idx++),
                        rs.getInt(idx++),
                        rs.getInt(idx++),
                        rs.getLong(idx++),
                        rs.getLong(idx++)
                );
                boards.add(board);
            }
            close();
        } catch (Exception e) {
        }
        return boards;
    }

    public int selectListCount(Criteria cri) {
        conn = DBConn.getConnection();

        int count = 0;

        String sql = "select count(*) from tbl_board where category = 1";
        sql += getSearchSQLBy(cri);

        try {
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
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

    private String getSearchSQLBy(Criteria cri) {
        String sql = "";
        if (cri.getType() != null && cri.getKeyword() != null) {
            sql += " and (";

            List<String> list = Arrays.asList(cri.getType());
            List<String> typeList = list.stream().map(s -> " " + s + " like '%" + cri.getKeyword() + "%' ").collect(Collectors.toList());
            sql += String.join(" or ", typeList);

            sql += ")";
        }
        return sql;
    }
}
