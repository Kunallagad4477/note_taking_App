package Repository;

import java.util.*;

import Model.CategoryModel;
import Model.UserProfileModel;


public interface CategoryRepository {
     public boolean addCategory(CategoryModel model,UserProfileModel umodel);
     public List<CategoryModel> returnAllCategories(UserProfileModel umodel);
     public List<CategoryModel>ReturnSearchedCategory(String name,UserProfileModel umodel);
     public boolean isDeleteCat(int id);
     boolean isUpdateCategory(CategoryModel CatModel,int id);
     public String getCatName(int cid);
}
