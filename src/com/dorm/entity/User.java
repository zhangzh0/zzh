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
     * cascade��Ϊ���������������м������棬����ɾ���ȣ�allΪ���� 
     * fetch���������ͣ���lazy��eager���֣�
     *   eagerΪ�����أ���Ϊ�������أ��������ʱ�ͼ��أ�lazyΪ�����أ���һ�ε��õ�ʱ���ټ��أ�����������̫��onetomanyһ��Ϊlazy
     * mappedBy�����Ϊmanytoone�еĶ������������Ҫ��Ŷ
     * 
     * <UserRole>:ΪҪ��õ�mappedBy����
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
