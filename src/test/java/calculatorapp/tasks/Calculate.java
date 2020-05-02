package calculatorapp.tasks;

import calculatorapp.ui.NumberPad;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class Calculate implements Task {
    public enum Operations{
        PLUS, MINUS, MULTIPLY, DIVIDE;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
    private int firstNumber=0;
    private int secondNumber=0;
    private Operations operator;

    protected Calculate(Operations operator, int firstNumber, int secondNumber) {
        this.operator = operator;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public static CalculateBuilder with(Operations operator)
    {
        return new CalculateBuilder(operator);
    }

    @Step("{0} #operator between #firstNumber and #secondNumber")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(NumberPad.NUMBER.of(String.valueOf(this.firstNumber))),
                Check.whether(this.operator == Operations.PLUS).andIfSo(
                        Click.on(NumberPad.PLUS)
                ).otherwise(
                        Check.whether(this.operator == Operations.MINUS)
                        .andIfSo(
                            Click.on(NumberPad.MINUS)
                        ).otherwise(
                                Check.whether(this.operator == Operations.MULTIPLY)
                                .andIfSo(
                                        Click.on(NumberPad.MULTIPLY)
                                )
                                .otherwise(
                                        Click.on(NumberPad.DIVIDE)
                                )
                        )
                ),
                Click.on(NumberPad.NUMBER.of(String.valueOf(this.secondNumber)))
        );
    }

    public static class CalculateBuilder
    {
        private Operations operator;
        private int firstNumber;
        public CalculateBuilder(Operations operator)
        {
            this.operator = operator;
        }

        public CalculateBuilder between(int firstNumber)
        {
            this.firstNumber= firstNumber;
            return this;
        }

        public Calculate and(int secondNumber)
        {
            return instrumented(Calculate.class, this.operator, this.firstNumber, secondNumber);
        }
    }

}
