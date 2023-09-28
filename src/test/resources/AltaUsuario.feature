Feature: Alta de nuevo usuario opencart

  @AltaUsuario
  Scenario Outline: Alta de Usuario
    Given ingresamo al sitio "<url>"
    And hacemos clic en "My Account"
    And hacemos clic en "Register"
    And ingreso FirstName
    And ingreso LastName
    And ingreso EMail
    And ingreso Telephone
    And ingreso Password "<Password>"
    And confirma Password "<Password>"
    And acepta la Privacy Policy
    When hace clic en el boton continue
    Then se valida el mensaje successfully created


    Examples:
      | url                            | Password |
      | https://opencart.abstracta.us/ | 123Pass  |