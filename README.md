## Description

This is a sample app that has two screens. 
The first is showing categorized products while the data is fetched dynamically from a web server.
And the other screen is showing details for the selected item from first screen.


## Technical Details
* The app is developed using kotlin programing language.
* The app is using SOLID principles.
* The app is supporting dark mode.
* The presenter is unit tested with 100% test coverage.
* ``AppContainer.kt`` class is used for manual dependency injection.
* Nested recycler view with recycler view pool is used to ensure smooth scrolling.
* The UI has its instrumentation tests using Espresso.
* For instrumentation tests ``StubData.kt`` class has been created with dummy data\
and needs to be passed to the recycler view in the activity before running the tests.


## App Architecture

Model View Presenter (MVP)


## Used Libraries
* Androidx
* Retrofit
* Glide
* Espresso
* Mockito

## Used API 


[API URL](http://mobcategories.s3-website-eu-west-1.amazonaws.com/)
