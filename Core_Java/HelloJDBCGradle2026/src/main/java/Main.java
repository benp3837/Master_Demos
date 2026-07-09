import com.revature.DAOs.UserDAOImpl;
import com.revature.controllers.GameController;
import com.revature.controllers.UserController;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //Test that our DB connection works
        try (Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("//DB CONNECTION SUCCESSFUL!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        UserController userController = new UserController();
        GameController gameController = new GameController();

        //Start the Javalin application
        Javalin.create(config -> {
            config.routes.apiBuilder(() -> {
                //Base path - just an example
                path("/", () -> {
                    get(ctx -> ctx.result("Welcome to the API!"));
                });

                //User path - HTTP requests that trigger the User controller
                path("/users", () -> {
                    get(userController::getAllUsers);
                    post(userController::insertUser);
                    put(userController::updateUser);
                    path("/{id}", () -> {
                        get(userController::getUserById);
                    });
                });

                //Game path - HTTP requests that trigger the Game controller
                path("/games", () -> {
                    get(gameController::getAllGames);
                    post(gameController::insertGame);
                    path("/{id}", () -> {
                        get(gameController::getGamesByUserId);
                        put(gameController::updateGame);
                    });
                });
            });
        }).start(8080);

        //Quick call to all CRUDs using UserDAOImpl

        UserDAOImpl uDAO = new UserDAOImpl();
        System.out.println(uDAO.getAllUsers());
        System.out.println(uDAO.getUserById(1));
        System.out.println(uDAO.insertUser(new User("password", "role", "username")));
        System.out.println(uDAO.updateUser(new User(1, "newpassword", "newrole", "newusername")));
        }
    }
