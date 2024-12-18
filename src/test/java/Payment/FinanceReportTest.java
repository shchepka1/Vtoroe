package Payment;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class FinanceReportTest {

    @Test
    public void getIndexOfPayments() {
        List<Payment> payments = List.of(
                new Payment("Евреев Степка", 20, 10, 2023, 123400),
                new Payment("Хрюшковна Настюшка", 27, 10, 2023, 4500),
                new Payment("Черенков Кириллл Киттикэтович", 13, 2, 2023, 23443),
                new Payment("Изумрудов Алмаз Брильянтович", 24, 1, 2024, 150)
        );
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        Payment expectedPayment = report.getIndexOfPayments(2);
        assertEquals(expectedPayment, report.getIndexOfPayments(2));
    }

    @Test
    public void getIndexOfPaymentException() {
        List<Payment> payments = List.of(
                new Payment("Евреев Степка", 20, 10, 2023, 123400),
                new Payment("Хрюшковна Настюшка", 27, 10, 2023, 4500),
                new Payment("Черенков Кириллл Киттикэтович", 13, 2, 2023, 23443),
                new Payment("Изумрудов Алмаз Брильянтович", 24, 1, 2024, 150)
        );
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            report.getIndexOfPayments(-2);
        });
    }

    @Test
    public void getIndexOfPaymentException1() {
        List<Payment> payments = List.of(
                new Payment("Евреев Степка", 20, 10, 2023, 123400),
                new Payment("Хрюшковна Настюшка", 27, 10, 2023, 4500),
                new Payment("Черенков Кириллл Киттикэтович", 13, 2, 2023, 23443),
                new Payment("Изумрудов Алмаз Брильянтович", 24, 1, 2024, 150)
        );
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            report.getIndexOfPayments(5);
        });
    }

    @Test
    public void setPaymentIndex() {
        List<Payment> payments = new ArrayList<>(List.of(
                new Payment("Test 1", 1, 1, 2024, 1000)
        ));
        Payment newPayment = new Payment("Хрюшковна Настюшка", 27, 10, 2023, 4500);
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        report.setPaymentIndex(0, newPayment);
        assertEquals(newPayment, report.getIndexOfPayments(0));
    }

    @Test
    public void setIndexOfPaymentsException() {
        List<Payment> payments = new ArrayList<>(List.of(
                new Payment("Test 1", 1, 1, 2024, 1000)
        ));
        Payment newPayment = new Payment("Хрюшковна Настюшка", 27, 10, 2023, 4500);
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            report.setPaymentIndex(-1, newPayment);
        });
    }

    @Test
    public void setIndexOfPaymentsException1() {
        List<Payment> payments = new ArrayList<>(List.of(
                new Payment("Test 1", 1, 1, 2024, 1000)
        ));
        Payment newPayment = new Payment("Хрюшковна Настюшка", 27, 10, 2023, 4500);
        FinanceReport report = new FinanceReport("Test Author", new Date(), payments);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            report.setPaymentIndex(3, newPayment);
        });
    }
}