package controllers

import javax.inject._

import play.api._
import play.api.mvc._

/**
  * Created by hunter on 11/01/2017.
  */
@Singleton
class DbAdminController @Inject ()() extends Controller {

  def bootstrapWords() = Action {
    Ok("wha?")
  }
}
