package controllers;

import play.mvc.*;

@With(Secure.class)
@Check("isAdmin")
public class Vuelos extends CRUD {


}
