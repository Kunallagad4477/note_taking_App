package Repository;

import DBConfig.DBConfig;
import Model.NoteModel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
public class NoteRepositoryImpl extends DBConfig implements NoteRepository {
	List<NoteModel>list=new ArrayList<NoteModel>();
	@Override
	
	public boolean AddNote(NoteModel nModel) {
		try {
			stmt=conn.prepareStatement("insert into note values('0',?,?,?,?,?)");
			stmt.setString(1, nModel.getNtitle());
			stmt.setString(2, nModel.getDesc());
			java.sql.Date sqldate=new java.sql.Date(nModel.getDate().getTime());
			stmt.setDate(3, sqldate);
			stmt.setInt(4,nModel.getUid());
			stmt.setInt(5, nModel.getCid());
			int result=stmt.executeUpdate();
			if(result>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}catch(Exception e)
		{
			System.out.println("Error in Add note repository");
			return false;
		}
	}

	@Override
	public List getUsersAllNotes(int uid) {
		try {
			stmt=conn.prepareStatement("select * from note where uid=?");
			stmt.setInt(1, uid);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				NoteModel nModel=new NoteModel();
				nModel.setNid(rs.getInt("nid"));
				nModel.setNtitle(rs.getString("ntitle"));
				nModel.setDesc(rs.getString("description"));
				nModel.setDate(rs.getDate("date"));
				nModel.setCid(rs.getInt("cid"));
				nModel.setUid(rs.getInt("uid"));
				list.add(nModel);
			}
			if(list!=null)
			{
				return list;
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in geting users notes"+e);
			return null;
		}
	     
	}

	@Override
	public boolean isUpdateNote(NoteModel nModel) {
		try {
			stmt=conn.prepareStatement("Update note SET ntitle=?,description=?,date=? where nid=? ");
			stmt.setString(1, nModel.getNtitle());
			stmt.setString(2, nModel.getDesc());
			java.sql.Date sqldate=new java.sql.Date(nModel.getDate().getTime());
			stmt.setDate(3, sqldate);
			stmt.setInt(4, nModel.getNid());
			
			int result=stmt.executeUpdate();
			if(result>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Error in update Note repository"+e);
			return false;
		}
	}

	@Override
	public boolean DeleteNote(int nid) {
		try {
			stmt=conn.prepareStatement("delete from note where nid=?");
			stmt.setInt(1, nid);
			int result=stmt.executeUpdate();
			if(result>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("error in delete repository"+e);
			return false;
		}
	}

	@Override
	public List getCategoryWiseNotes(int cid, int uid) {
		try {
			stmt=conn.prepareStatement("select * from note where cid=? and uid=?");
			stmt.setInt(1, cid);
			stmt.setInt(2, uid);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				NoteModel nModel=new NoteModel();
				nModel.setNid(rs.getInt("nid"));
				nModel.setNtitle(rs.getString("ntitle"));
				nModel.setDesc(rs.getString("description"));
				nModel.setDate(rs.getDate("date"));
				nModel.setCid(rs.getInt("cid"));
				nModel.setUid(rs.getInt("uid"));
				list.add(nModel);
			}
			if(list!=null)
			{
				return list;
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in geting category wise notes"+e);
			return null;
		}
	}

}
