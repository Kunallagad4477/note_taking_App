package Repository;

import DBConfig.DBConfig;
import Model.UserProfileModel;

public class UserRepositoryImpl extends DBConfig implements UserRepository{

	public UserRepositoryImpl()
	{
		super();
	}
	@Override
	public UserProfileModel isValidateUser(UserProfileModel model) {
		 try {
			 stmt=conn.prepareStatement("select * from userprofile where email=? and password=?");
			 stmt.setString(1,model.getEmail());
			 stmt.setString(2,model.getPassword());
			 rs=stmt.executeQuery();
			 if(rs.next())
			 {
				model.setUid(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setPassword(rs.getString(4));
				return model;
			 }
			 else
			 {
				 return null;
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println("Error"+e);
			 return null;
		 }
	}
	@Override
	public boolean RegisterUser(UserProfileModel model) {
		try {
			stmt=conn.prepareStatement("insert into userprofile values('0',?,?,?)");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3, model.getPassword());
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
			System.out.println("Error"+e);
			return false;
		}
	}

}
