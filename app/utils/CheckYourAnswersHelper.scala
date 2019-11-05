/*
 * Copyright 2019 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package utils

import java.time.format.DateTimeFormatter

import controllers.routes
import models.{CheckMode, UserAnswers}
import pages._
import play.api.i18n.Messages
import CheckYourAnswersHelper._
import uk.gov.hmrc.viewmodels._
import uk.gov.hmrc.viewmodels.SummaryList._
import uk.gov.hmrc.viewmodels.Text.Literal

class CheckYourAnswersHelper(userAnswers: UserAnswers)(implicit messages: Messages) {

  def traderName: Option[Row] = userAnswers.get(TraderNamePage) map {
    answer =>
      Row(
        key     = Key(msg"traderName.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(lit"$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.TraderNameController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"traderName.checkYourAnswersLabel"))
          )
        )
      )
  }

  def movementReferenceNumber: Option[Row] = userAnswers.get(MovementReferenceNumberPage) map {
    answer =>
      Row(
        key     = Key(msg"movementReferenceNumber.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(lit"$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.MovementReferenceNumberController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"movementReferenceNumber.checkYourAnswersLabel"))
          )
        )
      )
  }

  def goodsLocation: Option[Row] = userAnswers.get(GoodsLocationPage) map {
    answer =>
      Row(
        key     = Key(msg"goodsLocation.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(msg"goodsLocation.$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.GoodsLocationController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"goodsLocation.checkYourAnswersLabel"))
          )
        )
      )
  }

  def customsSubPlace: Option[Row] = userAnswers.get(CustomsSubPlacePage) map {
    answer =>
      Row(
        key     = Key(msg"customsSubPlace.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(lit"$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.CustomsSubPlaceController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"customsSubPlace.checkYourAnswersLabel"))
          )
        )
      )
  }

  def authorisedLocation: Option[Row] = userAnswers.get(AuthorisedLocationPage) map {
    answer =>
      Row(
        key     = Key(msg"authorisedLocation.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(lit"$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.AuthorisedLocationController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"authorisedLocation.checkYourAnswersLabel"))
          )
        )
      )
  }

  private def yesOrNo(answer: Boolean): Content =
    if (answer) {
      msg"site.yes"
    } else {
      msg"site.no"
    }
}

object CheckYourAnswersHelper {

  private val dateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy")
}
