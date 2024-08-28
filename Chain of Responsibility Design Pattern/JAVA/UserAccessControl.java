// Define the abstract base class for user access handlers.
abstract class UserAccessHandler {
    protected UserAccessHandler nextHandler;

    public UserAccessHandler(UserAccessHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleAccess(String userRole);
}

// Concrete handler for user authentication.
class AuthenticationHandler extends UserAccessHandler {
    public AuthenticationHandler(UserAccessHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleAccess(String userRole) {
        System.out.println("Authenticating user with role: " + userRole);
        // Perform authentication logic here

        // If authentication is successful, pass it to the next handler
        if (nextHandler != null) {
            nextHandler.handleAccess(userRole);
        }
    }
}

// Concrete handler for user authorization.
class AuthorizationHandler extends UserAccessHandler {
    public AuthorizationHandler(UserAccessHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleAccess(String userRole) {
        System.out.println("Authorizing access for user with role: " + userRole);
        // Perform authorization logic here

        // If authorization is successful, pass it to the next handler
        if (nextHandler != null) {
            nextHandler.handleAccess(userRole);
        }
    }
}

// Concrete handler for checking user permissions.
class PermissionCheckHandler extends UserAccessHandler {
    public PermissionCheckHandler(UserAccessHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleAccess(String userRole) {
        System.out.println("Checking permissions for user with role: " + userRole);
        // Perform permission check logic here

        // If permissions are granted, pass it to the next handler
        if (nextHandler != null) {
            nextHandler.handleAccess(userRole);
        }
    }
}

// Concrete handler for logging access attempts.
class AccessLoggingHandler extends UserAccessHandler {
    public AccessLoggingHandler(UserAccessHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleAccess(String userRole) {
        System.out.println("Logging access attempt for user with role: " + userRole);
        // Perform access logging logic here

        // If logging is done, pass it to the next handler
        if (nextHandler != null) {
            nextHandler.handleAccess(userRole);
        }
    }
}

// Concrete handler for successful access notification.
class AccessSuccessHandler extends UserAccessHandler {
    public AccessSuccessHandler(UserAccessHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleAccess(String userRole) {
        System.out.println("Access granted for user with role: " + userRole);
        // Perform any final actions for successful access
    }
}

class UserAccessControl {
    public static void main(String[] args) {
        // Create a chain of responsibility for user access handling
        UserAccessHandler accessChain = new AuthenticationHandler(
                new AuthorizationHandler(
                        new PermissionCheckHandler(
                                new AccessLoggingHandler(
                                        new AccessSuccessHandler(null)))));

        // Simulate an access attempt by a user with a specific role
        String userRole = "Admin";
        accessChain.handleAccess(userRole);
    }
}
