package Service;
import java.util.List;

import Model.CategoryModel;
import Model.UserProfileModel;
import Repository.CategoryRepository;
import Repository.CategoryRepositoryImpl;
public class CategoryServiceImpl implements CategoryService{
	  CategoryRepository repo=new CategoryRepositoryImpl();
      public boolean isAddCategory(CategoryModel model,UserProfileModel umodel)
      {
    	  boolean b=false;
    	  b=repo.addCategory(model,umodel);
    	  return b;
      }
	@Override
	public List<CategoryModel> getAllCategories(UserProfileModel umodel) {
		return  repo.returnAllCategories(umodel);
	}
	@Override
	public List<CategoryModel> getAllCategoriesByName(String name,UserProfileModel umodel) {
		return repo.ReturnSearchedCategory(name,umodel);
	}
	@Override
	public boolean deleteCat(int id) {
		return repo.isDeleteCat(id);
	}
	@Override
	public boolean UpdateCategory(CategoryModel CatModel,int id) {
		return repo.isUpdateCategory(CatModel,id);
	}
	@Override
	public String getCategoryName(int cid) {
		return repo.getCatName(cid);
	}
}
