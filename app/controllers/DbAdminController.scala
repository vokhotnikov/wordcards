package controllers

import javax.inject._

import play.api._
import play.api.db.slick._
import play.api.mvc._
import slick.driver.JdbcProfile

/**
  * Created by hunter on 11/01/2017.
  */
@Singleton
class DbAdminController @Inject ()(dbConfigProvider: DatabaseConfigProvider) extends Controller {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  def bootstrapWords() = Action {
    Ok("wha?")
  }
}
