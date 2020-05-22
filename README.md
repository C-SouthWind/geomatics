# geomatics
测绘项目

	home  
		测绘单位（hxy）
		测绘项目（hxy）
		测绘成果（hxy）
	login
	manage
		用户管理（chj）
		角色管理（chj）
		菜单管理（chj）
		部门管理（chj）
		字典管理（chj）
	plotting
		单位基本信息
			通用材料附件汇总（hxy）
		数据统计
			资质项目汇总统计（cwh）
			单位信息统计（cwh）
			人员设备汇总统计（cwh）
		项目审核
			项目信息（cwh）
			汇交成果（cwh）
			项目审核（cjl）
			成果汇交审核（cjl）
		单位审核
			单位列表（cjl）
			单位修改待审核（cjl）
			单位注册待审核（cjl）

geomatics
	包括：

		geomatics-common（公共项目）
		
		geomatics-config（公共配置）
			
		geomatics-consumer-management（消费者父级项目）
			system-consumer-6081
			
		geomatics-eureka-management（eureka注册中心）
			eureka-7081
			eureka-7082
			eureka-7083

		geomatics-management（业务和数据持久化）
			geomatics-api
			geomatics-mapper
			geomatics-model
			geomatics-service

		cehui-provider-management（生产者父级项目）
			system-provdier-8081

		cehui-zuul（路由网关）
