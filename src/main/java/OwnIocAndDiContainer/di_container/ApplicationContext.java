package OwnIocAndDiContainer.di_container;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private final Map<String, Object> beans = new HashMap<>();

    public ApplicationContext(String packageName) {
        try (ScanResult scanResult = new ClassGraph().enableAllInfo().whitelistPackages(packageName).scan()) {
            scanResult.getClassesWithAnnotation(Bean.class.getName()).loadClasses().forEach(this::createBeanInstance);
        }
    }

    private void createBeanInstance(Class<?> clazz) {
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object beanInstance = constructor.newInstance();
            beans.put(clazz.getSimpleName(), beanInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void registerBean(Object beanInstance) {
        beans.put(beanInstance.getClass().getSimpleName(), beanInstance);
    }
    public Map<String, Object> getBeans() {
        return beans;
    }
}