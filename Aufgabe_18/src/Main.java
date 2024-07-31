import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int SECONDS_PER_DAY = 24 * 60 * 60;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Bitte gib ein Geburtsdatum (dd.MM.yyyy) ein:");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
            LocalDate dateToday = LocalDate.now();
            printAnswer(dateOfBirth, dateToday);
        } catch (Exception exception) {
            System.out.println("Kein gültiges Datum eingegeben");
        }
    }

    private static void printAnswer(LocalDate dateOfBirth, LocalDate dateToday) {
        System.out.println("Alter in Jahren: " + calculateYears(dateOfBirth, dateToday));
        System.out.println("Alter in Monaten: " + calculateMonths(dateOfBirth, dateToday));
        System.out.println("Alter in Wochen: " + calculateWeeks(dateOfBirth, dateToday));
        System.out.println("Alter in Tagen: " + calculateDays(dateOfBirth, dateToday));
    }

    private static int calculateYears(LocalDate dateStart, LocalDate dateEnd) {
        return Period.between(dateStart, dateEnd).getYears();
    }

    private static int calculateMonths(LocalDate dateStart, LocalDate dateEnd) {
        Period periodBetween = Period.between(dateStart, dateEnd);
        return periodBetween.getYears() * 12 + periodBetween.getMonths();
    }

    private static long calculateWeeks(LocalDate dateStart, LocalDate dateEnd) {
        return calculateDays(dateStart, dateEnd) / 7;
    }

    private static long calculateDays(LocalDate dateStart, LocalDate dateEnd) {
        // Hier muss ein anderer Lösungsansatz gewählt werden als bei Years und Month, da nicht alle Monate gleich viele Tage haben.
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        long dateStartInSeconds = dateStart.atStartOfDay().atZone(zoneId).toEpochSecond();
        long dateEndInSeconds = dateEnd.atStartOfDay().atZone(zoneId).toEpochSecond();
        return (dateEndInSeconds - dateStartInSeconds) / SECONDS_PER_DAY;
    }
}