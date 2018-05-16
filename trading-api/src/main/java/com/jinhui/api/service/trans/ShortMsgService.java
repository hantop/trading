package com.jinhui.api.service.trans;

import com.jinhui.api.entity.dto.ShortMessage;

/**
 * Created by Administrator on 2018/2/27 0027.
 */
public interface ShortMsgService {

    ShortMessage sendCode(ShortMessage shortMessage);

}
