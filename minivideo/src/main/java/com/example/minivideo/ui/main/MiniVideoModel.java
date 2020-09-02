package com.example.minivideo.ui.main;

import com.example.commonlib.mvp.BaseModel;
import com.example.commonlib.mvp.IBaseModel;
import com.example.minivideo.service.ServiceApi;

public class MiniVideoModel extends BaseModel<ServiceApi> implements IBaseModel {
    @Override
    protected ServiceApi createServiceApi() {
        return null;
    }
}
