package com.example.commonlib.mvp;

/**
 * IBaseModel
 * 因为获取数据的内容、方式不同，所以没有特定的通用方法可以抽取，
 * 但是为求样式的统一，所以新建 IModel 接口，而且 IModel 可用于标明子类的类型。
 */
public interface IBaseModel {
    /**
     * @descriptoin 注销subscribe
     */
    void unSubscribe();
}
