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
@Table(name="role")
public class Role implements Serializable{
	
	
	private static final long serialVersionUID = 6177417450707400228L;   
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="roleid",nullable=false)
	private int roleId;
	
	@Column(name="rolename")
    private String roleName;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="role",cascade=CascadeType.ALL)
	private List<UserRole> listUserRole;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="role",cascade=CascadeType.ALL)
	private List<RolePermission> listRolePermission;
			
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public List<UserRole> getListUserRole() {
		return listUserRole;
	}
	public void setListUserRole(List<UserRole> listUserRole) {
		this.listUserRole = listUserRole;
	}
	
	public List<RolePermission> getListRolePermission() {
		return listRolePermission;
	}
	public void setListRolePermission(List<RolePermission> listRolePermission) {
		this.listRolePermission = listRolePermission;
	}	
}
