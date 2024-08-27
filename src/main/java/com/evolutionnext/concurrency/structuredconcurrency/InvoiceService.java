package com.evolutionnext.concurrency.structuredconcurrency;

import java.util.List;

public class InvoiceService {
    public List<Invoice> findAllInvoicesByUser(Long id) {
        System.out.println("findAllInvoicesByUser" + Thread.currentThread());
        return List.of(
            new Invoice("402", 1120.00F),
            new Invoice("1402", 1220.00F),
            new Invoice("671", 1220.00F)
        );
    }

    public List<Invoice> findAllInvoicesByUserLongTime(long id) {
        System.out.println("findAllInvoicesByUser" + Thread.currentThread());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return List.of(
            new Invoice("402", 1120.00F),
            new Invoice("1402", 1220.00F),
            new Invoice("671", 1220.00F)
        );
    }
}
