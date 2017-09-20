package com.essential.payment.model;

public class UnionpayProcedureAuto {
    private Long id;

    private String orderid;

    private String txntime;

    private String accno;

    private String txnamt;

    private String billno;

    private String customerinfo;

    private String queryid;

    private String traceno;

    private String tracetime;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String remark5;

    private String remark6;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getTxntime() {
        return txntime;
    }

    public void setTxntime(String txntime) {
        this.txntime = txntime == null ? null : txntime.trim();
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno == null ? null : accno.trim();
    }

    public String getTxnamt() {
        return txnamt;
    }

    public void setTxnamt(String txnamt) {
        this.txnamt = txnamt == null ? null : txnamt.trim();
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    public String getCustomerinfo() {
        return customerinfo;
    }

    public void setCustomerinfo(String customerinfo) {
        this.customerinfo = customerinfo == null ? null : customerinfo.trim();
    }

    public String getQueryid() {
        return queryid;
    }

    public void setQueryid(String queryid) {
        this.queryid = queryid == null ? null : queryid.trim();
    }

    public String getTraceno() {
        return traceno;
    }

    public void setTraceno(String traceno) {
        this.traceno = traceno == null ? null : traceno.trim();
    }

    public String getTracetime() {
        return tracetime;
    }

    public void setTracetime(String tracetime) {
        this.tracetime = tracetime == null ? null : tracetime.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5 == null ? null : remark5.trim();
    }

    public String getRemark6() {
        return remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6 == null ? null : remark6.trim();
    }
}