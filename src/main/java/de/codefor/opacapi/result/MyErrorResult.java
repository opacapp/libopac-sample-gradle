package de.codefor.opacapi.result;

public class MyErrorResult extends MyResult {

    private final String errorMessage;

    public MyErrorResult(String s) {
        this.errorMessage = s;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
