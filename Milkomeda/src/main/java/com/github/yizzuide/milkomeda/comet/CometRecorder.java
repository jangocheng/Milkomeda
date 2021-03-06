package com.github.yizzuide.milkomeda.comet;

import javax.servlet.http.HttpServletRequest;

/**
 * CometRecorder
 * 采集记录器策略接口
 *
 * @author yizzuide
 * @since 0.2.0
 * @version 1.3.1
 * Create at 2019/04/11 19:45
 */
public interface CometRecorder {
    /**
     * 请求触发时
     * @param prototype 采集数据原型
     * @param tag       请求分类 tag，可根据 tag 来区分不同的 prototype；如果没有指定 tag 名又指定了指定的 prototype，
     * @param request   请求对象
     */
    default void onRequest(CometData prototype, String tag, HttpServletRequest request) {}

    /**
     * 方法返回结果后
     * @param cometData     日志实体
     * @param returnData    返回数据
     * @return  返回对象
     */
    default Object onReturn(CometData cometData, Object returnData) {
        return returnData;
    }

    /**
     * 方法抛出异常
     * @param cometData 日志实体
     * @param e         异常
     */
    default void onThrowing(CometData cometData, Exception e) {}
}
