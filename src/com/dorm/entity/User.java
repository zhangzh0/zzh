package com.dorm.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{

	
    private static final long serialVersionUID = 6177417450707400228L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userid",nullable=false)
	private int userId;
    
	@Column(name="username")
	private String userName;
	
	@Column(name="userpassword")
    private String userPassword;
	
    /*
     * cascade：为级联操作，里面有级联保存，级联删除等，all为所有 
     * fetch：加载类型，有lazy和eager二种，
     *   eager为急加载，意为立即加载，在类加载时就加载，lazy为慢加载，第一次调用的时候再加载，由于数据量太大，onetomany一般为lazy
     * mappedBy：这个为manytoone中的对象名，这个不要变哦
     * 
     * <UserRole>:为要获得的mappedBy的类
     */
    @OneToMany(fetch=FetchType.LAZY,mappedBy="user",cascade=CascadeType.ALL)
	private List<UserRole> listUserRole; 
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<UserRole> getListUserRole() {
		return listUserRole;
	}

	public void setListUserRole(List<UserRole> listUserRole) {
		this.listUserRole = listUserRole;
	}	
}
