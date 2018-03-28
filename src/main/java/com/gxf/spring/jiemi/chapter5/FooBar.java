package com.gxf.spring.jiemi.chapter5;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * Created by 58 on 2018/3/28.
 */
public class FooBar implements ResourceLoaderAware {
    private ResourceLoader resourceLoader;

    public void foo(String location){
        System.out.println(getResourceLoader().getResource(location));
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
