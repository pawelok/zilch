package enums;

public enum Platform {
    IOS {
        @Override
        public String toString() {
            return "ios";
        }
    },
    ANDROID {
        @Override
        public String toString() {
            return "android";
        }
    };
}
