package calculatorapp.questions;

import calculatorapp.ui.NumberPad;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ResultPreview implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(NumberPad.RESULT_PREVIEW).viewedBy(actor).asString();
    }
}
