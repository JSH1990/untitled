import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




public class MemberDao {
    private static MemberDao instance;
    private DataSource ds;

    private MemberDao() {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/TestDB"); //JNDI
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


    public static MemberDao getInstance() {
        synchronized (MemberDao.class) {
            if(instance == null) {
                instance = new MemberDao();
            }
        }
        return instance;
    }

    //C
    public int insertMember(MemberVo vo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            conn = ds.getConnection();
            System.out.println("���Ӽ���!");

            StringBuffer query = new StringBuffer(); //���ڿ��� �����ϱ� ���� ���(String�� ���� ������ ���ο� ���� �������� ���۴� ���ڳ��� ������ �ٷ� �ٿ��� ȿ������.
            query.append("insert into \"MEMBER\" ");
            query.append("(\"NUM\", \"MEMBERID\", \"MEMBERPW\", \"NICKNAME\", \"REGDATE\") "); //NUM �� ( �ȽἭ ����
            query.append("values (\"MEMBER_SEQ\".nextval, ?, ?, ?, sysdate)"); //���̵�,��й�ȣ,�г���

            System.out.println(query.toString());

            pstmt = conn.prepareStatement(query.toString()); //���� �ش� ������ �غ��� �������
            pstmt.setString(1, vo.getMemberId());
            pstmt.setString(2, vo.getMemberPw());
            pstmt.setString(3, vo.getNickName());

            result = pstmt.executeUpdate();
            System.out.println(result + "���� ���ԵǾ����ϴ�.");

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


    //R
    public MemberVo selectMember(int num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberVo result = null;
        System.out.println("aa");
        try {
            conn = ds.getConnection();
            System.out.println("���Ӽ��� select!");
            pstmt = conn.prepareStatement("select * from \"MEMBER\" where \"NUM\"=?"); //MEMBER���̺� ��ü�˻��� �ϰ�,
            pstmt.setInt(1, num); //�Ѱ��� ���ε��� 2�� ȸ�� �˻�
            rs =pstmt.executeQuery(); //���͸� ġ�°Ͱ� ����.

            if (rs.next()) {
                result = new MemberVo(
                        rs.getInt("NUM"),
                        rs.getString("MEMBERID"),
                        rs.getString(3),
                        rs.getString(4)
                );
                result.setRegdate(rs.getDate("REGDATE"));

            }



        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstmt != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public List<MemberVo> selectMemberAll(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<MemberVo> result = new ArrayList<>();
        try {
            conn = ds.getConnection();
            System.out.println("���Ӽ���!");
            pstmt = conn.prepareStatement("select * from \"MEMBER\""); //MEMBER���̺� ��ü�˻��� �ϰ�,
            rs =pstmt.executeQuery(); //���͸� ġ�°Ͱ� ����.

            while (rs.next()) {
                MemberVo vo = new MemberVo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString("MEMBERPW"),
                        rs.getString(4)
                );
                vo.setRegdate(rs.getDate("REGDATE"));

                result.add(vo);
            }


        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstmt != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;

    }

    //U
    public int updateMember(MemberVo vo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            conn = ds.getConnection();
            System.out.println("���Ӽ���!");

            StringBuffer query = new StringBuffer(); //���ڿ��� �����ϱ� ���� ���(String�� ���� ������ ���ο� ���� �������� ���۴� ���ڳ��� ������ �ٷ� �ٿ��� ȿ������.
            query.append("update \"MEMBER\" ");
            query.append("set \"MEMBERPW\"=?, \"NICKNAME\"=? "); //*PW�� = �ȽἭ ����
            query.append("where \"NUM\"=?");

            System.out.println(query.toString());

            pstmt = conn.prepareStatement(query.toString()); //���� �ش� ������ �غ��� �������
            pstmt.setString(1,vo.getMemberPw());
            pstmt.setString(2,vo.getNickName());
            pstmt.setInt(3, vo.getNum());

            result = pstmt.executeUpdate();
            System.out.println(result + "���� �����Ǿ����ϴ�.");

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }



    //D
    public int deleteMember(int num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            conn = ds.getConnection();
            System.out.println("���Ӽ���!");

            StringBuffer query = new StringBuffer(); //���ڿ��� �����ϱ� ���� ���(String�� ���� ������ ���ο� ���� �������� ���۴� ���ڳ��� ������ �ٷ� �ٿ��� ȿ������.
            query.append("delete from \"MEMBER\" ");
            query.append("where \"NUM\"=?");

            System.out.println(query.toString());

            pstmt = conn.prepareStatement(query.toString()); //���� �ش� ������ �غ��� �������
            pstmt.setInt(1, num);

            result = pstmt.executeUpdate();
            System.out.println(result + "���� �����Ǿ����ϴ�.");

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}