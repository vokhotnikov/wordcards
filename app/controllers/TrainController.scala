package controllers

import javax.inject._

import play.api._
import play.api.mvc._
import model.Model._
import model.Words

import scala.util.Random

/**
  * Created by hunter on 14/12/2016.
  */
case class CardView(query: Word, possibleAnswers: Set[Word], fromLanguage: Language, toLanguage: Language)

@Singleton
class TrainController @Inject () extends Controller {
  val rnd = new Random()

  var stripRe = """\s*\([^)]*\)\s*""".r

  def showCard(firstLangCode: String, secondLangCode: String) = Action {
    def resolveLanguage(s: String) = s match {
      case "en" => english
      case "ru" => russian
    }

    val firstLanguage = resolveLanguage(firstLangCode)
    val secondLanguage = resolveLanguage(secondLangCode)

    val wordVector = Words.vocabulary
      .filter(wa => wa.words.exists(_.language == firstLanguage) && wa.words.exists(_.language == secondLanguage))
      .toVector

    val wa = wordVector(rnd.nextInt(wordVector.size))

    val possibleQueries = wa.words.filter(_.language == firstLanguage).toVector
    val q = possibleQueries(rnd.nextInt(possibleQueries.size))
    val possibleAnswers = wa.words.filter(_.language == secondLanguage)
      .map(w => Word(stripRe.replaceAllIn(w.value, " ").trim(), w.language))

    val cardView = CardView(q, possibleAnswers, firstLanguage, secondLanguage)

    Ok(views.html.card(cardView))
  }

}
