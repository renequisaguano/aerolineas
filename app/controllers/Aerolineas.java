package controllers;

import play.mvc.*;


@With(Secure.class)
public class Aerolineas extends Controller {

    public static void index() {
        render();
    }

}
