package Service;

import Model.UserProfileModel;

public interface UserService {
      public UserProfileModel validateUser(UserProfileModel model);
      public boolean isRegister(UserProfileModel model);
}
