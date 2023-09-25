package Repository;

import Model.UserProfileModel;

public interface UserRepository {
     public UserProfileModel isValidateUser(UserProfileModel model);
     public boolean RegisterUser(UserProfileModel model);
     
}
