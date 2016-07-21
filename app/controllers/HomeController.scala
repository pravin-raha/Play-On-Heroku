package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by synerzip1 on 21/7/16.
  */
class HomeController extends Controller {

  def index = Action {
    Ok("hi ok")
  }

}
