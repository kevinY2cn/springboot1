package dk.service;


import dk.pojo.DkUser;

public interface UserService {
	
	public DkUser getUserByName(String username);
	
	public void addUser(DkUser dkUser) throws Exception;
	
	public void udpateUser(DkUser dkUser) throws Exception;
	
	public void deleteUser(int id) throws Exception;

}
