/*
 * This file is generated by jOOQ.
 */
package com.rpkit.featureflags.bukkit.database.jooq;


import com.rpkit.featureflags.bukkit.database.jooq.tables.RpkitProfileFeatureFlag;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitFeatureFlags extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_feature_flags</code>
     */
    public static final RpkitFeatureFlags RPKIT_FEATURE_FLAGS = new RpkitFeatureFlags();

    /**
     * The table <code>rpkit_feature_flags.rpkit_profile_feature_flag</code>.
     */
    public final RpkitProfileFeatureFlag RPKIT_PROFILE_FEATURE_FLAG = RpkitProfileFeatureFlag.RPKIT_PROFILE_FEATURE_FLAG;

    /**
     * No further instances allowed
     */
    private RpkitFeatureFlags() {
        super("rpkit_feature_flags", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            RpkitProfileFeatureFlag.RPKIT_PROFILE_FEATURE_FLAG);
    }
}
