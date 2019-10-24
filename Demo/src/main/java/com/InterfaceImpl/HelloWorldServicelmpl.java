package com.InterfaceImpl;

import com.Interface.HelloWorldService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Component
public class HelloWorldServicelmpl implements HelloWorldService{
    @Override
    public String getMessage(){
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        return "HelloWorld "+dateFormat.format(new Date());
    }
}
