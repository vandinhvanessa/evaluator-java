
import edu.csc413.calculator.evaluator.Evaluator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Evaluator Test")
public class EvaluatorTest {

    @Test
    void testExpression01() {
        String exp = "1+2";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(3,res);
    }

    @Test
    void testExpression02() {
        String exp = "1/2";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(0,res);
    }

    @Test
    void testExpression03() {
        String exp = "1+2*3";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(7,res);
    }

    @Test
    void testExpression04() {
        String exp = "(1+2)*3";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(9,res);
    }

    @Test
    void testExpression05() {
        String exp = "2-(3/10)+2-5";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(-1,res);
    }

    @Test
    void testExpression06() {
        String exp = "(6-12*2)/3";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(-6,res);
    }

    @Test
    void testExpression07() {
        String exp = "3^2";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(9,res);
    }

    @Test
    void testExpression08() {
        String exp = "3^2/2";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(4,res);
    }

    @Test
    void testExpression09() {
        String exp = "3^2/2 +(4+5)";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(13,res);
    }

    @Test
    void testExpression10() {
        String exp = "3^2 + (2^4) +(4+5)";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(34,res);
    }

    @Test
    void testExpression11() {
        String exp = "3+2-9+8*2 + (3+9-8/2)";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(20,res);
    }

    @Test
    void testExpression12() {
        String exp = "2+3-5*((2-3)*2-5*2+3*(2-3-5-5*6)+4/2)*2-9";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(1176,res);
    }

    @Test
    void testExpression13() {
        String exp = "39+2-4/2+7-4/2*5-78+5*4+6-4/2^2+6-3*6^4/4*5^3+1";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(-121510, res);
    }

    @Test
    void testExpression14() {
        String exp = "4!";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(24, res);
    }

    @Test
    void testExpression15() {
        String exp = "4!+3-5!+9*3!/2";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(-66, res);
    }

    @Test
    void testExpression16() {
        String exp = "5%2";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(1, res);
    }

    @Test
    void testExpression17() {
        String exp = "2+3-7*4/(10%4)*4!";
        int res;

        Evaluator ev = new Evaluator();
        res = ev.eval(exp);
        assertEquals(-331, res);
    }

}
