package BTO.Enum;

public enum UserType {
    APPLICANT,
    HDBOFFICER,
    HDBMANAGER;

    @Override
    public String toString() {
        return switch (this) {
            case APPLICANT   -> "APPLICANT";
            case HDBOFFICER  -> "HDBOFFICER";
            case HDBMANAGER  -> "HDBMANAGER";
        };
    }
}
