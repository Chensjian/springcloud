package com.chen.springcloud;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

/**
 * @author chenchenchen
 * @create 2022-10-01 20:51
 */
@Component
@ConditionalOnClass({RequestInterceptor.class, GlobalTransactional.class})
public class SeataInterceptor implements RequestInterceptor {


    public void apply(RequestTemplate requestTemplate) {
        String currentXid = RootContext.getXID();
        if (currentXid != null && currentXid != "") {
            requestTemplate.header(RootContext.KEY_XID, currentXid);
        }

    }
}
