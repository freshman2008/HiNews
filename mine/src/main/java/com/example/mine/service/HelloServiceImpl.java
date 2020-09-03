package com.example.mine.service;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlib.utils.ARouterConstants;
import com.example.provider.HelloService;

/**
 * @author: Li Xiuliang
 * @date: 2020/9/3 10:25
 */
@Route(path = ARouterConstants.HOME.SERVICE_HELLO, name = "test service")
public class HelloServiceImpl implements HelloService {
    private Context mContext;

    @Override
    public String sayHello(String name) {
        Toast.makeText(mContext,this.getClass().getSimpleName()+": sayHello"+" "+name,Toast.LENGTH_SHORT).show();
        return "Hello " + name;
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
