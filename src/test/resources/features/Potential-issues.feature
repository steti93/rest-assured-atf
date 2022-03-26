Feature: Test Exception Flow

  @Clarification
  Scenario Outline: System Administrator checks invalid post id
    Then system administrator navigates to an invalid post "<postId>" gets <expectedCode>
    Examples:
      | postId              | expectedCode |
      | invalidPostIdNumber | 404          |
      | -1                  | 404          |
      | 887464##^&          | 404          |

  @Defect
  Scenario Outline: Navigating to wrong url for comments
    When system administrator navigates to comments url and change post value with "<replacingWithValue>"
    Then system administrator expects to see a empty braces
    Examples:
      | replacingWithValue |
      | noMather           |
      | 32444444444        |
      | %^**&^%$#@#$%^&*(R |

