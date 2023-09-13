package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JdbcUtil;

public class BoardDao {
	private JdbcUtil ju;
	
	public BoardDao() {
		ju = JdbcUtil.getInstance();
	}
	
	//삽입
	public int insert(BoardVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String query = "INSERT INTO board (title, writer, content, regdate, cnt)\r\n" + 
				"VALUES (?, ?, ?, NOW(), 0);\r\n" + 
				"";
		int ret=-1;
	try {
		con=ju.getConnection();
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getWriter());
		pstmt.setString(3, vo.getContent());
		ret = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt !=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
	}return ret;
	}
	
	//조회수증가
	public int update(BoardVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String query = "UPDATE `board` SET `cnt` = `cnt` + 1, `title` = ?, `content` = ? WHERE `num` = ?;";
		int ret=-1;
		
	try {
		con=ju.getConnection();
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setInt(3, vo.getNum());
		ret = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt !=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
	}return ret;
	}
	
	//수정
		public int updateCnt(int num) {
			Connection con=null;
			PreparedStatement pstmt=null;
			String query = "UPDATE `board` SET `cnt` = `cnt` + 1  WHERE `num` = ?;";
			int ret=-1;
			
		try {
			con=ju.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			ret = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
		}return ret;
		}
	
	
	//전체조회
	public List<BoardVo> selectAll(){
		Connection con=null;
		Statement stmt=null;
		String query = "SELECT \r\n" + 
				"	`num`,\r\n" + 
				"    `titles`,\r\n" + 
				"    `writer`,\r\n" + 
				"    `content`,\r\n" + 
				"    `regdate`,\r\n" + 
				"    `cnt`\r\n" + 
				"FROM \r\n" + 
				"    `board`\r\n" + 
				"ORDER BY \r\n" +
				"    `regdate` DESC;\r\n" + 
				"";

		ResultSet rs=null;
		ArrayList<BoardVo> ls = new ArrayList<BoardVo>();
		try {
			con = ju.getConnection();
			stmt = con.createStatement();
			stmt.execute(query);
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				BoardVo vo = new BoardVo(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						new Date(rs.getDate(5).getTime()),
						rs.getInt(6));
				ls.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt !=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ls;
	}
	
	//한개만 조회
	public BoardVo selectOne(int num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String query = "SELECT " + 
			    "`num`, " +
			    "`title`, " + 
			    "`writer`, " + 
			    "`content`, " + 
			    "`regdate`, " + 
			    "`cnt` " + 
			    "FROM " + 
			    "`board` " + 
			    "WHERE " + 
			    "`num` = ?";

		
		BoardVo vo =null;
		try {
			con = ju.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
					updateCnt(num); //조회수증가
					vo = new BoardVo(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						new Date(rs.getDate(5).getTime()),
						rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return vo;
	}	
	
	//삭제
	
	public int delete(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String query = "DELETE FROM `board` WHERE `num` = ?;";
		int ret=-1;
		
	try {
		con=ju.getConnection();
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, num);
		ret = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt !=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
	}return ret;
	}
}
