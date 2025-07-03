package com.jhandai_padheko.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class PurchaseSummary {
    private Date purchase_date;
    private int purchase_amount;

    public PurchaseSummary(Date purchase_date, int purchase_amount) {
        this.purchase_date = purchase_date;
        this.purchase_amount = purchase_amount;
    }

    public Date getDate() {
        return purchase_date;
    }

    public String getFormattedDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(purchase_date);
    }

    public int getTotalAmount() {
        return purchase_amount;
    }
}
