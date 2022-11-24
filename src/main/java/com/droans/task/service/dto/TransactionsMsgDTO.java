package com.droans.task.service.dto;

public class TransactionsMsgDTO
{

    private boolean error = false;

    private boolean success = true;



    private String massage ;

    public TransactionsMsgDTO() {
    }

    public TransactionsMsgDTO(boolean error, boolean success, String massage) {
        this.error = error;
        this.success = success;
        this.massage = massage;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }







}
