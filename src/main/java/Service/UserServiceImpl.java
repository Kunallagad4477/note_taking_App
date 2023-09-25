package Service;
import Repository.UserRepository;
import Repository.UserRepositoryImpl;
import Model.UserProfileModel;

public class UserServiceImpl implements UserService{

	UserRepository repo=new UserRepositoryImpl();
	@Override
	public UserProfileModel validateUser(UserProfileModel model) {
		// TODO Auto-generated method stub
		model=repo.isValidateUser(model);
		return model;
	}

	@Override
	public boolean isRegister(UserProfileModel model) {
		// TODO Auto-generated method stub
		boolean b=false;
		 b=repo.RegisterUser(model);
		return b;
	}

}
