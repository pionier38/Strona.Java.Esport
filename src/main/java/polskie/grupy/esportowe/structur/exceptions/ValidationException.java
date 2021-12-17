package polskie.grupy.esportowe.structur.exceptions;

public class ValidationException extends RuntimeException {
    private String validationInfo;

    public ValidationException(String validationInfo) {
        this.validationInfo = validationInfo;
    }

    public String getValidationInfo() {
        return validationInfo;
    }
}
