package com.example.provider;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author: Li Xiuliang
 * @date: 2020/9/3 10:23
 */
public interface HelloService extends IProvider {
    String sayHello(String name);
}
