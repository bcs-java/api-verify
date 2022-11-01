package com.bsc.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 应用程序上下文持有人
 *
 * @author shenbangchen
 * @date 2022/11/01 11:54
 */
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return context.getBean(name, clazz);
    }

    public static <T> List<T> getBeansOfType(Class<T> clazz) {
        return new ArrayList<>(context.getBeansOfType(clazz).values());
    }

    public static ApplicationContext getInstance() {
        return context;
    }

    public static Environment getEnvironment() {
        return getInstance().getEnvironment();
    }

    public static void publishEvent(ApplicationEvent event) {
        context.publishEvent(event);
    }

    public static ConfigurableListableBeanFactory getConfigurableListableBeanFactory() {
        return ((ConfigurableApplicationContext) context).getBeanFactory();
    }
}