/*
 * This file is generated by jOOQ.
 */
package com.rpkit.economy.bukkit.database.jooq.tables.records;


import com.rpkit.economy.bukkit.database.jooq.tables.RpkitWallet;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitWalletRecord extends UpdatableRecordImpl<RpkitWalletRecord> implements Record3<Integer, String, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>rpkit_economy.rpkit_wallet.character_id</code>.
     */
    public void setCharacterId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>rpkit_economy.rpkit_wallet.character_id</code>.
     */
    public Integer getCharacterId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>rpkit_economy.rpkit_wallet.currency_name</code>.
     */
    public void setCurrencyName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>rpkit_economy.rpkit_wallet.currency_name</code>.
     */
    public String getCurrencyName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>rpkit_economy.rpkit_wallet.balance</code>.
     */
    public void setBalance(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>rpkit_economy.rpkit_wallet.balance</code>.
     */
    public Integer getBalance() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Integer, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RpkitWallet.RPKIT_WALLET.CHARACTER_ID;
    }

    @Override
    public Field<String> field2() {
        return RpkitWallet.RPKIT_WALLET.CURRENCY_NAME;
    }

    @Override
    public Field<Integer> field3() {
        return RpkitWallet.RPKIT_WALLET.BALANCE;
    }

    @Override
    public Integer component1() {
        return getCharacterId();
    }

    @Override
    public String component2() {
        return getCurrencyName();
    }

    @Override
    public Integer component3() {
        return getBalance();
    }

    @Override
    public Integer value1() {
        return getCharacterId();
    }

    @Override
    public String value2() {
        return getCurrencyName();
    }

    @Override
    public Integer value3() {
        return getBalance();
    }

    @Override
    public RpkitWalletRecord value1(Integer value) {
        setCharacterId(value);
        return this;
    }

    @Override
    public RpkitWalletRecord value2(String value) {
        setCurrencyName(value);
        return this;
    }

    @Override
    public RpkitWalletRecord value3(Integer value) {
        setBalance(value);
        return this;
    }

    @Override
    public RpkitWalletRecord values(Integer value1, String value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitWalletRecord
     */
    public RpkitWalletRecord() {
        super(RpkitWallet.RPKIT_WALLET);
    }

    /**
     * Create a detached, initialised RpkitWalletRecord
     */
    public RpkitWalletRecord(Integer characterId, String currencyName, Integer balance) {
        super(RpkitWallet.RPKIT_WALLET);

        setCharacterId(characterId);
        setCurrencyName(currencyName);
        setBalance(balance);
    }
}
