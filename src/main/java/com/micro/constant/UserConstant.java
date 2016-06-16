package com.micro.constant;

public abstract class UserConstant {
	
	// 卖方，可以卖房子和查看信息
	public static final Integer SELLER = 0;
	
	// 买房，可以买房子和查看信息
	public static final Integer BUYER = 1;
	
	// 管理员权限，可以买卖房产，也可以删除信息
	public static final Integer SELLERANDBUYER = 2;
}
