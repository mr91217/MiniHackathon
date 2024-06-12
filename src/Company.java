class Company {
    private String organizationId;
    private String salesRepId;
    private String name;
    private String website;
    private String country;
    private String description;
    private String founded;
    private String industry;
    private String numberOfEmployees;

    public Company(String organizationId, String salesRepId, String name, String website, String country, String description, String founded, String industry, String numberOfEmployees) {
        this.organizationId = organizationId;
        this.salesRepId = salesRepId;
        this.name = name;
        this.website = website;
        this.country = country;
        this.description = description;
        this.founded = founded;
        this.industry = industry;
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return "Organization Id: " + organizationId + ", Company Name: " + name + ", Country: " + country + ", Industry: " + industry + ", Number of employees: " + numberOfEmployees;
    }
}