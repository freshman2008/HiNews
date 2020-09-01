package com.example.commonlib.mvp;

import io.reactivex.disposables.CompositeDisposable;

/**
 * 使用rxjava订阅，需要在关闭view(Activity或Fragment)时取消订阅
 * T泛型代表Retrofit ServiceApi的类型，适配不同的Model使用不同的ServiceApi场景
 */
public abstract class BaseModel<T> implements IBaseModel {
    protected CompositeDisposable mTasks = null;
    protected T mServiceApi = null;

    public BaseModel() {
        mTasks = new CompositeDisposable();
        mServiceApi = createServiceApi();
    }

    /**
     * 此处返回泛型类型并在子类中创建具体的ServiceApi
     * 如果全局只使用一个类型ServiceApi，可以把抽象函数改为普通函数并实现此ServiceApi的创建，子类无需Override
     *
     * @return
     */
    protected abstract T createServiceApi();

    /**
     * 取消订阅
     */
    @Override
    public void unSubscribe() {
        if(mTasks != null && !mTasks.isDisposed()) {
            mTasks.dispose();
            mTasks.clear();
        }
    }
}
