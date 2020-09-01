package com.example.commonlib.net;

import io.reactivex.observers.DisposableObserver;

/**
 * @Description: 自定义DisposableObserver，实现了全部成员函数，
 *               生成实例时可以只Override其中的onNext方法进行逻辑处理
 * @Author: Li Xiuliang
 * @CreateDate: 2020/8/13 10:56
 * @Version: 1.0
 */
public class MyObserver<T> extends DisposableObserver<T> {

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
