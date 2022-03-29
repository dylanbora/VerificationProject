package cm;

import java.util.Iterator;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ScottDylanTestTask2.class})

class runnableTaskTwo {
    private static JUnitCore JUnitCore;

    runnableTaskTwo() {
    }

    public static void main(String[] args) {
        JUnitCore var10000 = JUnitCore;
        Result result = org.junit.runner.JUnitCore.runClasses(new Class[]{ScottDylanTestTask2.class});
        Iterator iterator = result.getFailures().iterator();

        while(iterator.hasNext()) {
            Failure failure = (Failure)iterator.next();
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
