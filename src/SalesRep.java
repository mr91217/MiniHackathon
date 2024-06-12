class SalesRep {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String dob;

    public SalesRep(String userId, String firstName, String lastName, String email, String phone, String dob) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + email + ", " + phone + ", " + dob + ")";
    }
}