package Util;
import java.awt.Color;
import java.awt.Font;

public class Themes {



    /**
     * Theme — كل الألوان والخطوط بتاعة wallet_RIP
     *
     * بنحط كل حاجة هنا عشان لو حبينا نغير لون أو خط
     * نغيره في مكان واحد بس.
     */



        // OLIVE (اللون الرئيسي)

        public static final Color OLIVE       = new Color(0x5A7A18);
        public static final Color OLIVE_DARK  = new Color(0x4A6814);
        public static final Color OLIVE_LIGHT = new Color(0x6B8C24);


        // INK

        public static final Color INK_BG      = new Color(0xFDFAF4); // خلفية البانلات
        public static final Color INK_BG_ALT  = new Color(0xEDE8DC); // خلفية الـ inputs
        public static final Color PAGE_BG     = new Color(0xF0EBE0); // خلفية الصفحة الكبيرة


        // SAND (النصوص)

        public static final Color SAND_DARK   = new Color(0x1E1A10); // النصوص الأساسية
        public static final Color SAND        = new Color(0x3A3020); // نصوص ثانوية
        public static final Color MUTED       = new Color(0x8A8070); // نصوص خافتة


        public static final Color RED_ACCENT  = new Color(0xC0623A); // total spent
        public static final Color TEAL        = new Color(0x2E6A58); // transactions
        public static final Color BORDER      = new Color(0xC8C0A8); // كل الـ borders
        public static final Color BORDER_SOFT = new Color(0xE8E0CC); // borders خفيفة

        // ═══════════════════════════════════════
        // CATEGORY COLORS (ألوان الفئات)
        // ═══════════════════════════════════════
        public static final Color FOOD_BG       = new Color(0xD8F0B8);
        public static final Color FOOD_TEXT     = new Color(0x3A6010);
        public static final Color FOOD_BORDER   = new Color(0xA8D070);

        public static final Color TRANSPORT_BG     = new Color(0xFFF0C0);
        public static final Color TRANSPORT_TEXT   = new Color(0x7A6000);
        public static final Color TRANSPORT_BORDER = new Color(0xE0C840);

        public static final Color SHOPPING_BG      = new Color(0xC8E8F8);
        public static final Color SHOPPING_TEXT    = new Color(0x1A4A70);
        public static final Color SHOPPING_BORDER  = new Color(0x80B8E0);

        public static final Color BILLS_BG      = new Color(0xF8D8C8);
        public static final Color BILLS_TEXT    = new Color(0x7A3010);
        public static final Color BILLS_BORDER  = new Color(0xE0A080);




        public static final Font FONT_TITLE_LG = new Font("Arial", Font.BOLD, 32);
        public static final Font FONT_TITLE_MD = new Font("Arial", Font.BOLD, 22);
        public static final Font FONT_TITLE_SM = new Font("Arial", Font.BOLD, 16);


        public static final Font FONT_BODY      = new Font("SansSerif", Font.PLAIN, 13);
        public static final Font FONT_BODY_BOLD = new Font("SansSerif", Font.BOLD, 13);
        public static final Font FONT_BODY_SM   = new Font("SansSerif", Font.PLAIN, 11);


        public static final Font FONT_MONO     = new Font("Monospaced", Font.PLAIN, 11);
        public static final Font FONT_MONO_SM  = new Font("Monospaced", Font.PLAIN, 9);


        public static final Font FONT_BUTTON   = new Font("Arial", Font.BOLD, 14);


        public static final int PADDING_SM = 8;
        public static final int PADDING_MD = 14;
        public static final int PADDING_LG = 22;


        private Themes() {}
    }

