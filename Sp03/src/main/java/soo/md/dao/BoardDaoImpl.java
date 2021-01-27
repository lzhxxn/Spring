package soo.md.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j;
import soo.md.domain.Board;
import static soo.md.sql.BoardSQL.*;

@Log4j
@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private HikariDataSource dataSource;
	
	@Override
	public List<Board> list() {
		List<Board> list = new ArrayList<Board>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = LIST;
		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				long seq = rs.getLong(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				Date rdate = rs.getDate(6);
				String fname = rs.getString(7);
				String ofname = rs.getString(8);
				long fsize = rs.getLong(9);
				
				
				list.add(new Board(seq, 0, 0, 0, writer, email, subject, content, rdate, fname, ofname, fsize));
			}
		}catch(SQLException se) {
			log.info("BoardDaoImpl list() se: " + se);
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		return list;
	}

	@Override
	public void insert(Board board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT;
		try{
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			log.info("BoardDaoImpl insert() se: " + se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {
			}
		}

	}
	
	@Override
	public Board content(long seq) {
		String sql = CONTENT;
		Board board = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, seq);
			pstmt.executeUpdate();
		}catch(SQLException se){
			log.info("BoardDaoImpl content1() se: " + se);
		}
		try {
			rs = pstmt.executeQuery();
			if(rs.next()) {
				seq = rs.getLong("seq");
				String writer = rs.getString("writer");
				String email = rs.getString("email");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Date rdate = rs.getDate("rdate");
				String fname = rs.getString(7);
				String ofname = rs.getString(8);
				long fsize = rs.getLong(9);
			
			board = new Board(seq, 0, 0, 0, writer, email, subject, content, rdate, fname, ofname, fsize);
		}
		}catch(SQLException se){
	         try{
	            if(pstmt != null) pstmt.close();
	            if(con != null) con.close();
	         }catch(SQLException sse){}
	      }
	return board;
}

	@Override
	public void delete(long seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = DEL;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, seq);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			log.info("BoardDaoImpl delete() se: " + se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}

	@Override
	public Board update1(long seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = UPDATE1;
		Board board = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, seq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String writer = rs.getString(2);
	            String email = rs.getString(3);
	            String subject = rs.getString(4);
	            String content = rs.getString(5);
	            Date rdate = rs.getDate(6);
				String fname = rs.getString(7);
				String ofname = rs.getString(8);
				long fsize = rs.getLong(9);
			
	        board = new Board(seq, 0, 0, 0, writer, email, subject, content, rdate, fname, ofname, fsize);
			}
		}catch(SQLException se) {
			log.info("BoardDaoImpl update1() se: " + se);
		}finally {
			try{
	              if(pstmt != null) pstmt.close();
	              if(con != null) con.close();
	           }catch(SQLException sse){}
	     }
	        return board;
	  }
	@Override
	public void update2(Board board) {
		String sql = UPDATE2;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setLong(5, board.getSeq());
			pstmt.executeUpdate();
		}catch(NumberFormatException ne){
	      }catch(SQLException se){
	    	  log.info("BoardDaoImpl update2() se: " + se);
	      }finally{
	         try{
	            if(pstmt != null) pstmt.close();
	            if(con != null) con.close();
	         }catch(SQLException sse){}
	      }
	   }
	}