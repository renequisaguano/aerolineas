package controllers;

import models.Avione;
import play.mvc.With;

@With(Secure.class)
@CRUD.For(Avione.class)
public class Aviones extends CRUD{

}
