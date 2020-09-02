package com.example.hinews;

import com.example.commonlib.mvp.BaseModel;
import com.example.hinews.service.ServiceApi;

public class MainModel extends BaseModel<ServiceApi> {
    @Override
    protected ServiceApi createServiceApi() {
        return null;
    }
}
