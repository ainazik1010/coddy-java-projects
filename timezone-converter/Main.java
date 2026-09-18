import java.util.Scanner;
import java.time.*;
import java.time.format.*;

public class Main {
    public static String convertTime(String dateTimeStr, String sourceZone,
                                       String targetZone, boolean showOffset) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime localDateTime;
        try {
            localDateTime = LocalDateTime.parse(dateTimeStr, formatter);
        } catch (DateTimeParseException e) {
            return "Invalid datetime format";
        }

        ZonedDateTime sourceTime;
        ZonedDateTime targetTime;
        try {
            ZoneId source = ZoneId.of(sourceZone);
            ZoneId target = ZoneId.of(targetZone);
            sourceTime = localDateTime.atZone(source);
            targetTime = sourceTime.withZoneSameInstant(target);
        } catch (DateTimeException e) {
            return "Invalid time zone";
        }

        String sourceStr;
        String targetStr;

        if (showOffset) {
            DateTimeFormatter offsetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm xxx");
            sourceStr = sourceTime.format(offsetFormatter);
            targetStr = targetTime.format(offsetFormatter);
        } else {
            sourceStr = sourceTime.format(formatter);
            targetStr = targetTime.format(formatter);
        }

        return "Source: " + sourceStr + ", Target: " + targetStr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateTimeStr = scanner.nextLine();
        String sourceZone = scanner.nextLine();
        String targetZone = scanner.nextLine();
        boolean showOffset = Boolean.parseBoolean(scanner.nextLine());
        System.out.println(convertTime(dateTimeStr, sourceZone, targetZone, showOffset));
    }
}
