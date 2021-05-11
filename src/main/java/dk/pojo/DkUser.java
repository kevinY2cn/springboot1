package dk.pojo;

import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Range;

@Alias("DkUser")
public class DkUser {
	
	private int id;
	@NotBlank(message="账户名不能为空")
	private String username;
	
	@NotBlank(message="密码不能为空")
	private String password;
	
	@Range(min = 1,max = 2, message = "只能为男或女")
	private Integer sex;
	
	@Email
	private String email;
	
	@DecimalMin(value="1",message="错误的省份")
	private String provinceId;
	
	@DecimalMin(value="1",message="错误的城市")
	private String cityId;
	
	private List<Permission> permissionList;
	
	private List<Role> roleList;
	
	public List<Permission> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
	
}
