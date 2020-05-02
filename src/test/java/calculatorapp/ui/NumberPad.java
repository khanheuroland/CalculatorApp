package calculatorapp.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class NumberPad {
    public static Target NUMBER = Target.the("the number {0}")
            .locatedBy("//*[@text=\"{0}\"]");

    public static Target PLUS = Target.the("Plus operation")
            .located(By.id("com.google.android.calculator:id/op_add"));

    public static Target MINUS = Target.the("Plus operation")
            .located(By.id("com.google.android.calculator:id/op_sub"));

    public static Target MULTIPLY = Target.the("Plus operation")
            .located(By.id("com.google.android.calculator:id/op_mul"));

    public static Target DIVIDE = Target.the("Plus operation")
            .located(By.id("com.google.android.calculator:id/op_div"));

    public static Target EQUALS = Target.the("equal button")
            .located(By.id("com.google.android.calculator:id/eq"));

    public static Target RESULT_PREVIEW = Target.the("result preview")
            .located(By.id("com.google.android.calculator:id/result_preview"));


}
