package priv.yangkuncheng.life;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Prodict {
    @PostConstruct
    public void myInit() {
        System.out.println("Prodict.myInit");
    }

    @PreDestroy
    public void myDestory() {
        System.out.println("Prodict.myDestory");
    }
}
