Feature: Alta de nuevo usuario opencart

  @AltaUsuario
  Scenario: Registro exitoso de usuario
    Given que una persona ingresa a la página OpenCart
    When hace clic en el dropBox "My Account" y selecciona "Register"
    And completa el formulario de registro con datos válidos
    And acepta las condiciones de "Privacy Policy" de la registracion
    And hace clic en el botón "Continue" de la registracion
    Then la página de registro debe mostrar el mensaje de "successfully created"