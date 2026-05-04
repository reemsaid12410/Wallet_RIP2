package manager;
//import للكلاس بتاع اليوزر في الmodel
import models.User;
    /**
     *
     * @author Maryam Ayman
     */
    public class AuthManager {



        private static final String DEFAULT_USERNAME = "admin";
        private static final String DEFAULT_PASSWORD = "1234";

        // نرجع الـ Singleton عشان البرنامج ميتوهش

        private static AuthManager instance;
        private User currentUser;

        private AuthManager() {}
        public static AuthManager getInstance() {
            if (instance == null) {
                instance = new AuthManager();
            }
            return instance;
        }

        public boolean login(String username, String password) {
            if (username.equals(DEFAULT_USERNAME) && password.equals(DEFAULT_PASSWORD)) {
                currentUser = new User(username, password);
                return true;
            }
            return false;
        }

        public User getCurrentUser() {
            return currentUser;
        }


        }



