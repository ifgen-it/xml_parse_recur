package com.company;

import java.util.List;

public class Par {

    private int step;
    private String name;
    private String fullname;
    private String comment;
    private boolean isEditable;
    private boolean isScanable;
    private boolean isVisible;
    private boolean isRequired;
    private boolean isPrinted;
    private boolean isValidateOnLine;
    private String type;
    private int min_length;
    private int max_length;
    private boolean double_input;
    private String value;
    private String reg_exp;
    private boolean from_debt;

    private List<ParList> parLists;

    public Par() {
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        isEditable = editable;
    }

    public boolean isScanable() {
        return isScanable;
    }

    public void setScanable(boolean scanable) {
        isScanable = scanable;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public boolean isPrinted() {
        return isPrinted;
    }

    public void setPrinted(boolean printed) {
        isPrinted = printed;
    }

    public boolean isValidateOnLine() {
        return isValidateOnLine;
    }

    public void setValidateOnLine(boolean validateOnLine) {
        isValidateOnLine = validateOnLine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMin_length() {
        return min_length;
    }

    public void setMin_length(int min_length) {
        this.min_length = min_length;
    }

    public int getMax_length() {
        return max_length;
    }

    public void setMax_length(int max_length) {
        this.max_length = max_length;
    }

    public boolean isDouble_input() {
        return double_input;
    }

    public void setDouble_input(boolean double_input) {
        this.double_input = double_input;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getReg_exp() {
        return reg_exp;
    }

    public void setReg_exp(String reg_exp) {
        this.reg_exp = reg_exp;
    }

    public boolean isFrom_debt() {
        return from_debt;
    }

    public void setFrom_debt(boolean from_debt) {
        this.from_debt = from_debt;
    }

    public List<ParList> getParLists() {
        return parLists;
    }

    public void setParLists(List<ParList> parLists) {
        this.parLists = parLists;
    }

    @Override
    public String toString() {
        return "Par{" +
                "step=" + step +
                ", name='" + name + '\'' +
                ", fullname='" + fullname + '\'' +
                ", comment='" + comment + '\'' +
                ", isEditable=" + isEditable +
                ", isScanable=" + isScanable +
                ", isVisible=" + isVisible +
                ", isRequired=" + isRequired +
                ", isPrinted=" + isPrinted +
                ", isValidateOnLine=" + isValidateOnLine +
                ", type='" + type + '\'' +
                ", min_length=" + min_length +
                ", max_length=" + max_length +
                ", double_input=" + double_input +
                ", value='" + value + '\'' +
                ", reg_exp='" + reg_exp + '\'' +
                ", from_debt=" + from_debt +
                ", parLists=" + parLists +
                '}';
    }
}
