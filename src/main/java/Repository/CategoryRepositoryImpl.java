package Repository;

import java.util.ArrayList;
import java.util.List;

import DBConfig.DBConfig;
import Model.CategoryModel;
import Model.UserProfileModel;

public class CategoryRepositoryImpl extends DBConfig implements CategoryRepository{
	 List<CategoryModel>list=new ArrayList<CategoryModel>();
	public boolean addCategory(CategoryModel model,UserProfileModel umodel) {
		try {
			stmt=conn.prepareStatement("insert into category values('0',?,?)");
			stmt.setString(1, model.getCategoryTitle());
			stmt.setInt(2, umodel.getUid());
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

	@Override
	public List<CategoryModel> returnAllCategories(UserProfileModel umodel) {
		try{
			stmt=conn.prepareStatement("select * from category where uid=?");
			stmt.setInt(1, umodel.getUid());
			rs=stmt.executeQuery();
			while(rs.next())
			{
				CategoryModel m=new CategoryModel();
				m.setCategoryId(rs.getInt(1));
				m.setCategoryTitle(rs.getString(2));
				list.add(m);
			}
			return list.size()>0?list:null;
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
			return null;
		}
	
	}

	@Override
	public List<CategoryModel> ReturnSearchedCategory(String name,UserProfileModel umodel) {
		try {
			
			stmt=conn.prepareStatement("select *from category where uid=? AND ctitle like '%"+name+"%' ");
			stmt.setInt(1, umodel.getUid());
			rs=stmt.executeQuery();
			while(rs.next())
			{
				CategoryModel m=new CategoryModel();
				m.setCategoryId(rs.getInt(1));
				m.setCategoryTitle(rs.getString(2));
				list.add(m);
			}
			return list.size()>0?list:null;
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
			return null;
		}
	}

	@Override
	public boolean isDeleteCat(int id) {
		try {
			stmt=conn.prepareStatement("Delete from category where cid=?");
			stmt.setInt(1, id);
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

	@Override
	public boolean isUpdateCategory(CategoryModel CatModel,int id) {
		try {
			stmt=conn.prepareStatement("Update category set ctitle=? where cid=? AND uid=?");
			stmt.setString(1, CatModel.getCategoryTitle());
			stmt.setInt(2,CatModel.getCategoryId());
			stmt.setInt(3, id);
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
			System.out.println("Error in update category"+e);
			return false;
		}
	}

	@Override
	public String getCatName(int cid) {
		try {
			stmt=conn.prepareStatement("select ctitle from category where cid=? ");
			stmt.setInt(1, cid);
			rs=stmt.executeQuery();
			if(rs.next())
			{
			  return rs.getString("ctitle");
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			System.out.println("unable to get category id"+e);
			return null;
		}
	}

	

}
