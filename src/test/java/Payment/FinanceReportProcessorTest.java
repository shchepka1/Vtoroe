package Payment;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class FinanceReportProcessorTest {

    @Test
    public void nameBeginsWithLetter() {
        List<Payment> payments1 = List.of(
                new Payment("Евреев Степка Алёшкович", 20, 10, 2023, 123400),
                new Payment("Хрюшковна Настюшка Владимировна", 27, 10, 2023, 4500),
                new Payment("Черенков Кириллл Киттикэтович", 13, 2, 2023, 23443),
                new Payment("Изумрудов Алмаз Брильянтович", 24, 1, 2024, 150)
        );
        List<Payment> payments = List.of(
                new Payment("Черенков Кириллл Киттикэтович", 13, 2, 2023, 23443)
        );
                FinanceReport report1 = new  FinanceReport("Адияшкинс Ануаровна Инкеева", new Date(), payments);
                FinanceReport report2 = new  FinanceReport("Адияшкинс Ануаровна Инкеева", new Date(), payments1);
        assertEquals(report1, FinanceReportProcessor.nameBeginsWithLetter(report2, payments1, 'П'));
    }
    @Test
    public void nameBeginsWithLetter1() {
        List<Payment> payments1 = List.of(
                new Payment("Евреев Степка Алёшкович", 20, 10, 2023, 123400),
                new Payment("Хрюшковна Настюшка Владимировна", 27, 10, 2023, 4500),
                new Payment("Черенков Кириллл Киттикэтович", 13, 2, 2023, 23443),
                new Payment("Изумрудов Алмаз Брильянтович", 24, 1, 2024, 150)
        );
        List<Payment> payments = List.of(
        );
        FinanceReport report1 = new  FinanceReport("Адияшкинс Ануаровна Инкеева", new Date(), payments);
        FinanceReport report2 = new  FinanceReport("Адияшкинс Ануаровна Инкеева", new Date(), payments1);
        assertEquals(report1, FinanceReportProcessor.nameBeginsWithLetter(report2, payments1, ' '));
    }
    @Test
    public void valuePayments() {
        List<Payment> payments = List.of(
                new Payment("Евреев Степка Алёшкович", 20, 10, 2023, 123400),
                new Payment("Хрюшковна Настюшка Владимировна", 27, 10, 2023, 4500),
                new Payment("Черенков Кириллл Киттикэтович", 13, 2, 2023, 23443),
                new Payment("Изумрудов Алмаз Брильянтович", 24, 1, 2024, 150)
        );
        Date date = new Date();
        FinanceReport fr1 = new FinanceReport("Адияшкинс Ануаровна Инкеева", date, payments);
        List<Payment> expectedPayments = List.of(
                new Payment("Хрюшковна Настюшка Владимировна", 27, 10, 2023, 4500),
                new Payment("Изумрудов Алмаз Брильянтович", 24, 1, 2024, 150)
        );
        FinanceReport expected = new FinanceReport("Адияшкинс Ануаровна Инкеева", date, expectedPayments);
        FinanceReport filtered = FinanceReportProcessor.valuePayments(fr1, payments, 5000);
        assertEquals(expected, filtered);
    }
    @Test
    public void valuePayments1() {
        List<Payment> payments = List.of(
                new Payment("Евреев Степка Алёшкович", 20, 10, 2023, 123400),
                new Payment("Хрюшковна Настюшка Владимировна", 27, 10, 2023, 4500),
                new Payment("Черенков Кириллл Киттикэтович", 13, 2, 2023, 23443),
                new Payment("Изумрудов Алмаз Брильянтович", 24, 1, 2024, 150)
        );
        Date date = new Date();
        FinanceReport fr1 = new FinanceReport("Адияшкинс Ануаровна Инкеева", date, payments);
        List<Payment> expectedPayments = List.of(
        );
        FinanceReport expected = new FinanceReport("Адияшкинс Ануаровна Инкеева", date, expectedPayments);
        FinanceReport filtered = FinanceReportProcessor.valuePayments(fr1, payments, ' ');
        assertEquals(expected, filtered);
    }
    @Test
    public void valuePayments2() {
        List<Payment> payments = List.of(
                new Payment("Евреев Степка Алёшкович", 20, 10, 2023, 123400),
                new Payment("Хрюшковна Настюшка Владимировна", 27, 10, 2023, 4500),
                new Payment("Черенков Кириллл Киттикэтович", 13, 2, 2023, 23443),
                new Payment("Изумрудов Алмаз Брильянтович", 24, 1, 2024, 150)
        );
        Date date = new Date();
        FinanceReport fr1 = new FinanceReport("Адияшкинс Ануаровна Инкеева", date, payments);
        assertThrows(IllegalArgumentException.class, () -> {
            FinanceReportProcessor.valuePayments(fr1, payments, -10);
        });
    }
}
