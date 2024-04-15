# Yummy Food

## Description
Yummy Food is a food ordering app designed to streamline the process of ordering food from various restaurants.
It provides users with a user-friendly interface to browse menus, and place orders.

## Code Structure
### Java Files
- All Java files can be found in src/main/java/edu/metrostate (MainApp.java is in this package directly)
- Migration(s) files are kept in the 'migrations' package
- Data models are kept in the 'model' package
- Interfaces and API methods are kept in the 'service' package
- UI controllers, custom button events, and click listeners are kept in the 'ui' package

### FXML and CSS
- All FXML and CSS files can be found in src/main/resources/edu/metrostate

### SQL
- All SQL files for migrations and populating the DB are in src/main/resources/migrations

## Functional and Non-Functional Requirements
### Functional
1. Able to place an order.
-  To test, simply follow the screens of the application.  Choose a category, then a restaurant, then build an order, and finally checkout.
2. Display the food and prices of Yummy Foods items.
3. Users can add items to their own cart.
-  To test (2 & 3), get to the menu screen for your chosen restaurant and add items to the cart.
4. Store restaurant information in the database.
-  To test, read the console when you first the run application.  It will display what migrations are happening.
5. Searching restaurants in the database by type of food or name.
-  To test, select a category and hit search on the landing page.
6. Allow users to checkout by entering payment information.
-  To test, get to the payment screen and then enter your information and hit checkout.

### Non-Functional
1. Responsive design for multiple screen sizes
-  The UI for this application uses flexible containers and scroll panes to ensure that it works on all screen sizes.
2. Safe and secure checkout
-  The checkout form has simple validation
3. Easy and simple to use
-  The UI was designed to be obvious and helpful.  We used the minimum amount of information, buttons, and screens.

## Installation and Usage
### Windows & Mac

1. **Clone the repository:**
    ```bash
    git clone https://github.com/olsonja88/YummyFood.git
    ```

2. **Navigate to the project directory:**
    ```bash
    cd YummyFood
    ```

3. **Compile and run the application:**
    ```bash
    ./gradlew run
    ```

## Technologies Used
- JavaFX
- Gradle

## Group Members
- John Olson
- Mike Bechtold
- Jada Wentland
