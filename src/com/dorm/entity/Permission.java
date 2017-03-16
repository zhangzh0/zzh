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
@Table(name="permission")
public class Permission implements Serializable{
    
    private static final long serialVersionUID = 6177417450707400228L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="permissionid",nullable=false)
	private int permissionId;
	
    @Column(name="permission")
	private String permission;
    
	@OneToMany(fetch=FetchType.LAZY,mappedBy="permission",cascade=CascadeType.ALL)
	private List<RolePermission> listRolePermission;
    	
	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public List<RolePermission> getListRolePermission() {
		return listRolePermission;
	}

	public void setListRolePermission(List<RolePermission> listRolePermission) {
		this.listRolePermission = listRolePermission;
	}
}
