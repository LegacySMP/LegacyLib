package pro.nocom.legacysmp.legacylib.util.impl;

import com.google.common.annotations.Beta;
import com.google.common.reflect.ClassPath;
import pro.nocom.legacysmp.legacylib.util.Utility;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class ReflectionUtil extends Utility {
    @Beta
    @SuppressWarnings({"UnstableApiUsage", "unchecked"})
    public static <T> Set<T> getSubTypeInstancesOf(final Class<? extends T> clazz, final String packageName) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Set<T> instances = new HashSet<>();
        final ClassLoader classLoader = clazz.getClassLoader();
        final ClassPath classPath;

        classPath = ClassPath.from(classLoader);
        final Set<ClassPath.ClassInfo> classes = classPath.getTopLevelClasses(packageName);

        for (ClassPath.ClassInfo classInfo : classes) {
            final Class<?> loadedClass = classInfo.load();
            final Class<? extends T> deathReason = loadedClass.asSubclass(clazz);
            final Constructor<?> constructor = deathReason.getConstructor();
            final T instance = (T) constructor.newInstance();

            instances.add(instance);
        }

        return Collections.unmodifiableSet(instances);
    }
}
