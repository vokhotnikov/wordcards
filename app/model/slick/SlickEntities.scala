package model.slick

import play.api.db.slick._
import slick.driver.JdbcProfile

/**
  * Created by hunter on 11/01/2017.
  */
trait SlickEntities extends HasDatabaseConfigProvider[JdbcProfile] {
  import dbConfig.driver.api._

  case class Language(id: Int, name: String, code: String)
  case class NewLanguage(name: String, code: String)

  class Languages(tag: Tag) extends Table[Language] (tag, "language") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def code = column[String]("code")

    def * = (id , name , code) <> (Language.tupled, Language.unapply)
    def forInsert = (name , code) <> (NewLanguage.tupled, NewLanguage.unapply)
  }

}
