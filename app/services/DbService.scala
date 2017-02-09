package services

import cats._
import data._
import implicits._
import doobie.imports._
import model.Model.Language

/**
  * Created by hunter on 08/02/2017.
  */
class DbService {
  def clearAllWords(): ConnectionIO[Unit] =
    (sql"DELETE FROM word_association_to_word".update.run *>
      sql"DELETE FROM word_association".update.run *>
      sql"DELETE FROM word_set".update.run *>
      sql"DELETE FROM word".update.run).map(_ => ())

  /**
    * Reads up existing language for the provided code, creates new record if no existing match found
    * @param code Language code to look up in the database
    * @param name Language name to use if new record is created
    * @return Either existing or inserted language record
    */
  def languageForCode(code: String, name: String): ConnectionIO[Language] = {

    val readExisting = sql"SELECT id, name, code FROM language WHERE code = $code".query[Language].option

    val addNew: ConnectionIO[Language] = sql"INSERT INTO language (name, code) VALUES ($name, $code)".update
      .withUniqueGeneratedKeys("id", "name", "code")

    // there should be a better way to do that?
    Monad[ConnectionIO].ifM(readExisting.map(_.isDefined))(readExisting.map(_.get), addNew)
  }
}
