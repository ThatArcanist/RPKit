/*
 * This file is generated by jOOQ.
 */
package com.rpkit.payments.bukkit.database.jooq;


import java.util.Arrays;
import java.util.List;

import org.jooq.Schema;
import org.jooq.impl.CatalogImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultCatalog extends CatalogImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_CATALOG</code>
     */
    public static final DefaultCatalog DEFAULT_CATALOG = new DefaultCatalog();

    /**
     * The schema <code>rpkit_payments</code>.
     */
    public final RpkitPayments RPKIT_PAYMENTS = RpkitPayments.RPKIT_PAYMENTS;

    /**
     * No further instances allowed
     */
    private DefaultCatalog() {
        super("");
    }

    @Override
    public final List<Schema> getSchemas() {
        return Arrays.<Schema>asList(
            RpkitPayments.RPKIT_PAYMENTS);
    }
}
