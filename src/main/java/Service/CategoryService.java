package Service;

import java.util.List;

import Model.CategoryModel;
import Model.UserProfileModel;

public interface CategoryService {
	 public boolean isAddCategory(CategoryModel model,UserProfileModel umodel);
	 public List<CategoryModel> getAllCategories(UserProfileModel umodel);
	 public List<CategoryModel> getAllCategoriesByName(String name,UserProfileModel umodel);
	 public boolean deleteCat(int id);
	 public boolean UpdateCategory(CategoryModel CatModel,int id);
	 public String  getCategoryName(int cid);
}
