package predatory.felids;

import predatory.felids.tiger.MethodName;
import predatory.felids.tiger.UniversityListPrinter;
import predatory.felids.tiger.University;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Lion {
    public static void main(String[] args) throws FileNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        ArrayList<University> universities = readFile(new File("D:\\Dalia\\studia\\5sem\\zpo\\animals\\src\\cats\\uni.txt"));

        UniversityListPrinter printer = new UniversityListPrinter();

        System.out.println("Before sorted on employmentOfGraduates: ");
        System.out.println(printer.getString(universities, MethodName.EMPLOYMENT_OF_GRADUATES.name) + "\n");

        Collections.sort(universities);
        System.out.println("After sorted on employmentOfGraduates: ");
        System.out.println(printer.getString(universities, MethodName.EMPLOYMENT_OF_GRADUATES.name) + "\n");

        System.out.println("Before sorted on name: ");
        System.out.println(printer.getString(universities, MethodName.NAME.name) + "\n");

        sortOnName(universities);
        System.out.println("After sorted on name: ");
        System.out.println(printer.getString(universities, MethodName.NAME.name) + "\n");

        System.out.println("Before sorted on country: ");
        System.out.println(printer.getString(universities, MethodName.COUNTRY.name) + "\n");

        sortOnCountry(universities);
        System.out.println("After sorted on country: ");
        System.out.println(printer.getString(universities, MethodName.COUNTRY.name) + "\n");

        System.out.println("Before sorted on score: ");
        System.out.println(printer.getString(universities, MethodName.SCORE.name) + "\n");

        sortOnScore(universities);
        System.out.println("After sorted on score: ");
        System.out.println(printer.getString(universities, MethodName.SCORE.name) + "\n");

        System.out.println("Before sorted on educationQuality: ");
        System.out.println(printer.getString(universities, MethodName.EDUCATION_QUALITY.name) + "\n");

        sortOnEducationQuality(universities);
        System.out.println("After sorted on educationQuality: ");
        System.out.println(printer.getString(universities, MethodName.EDUCATION_QUALITY.name) + "\n");
    }

    public static ArrayList<University> readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<University> university = new ArrayList<>();

        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().split("\t");
            university.add(new University(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]),
                    Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Double.parseDouble(data[8])));
        }
        scanner.close();
        return university;
    }

    public static void sortOnName(ArrayList<University> universities) {
        universities.sort(Comparator.comparing((University university) -> university.getName().toLowerCase()));
    }

    public static void sortOnCountry(ArrayList<University> universities) {
        universities.sort((University university1, University university2) -> (university2.getCountry().toLowerCase().compareTo(university1.getCountry().toLowerCase())));
    }

    public static void sortOnScore(ArrayList<University> universities) {
        universities.sort(Comparator.comparingDouble(University::getScore));
    }

    public static void sortOnEducationQuality(ArrayList<University> universities) {
        universities.sort((University university1, University university2) -> Integer.compare(university2.getEducationQuality(), university1.getEducationQuality()));
    }
}
