package com.dorm.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


import com.dorm.entity.Role;
import com.dorm.entity.RolePermission;
import com.dorm.entity.User;
import com.dorm.entity.UserRole;
import com.dorm.service.LoginService;

public class MyRealm extends AuthorizingRealm{
	
    @Autowired
    private LoginService loginService;

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String loginName = (String) principals.fromRealm(getName()).iterator().next();
        User user=loginService.findByName(loginName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> permissionList=new ArrayList<String>();
    	if(user!=null){
    	    List<UserRole> listUserRole=user.getListUserRole();
    	    for(UserRole userRole:listUserRole){
    	    	Role role=userRole.getRole();
    	    	if(role!=null){
    	    		List<RolePermission> ListRolePermission=role.getListRolePermission();
        	    	for(RolePermission rolePermission:ListRolePermission){
        	    		permissionList.add(rolePermission.getPermission().getPermission());
        	    	}
    	    	}    	
    	    }  		
    		info.addStringPermissions(permissionList);
    		return info;
    	}
    	
        return null;  
	}


	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token=(UsernamePasswordToken)authcToken;
		User user=loginService.findByName(token.getUsername());
        
    	if(user!=null){
    		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user.getUserName(),user.getUserPassword(),getName());
    		return info;
    	}
        return null;  
	}

}

