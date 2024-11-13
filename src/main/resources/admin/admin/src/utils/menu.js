const menu = {
    list() {
        return [
    {
        "backMenu":[
            {
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "删除"
                        ],
                        "menu":"管理员管理",
                        "menuJump":"列表",
                        "tableName":"users"
                    }
                ],
                "menu":"管理员管理"
            }
			,{
			    "child":[
			        {
			            "buttons":[
			                "查看",
			                "新增",
			                "修改",
			                "删除"
			            ],
			            "menu":"用户管理",
			            "menuJump":"列表",
			            "tableName":"yonghu"
			        }
			    ],
			    "menu":"用户管理"
			}
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增",
                            "修改",
                            "报表",
                            "删除"
                        ],
                        "menu":"体检项目管理",
                        "menuJump":"列表",
                        "tableName":"tijianxiangmu"
                    }
                ],
                "menu":"体检项目管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "审核",
                            "报表",
                            "删除"
                        ],
                        "menu":"体检项目预约管理",
                        "menuJump":"列表",
                        "tableName":"tijianxiangmuYuyue"
                    }
                ],
                "menu":"体检项目预约管理"
            }
			,{
			    "child":[
			        {
			            "buttons":[
			                "查看",
			                "新增",
			                "删除",
			                "修改"
			            ],
			            "menu":"公告类型管理",
			            "menuJump":"列表",
			            "tableName":"dictionaryNews"
			        }
			        ,
			        {
			            "buttons":[
			                "查看",
			                "新增",
			                "删除",
			                "修改"
			            ],
			            "menu":"项目类型管理",
			            "menuJump":"列表",
			            "tableName":"dictionaryTijianxiangmu"
			        }
			    ],
			    "menu":"基础数据管理"
			}
			,{
			    "child":[
			        {
			            "buttons":[
			                "查看",
			                "新增",
			                "修改",
			                "删除"
			            ],
			            "menu":"公告信息管理",
			            "menuJump":"列表",
			            "tableName":"news"
			        }
			    ],
			    "menu":"公告信息管理"
			}
            /*,{
			    "child":[
			        {
			            "buttons":[
			                "查看"
			            ],
			            "menu":"数据备份",
			            "menuJump":"列表",
			            "tableName":"beifen"
			        },
					{
					    "buttons":[
					        "查看"
					    ],
					    "menu":"数据还原",
					    "menuJump":"列表",
					    "tableName":"huanyuan"
					}
			    ],
			    "menu":"数据库管理"
			}*/
        ],
        "frontMenu":[],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"否",
        "hasFrontRegister":"否",
        "roleName":"管理员",
        "tableName":"users"
    },
	{
	    "backMenu":[
	        {
	            "child":[
	                {
	                    "buttons":[
	                        "查看",
	                        "预约"
	                    ],
	                    "menu":"体检项目管理",
	                    "menuJump":"列表",
	                    "tableName":"tijianxiangmu"
	                }
	            ],
	            "menu":"体检项目管理"
	        }
	        ,{
	            "child":[
	                {
	                    "buttons":[
	                        "查看",
	                        "状态",
	                    ],
	                    "menu":"体检项目预约管理",
	                    "menuJump":"列表",
	                    "tableName":"tijianxiangmuYuyue"
	                }
	            ],
	            "menu":"体检项目预约管理"
	        }
			,{
			    "child":[
			        {
			            "buttons":[
			                "查看"
			            ],
			            "menu":"公告信息管理",
			            "menuJump":"列表",
			            "tableName":"news"
			        }
			    ],
			    "menu":"公告信息管理"
			}
	    ],
	    "frontMenu":[],
	    "hasBackLogin":"是",
	    "hasBackRegister":"否",
	    "hasFrontLogin":"否",
	    "hasFrontRegister":"否",
	    "roleName":"用户",
	    "tableName":"yonghu"
	}
]
    }
}
export default menu;