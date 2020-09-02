package com.example.mine.ui.main;

import com.example.commonlib.mvp.BaseModel;
import com.example.commonlib.mvp.IBaseModel;
import com.example.mine.service.ServiceApi;

public class MineModel extends BaseModel<ServiceApi> implements IBaseModel {
    @Override
    protected ServiceApi createServiceApi() {
        return null;
    }
}
