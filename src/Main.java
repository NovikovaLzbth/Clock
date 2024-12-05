import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ввод начального времени
        String[] startTime = scanner.nextLine().split(" ");
        int startHour = Integer.parseInt(startTime[0]);
        int startMinute = Integer.parseInt(startTime[1]);

        // ввод конечного времени
        String[] endTime = scanner.nextLine().split(" ");
        int endHour = Integer.parseInt(endTime[0]);
        int endMinute = Integer.parseInt(endTime[1]);

        int totalStrikes = 0;

        // перебор всех минут от начального до конечного времени
        for (int hour = startHour; hour <= endHour; hour++) {
            for (int minute = (hour == startHour ? startMinute : 0); minute < (hour == endHour ? endMinute : 60); minute++) {
                if (minute == 30) continue; // пропуск 30 минут
                totalStrikes += getStrikes(hour);
            }
        }

        System.out.println(totalStrikes);
    }

    // метод для получения количества ударов в зависимости от часа
    private static int getStrikes(int hour) {
        int strikes = 0;
        int hourIn12Format = hour % 12; // приводим к 12-часовому формату
        if (hourIn12Format == 0) hourIn12Format = 12; // в полночь и полдень часы бьют 12 раз

        // удары в начале часа
        strikes += hourIn12Format;

        // удар в середине часа
        strikes += 1;

        return strikes;
    }
}
