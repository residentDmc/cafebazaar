package com.dev.alarmapplication.utils.alarm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class DebugUtils {

    private static final String[] SETUP_TASKS = {
            "me.jfenn.alarmio.utils.LeakCanaryTask",
            "me.jfenn.alarmio.utils.CrasherTask"
    };

    public static void setup(Alarmio alarmio) {
        for (String task : SETUP_TASKS) {
            try {
                Constructor<SetupTask> constructor = (Constructor<SetupTask>) Class.forName(task).getConstructor();
                constructor.setAccessible(true);
                constructor.newInstance().setup(alarmio);
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public interface SetupTask {
        void setup(Alarmio alarmio);
    }

}
