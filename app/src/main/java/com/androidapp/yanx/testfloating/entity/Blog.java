package com.androidapp.yanx.testfloating.entity;

import java.util.List;

/**
 * ****************************************************************************
 * Copyright (C) 2014-2015 junte Corporation. All rights reserved
 * File Name	: ${FILE_NAME}.java
 * Description	: ${TODO}
 * Author		: xieyan@tuandai.com
 * Version		: v1.0
 * Date			: 2016/3/23 10:10
 * History		:
 * Date			Version			Modify
 * ****************************************************************************
 **/
public class Blog {
    public String name;

    public List<String> urls;

    public String content;

    public Blog(String name, List<String> urls, String content) {
        this.name = name;
        this.urls = urls;
        this.content = content;
    }
}
