package scenarios

import io.gatling.core.Predef._
import services.entitlements.ViaLabelFiles
import services.issues.CreatingnewIssueonAdmin
import services.offers.FetchingalistofPricesForaSpecificIssue
import services.orders.PurchasingSingleIssue
import services.publications.MigratingPublication
import services.publishers.MigratingPublisher
import services.subscriptions.PurchasingaSubscription
import services.users.{CustomerRegistersSignsuponNewsstand, MigratingCreditCardTokens, MigratingUserfromLegacy}

/**
  * Created by tuananh on 8/17/16.
  */
object LTScenarios {

  val feeder = utility.FeederUtl.feeder

  //User
  def scn01 = scenario("Migrating User from Legacy").feed(feeder).exec(MigratingUserfromLegacy.createUser, MigratingUserfromLegacy.createUserRegistration,
    MigratingUserfromLegacy.createUserPreference, MigratingUserfromLegacy.updateUserSelections)
  def scn06 = scenario("Migrating Credit Card Tokens").feed(feeder).exec(MigratingCreditCardTokens.createUPP)
  def scn07 = scenario("Customer Registers/Signs-up on Newsstand").feed(feeder).exec(CustomerRegistersSignsuponNewsstand.createUser, CustomerRegistersSignsuponNewsstand.createUserRegistration)

  //Publisher
  def scn02 = scenario("Migrating Publisher").feed(feeder).exec(MigratingPublisher.createAccount, MigratingPublisher.createPublisher)

  //Publication
  def scn03 = scenario("Migrating Publication").feed(feeder).exec(MigratingPublication.createPublisher, MigratingPublication.createPublication)

  //Issues
  def scn08 = scenario("Creating new Issue on Admin").feed(feeder).exec(CreatingnewIssueonAdmin.createPublisher, CreatingnewIssueonAdmin.createPublication, CreatingnewIssueonAdmin.createIssue)

  //Entitlement
  def scn04 = scenario("Via Label Files").feed(feeder).exec(ViaLabelFiles.createUser, ViaLabelFiles.createOrder, ViaLabelFiles.getUser,
    ViaLabelFiles.createDeliveries, ViaLabelFiles.createEntitlement)

  //Order
  def scn05 = scenario("Purchasing Single Issue").feed(feeder).exec(PurchasingSingleIssue.createUser, PurchasingSingleIssue.createOrder, PurchasingSingleIssue.getEntitlement)

  //Subscriptions
  def scn09 = scenario("Purchasing a Subscription").feed(feeder).exec(PurchasingaSubscription.createUser, PurchasingaSubscription.createOrder, PurchasingaSubscription.getEntitlement)

  //Offers
  def scn10 = scenario("Fetching a list of Prices for a specific Issue").feed(feeder).exec(FetchingalistofPricesForaSpecificIssue.getPrices)

}
