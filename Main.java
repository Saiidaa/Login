import com.company.*

import java.util.ArrayList;

private static class Registration {

        private final String firstName;
        private final String lastName;
        private final String email;
    private Registration StringValidator;

    private Registration(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public static Registration fromRequestParameters(
                HttpServletRequest request) {
            return new Registration(
                    request.getParameter("firstname"),
                    request.getParameter("lastname"),
                    request.getParameter("email"));
        }

        public void setAsRequestAttributes(HttpServletRequest request) {
            request.setAttribute("firstname", firstName);
            request.setAttribute("lastname", lastName);
            request.setAttribute("email", email);
        }

        public List validate() {
            List violations = new ArrayList<>();
            if (!StringValidator.validate(firstName)) {
                ((ArrayList<?>) violations).add("fill in this field");
            }
            if (!StringValidator.validate(lastName)) {
                violations.add("fill in this field");
            }
            if (!EmailValidator.validate(email)) {
                violations.add("fill in this field");
            }
            return violations;
        }

    }

}