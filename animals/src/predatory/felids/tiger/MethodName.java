package predatory.felids.tiger;

public enum MethodName {
    NAME ("Name"),
    COUNTRY ("Country"),
    EDUCATION_QUALITY ("EducationQuality"),
    EMPLOYMENT_OF_GRADUATES ("EmploymentOfGraduates"),
    SCORE ("Score");

    public final String name;

    MethodName(String name) {
        this.name = name;
    }
}
