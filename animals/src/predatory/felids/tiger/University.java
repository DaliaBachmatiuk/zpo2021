package predatory.felids.tiger;

public class University implements Comparable<University>{
    private final int position;
    private final String name;
    private final String country;
    private final int educationQuality;
    private final int employmentOfGraduates;
    private final int publication;
    private final int citations;
    private final int patent;
    private final double score;

    public University(int position, String name, String country, int educationQuality, int employmentOfGraduates, int publication, int citations, int patent, double score) {
        if (name.isBlank() || name.isEmpty())
        {
            System.out.println("Name can't be empty or blank.");
            name = "";
        }
        if (position < 0) {
            System.out.println("Wrong number, can't be negative or 0.");
            position = 0;
        }
        if (country.isEmpty() || country.isBlank())
        {
            System.out.println("Country can't be empty or blank.");
            country = "";
        }
        if (educationQuality < 0) {
            System.out.println("Wrong number, can't be negative or 0.");
            educationQuality = 0;
        }
        if (employmentOfGraduates < 0) {
            System.out.println("Wrong number, can't be negative or 0.");
            employmentOfGraduates = 0;
        }
        if (publication < 0) {
            System.out.println("Wrong number, can't be negative or 0.");
            publication = 0;
        }
        if (citations < 0) {
            System.out.println("Wrong number, can't be negative or 0.");
            citations = 0;
        }
        if (patent < 0) {
            System.out.println("Wrong number, can't be negative or 0.");
            patent = 0;
        }
        if (score < 0) {
            System.out.println("Wrong number, can't be negative or 0.");
            score = 0;
        }
        this.position = position;
        this.name = name;
        this.country = country;
        this.educationQuality = educationQuality;
        this.employmentOfGraduates = employmentOfGraduates;
        this.publication = publication;
        this.citations = citations;
        this.patent = patent;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getEducationQuality() {
        return educationQuality;
    }

    public double getScore() {
        return score;
    }

    @Override
    public int compareTo(University o) {
        return Integer.compare(employmentOfGraduates, o.employmentOfGraduates);
    }
}
