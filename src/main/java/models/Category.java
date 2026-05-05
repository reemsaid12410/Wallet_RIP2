package models;

import java.awt.Color;

    public final class Category {

        // Static constants instead of enum values
        public static final Category FOOD = new Category("Food", "🍔", new Color(0x3F6010), new Color(0xE8F0D0));
        public static final Category TRANSPORT = new Category("Transport", "🚗", new Color(0x006070), new Color(0xD0EEF0));
        public static final Category SHOPPING = new Category("Shopping", "🛍️", new Color(0x1A4470), new Color(0xD0E0F0));
        public static final Category BILLS = new Category("Bills", "🧾", new Color(0x703A10), new Color(0xF0E0D0));

        // All fields are final
        private final String displayName;
        private final String emoji;
        private final Color color;
        private final Color backgroundColor;

        // Private constructor — no one can create new categories outside this class
        private Category(String displayName, String emoji, Color color, Color backgroundColor) {
            this.displayName = displayName;
            this.emoji = emoji;
            this.color = color;
            this.backgroundColor = backgroundColor;

        }

        public String getDisplayName() {
            return displayName;
        }

        public String getEmoji() {
            return emoji;
        }

        public Color getColor() {
            return color;
        }

        public Color getBackgroundColor() {
            return backgroundColor;
        }

        // 5. ميثود الـ toString عشان يظهر الاسم في الـ ComboBox
        @Override
        public String toString() {
            return displayName;
        }

    }


