/*
 * This file is generated by jOOQ.
 */
package com.rpkit.economy.bukkit.database.jooq;


import com.rpkit.economy.bukkit.database.jooq.tables.RpkitMoneyHidden;
import com.rpkit.economy.bukkit.database.jooq.tables.RpkitWallet;
import com.rpkit.economy.bukkit.database.jooq.tables.records.RpkitMoneyHiddenRecord;
import com.rpkit.economy.bukkit.database.jooq.tables.records.RpkitWalletRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * rpkit_economy.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<RpkitMoneyHiddenRecord> KEY_RPKIT_MONEY_HIDDEN_PRIMARY = Internal.createUniqueKey(RpkitMoneyHidden.RPKIT_MONEY_HIDDEN, DSL.name("KEY_rpkit_money_hidden_PRIMARY"), new TableField[] { RpkitMoneyHidden.RPKIT_MONEY_HIDDEN.CHARACTER_ID }, true);
    public static final UniqueKey<RpkitWalletRecord> KEY_RPKIT_WALLET_PRIMARY = Internal.createUniqueKey(RpkitWallet.RPKIT_WALLET, DSL.name("KEY_rpkit_wallet_PRIMARY"), new TableField[] { RpkitWallet.RPKIT_WALLET.CHARACTER_ID, RpkitWallet.RPKIT_WALLET.CURRENCY_NAME }, true);
}
