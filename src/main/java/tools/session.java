package tools;

import jakarta.servlet.http.HttpSession;

public class session {
    public static void clearSession(HttpSession session) {
        session.invalidate();
    }
}
