package org.qiyi.video.svg;

import android.content.Context;
import android.os.IInterface;

/**
 * Created by wangallen on 2018/1/8.
 */
//TODO 后期要考虑一个Module下分很多个interfaces的情况，即一对多。因为可能一个Module也很复杂，需要几个不同的业务分别实现各自的接口
public interface IServiceManager {

    void registerLocalService(Class serviceClass, Object serviceImpl);

    void registerLocalService(String serviceCanonicalName, Object serviceImpl);

    void unregisterLocalService(Class serviceClass);

    void unregisterLocalService(String serviceName);

    void registerStubService(Class serviceClass, IInterface stubImpl);

    //TODO 不仅要支持懒加载，也要支持业务方主动注册!
    //void registerRemoteService(String serivceCanonicalName, Binder stubImpl);

    Object getLocalService(Class serviceClass);

    //只能用于同进程通信,所以支持的返回值和参数类型都不受限制
    Object getLocalService(String serivceCanonicalName);
    //<T> T getLocalService(String serivceCanonicalName);

    Object getRemoteService(Class serviceClass, Context context);

    IInterface getStubService(String serviceCanonicalName);

    //TODO 是不是改成apiCanonicalName更不容易引起误解呢?
    //既可用于IPC,也可用于同一个进程通信,所以返回值和参数类型受AIDL的限制
    Object getRemoteService(String serviceCanonicalName, Context context);

}
