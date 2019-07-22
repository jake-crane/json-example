import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Users {

	@JsonProperty("users")
	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> users) {
		this.userList = users;
	}
}
