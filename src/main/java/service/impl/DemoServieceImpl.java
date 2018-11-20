package service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import service.DemoService;

/**
 * Created by aichaellee on 2018/11/20.
 */
@Service
public class DemoServieceImpl implements DemoService {

    @Override
    public void sayHello(){
        System.out.println("这是服务提供方!");
    }
}
