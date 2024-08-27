package com.evolutionnext.concurrency.structuredconcurrency;

import java.util.List;

public record UserInvoices(User user, List<Invoice> invoices) {
}
