package Util;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {





        private static final DateTimeFormatter FORMATTER =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        /**
         * يحوّل تاريخ لنص بصيغة "2026-04-28"
         */
        public static String formatDate(LocalDate date) {
            if (date == null) return "";
            return date.format(FORMATTER);
        }

        /**
         * يحوّل نص لتاريخ
         * @return null لو النص غلط
         */
        public static LocalDate parseDate(String text) {
            if (text == null || text.trim().isEmpty()) return null;
            try {
                return LocalDate.parse(text.trim(), FORMATTER);
            } catch (DateTimeParseException e) {
                return null;
            }
        }

        /**
         * تاريخ النهاردة
         */
        public static LocalDate today() {
            return LocalDate.now();
        }

        /**
         * تاريخ النهاردة كنص
         */
        public static String todayString() {
            return formatDate(today());
        }

        /**
         * يتحقق إن النص تاريخ صحيح
         */
        public static boolean isValidDate(String text) {
            return parseDate(text) != null;
        }

        private DateUtil() {}
    }

